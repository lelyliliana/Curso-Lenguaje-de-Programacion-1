# U2_06 – Servidor TCP multicliente

## Objetivo

Atender conexiones TCP con una tarea independiente por cliente.

## Conceptos principales

El hilo de aceptación recibe conexiones; un Runnable manejador procesa cada socket. La concurrencia permite avanzar en varias atenciones sin exigir simultaneidad.

## Archivo principal

[U2_06_TCP_Multicliente.java](../../src/main/java/com/lelyliliana/unidad2/U2_06_TCP_Multicliente.java)

## ¿Qué hace el ejemplo?

Arranca un servidor en 5002 y tres clientes que envían «Mensaje del primer cliente», «Mensaje del segundo cliente» y «Mensaje del tercer cliente»; cada respuesta incluye el hilo manejador y el texto en mayúsculas.

## Código clave

Este ejemplo muestra cómo un servidor puede atender varios clientes.

Por cada conexión aceptada se crea un nuevo hilo:

```java
Thread hiloCliente =
        new Thread(
                new ManejadorCliente(cliente),
                "Cliente-" + i
        );
```

Cada cliente puede ser atendido independientemente.

Esto integra conceptos de:

- Sockets.
- TCP.
- Cliente-servidor.
- Concurrencia.
- `Runnable`.
- Hilos.

## Flujo de ejecución

```text
Servidor escucha
↓
tres clientes conectan
↓
accept() crea tres manejadores
↓
cada uno responde
↓
cierre
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_06_TCP_Multicliente
```

Ejecuta **una sola vez esta clase**, con el puerto `5002` disponible: el programa inicia primero el hilo servidor y retrasa 500 ms el inicio de la conexión de los clientes locales. No requiere otra terminal ni datos por teclado. Esa pausa facilita la demostración, pero no garantiza que el servidor esté listo si el equipo está muy cargado.

El servidor acepta exactamente tres conexiones. Cada manejador responde una vez y cierra su socket; el proceso termina al finalizar los hilos. Si hay un error y queda una espera pendiente, detén la ejecución con `Ctrl+C`, comprueba el puerto y vuelve a ejecutar.

## Resultado esperado

Cada cliente recibe «Respuesta desde Cliente-N: MENSAJE DEL ... CLIENTE» y aparece «Todos los clientes fueron atendidos.». El orden y la asignación de manejadores varían.

## Qué observar

- El servidor acepta exactamente tres conexiones.
- Cliente-1, Cliente-2 y Cliente-3 nombran manejadores según llegada.
- No hay asociación fija entre Cliente-A y Cliente-1.

## Experimenta

Cambia los textos de los tres clientes sin cambiar su cantidad. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo05/README.md) · [Siguiente ejemplo →](../ejemplo07/README.md)
