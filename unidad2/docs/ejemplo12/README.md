# U2_12 – Ejercicio integrador de redes

## Objetivo

Integrar conexiones, tareas concurrentes y procesamiento de solicitudes.

## Conceptos principales

Un protocolo de aplicación define aquí dos líneas: nombre y operación. Un switch genera la respuesta; cada conexión tiene un Runnable AtenderCliente.

## Archivo principal

[U2_12_IntegradorRedes.java](../../src/main/java/com/lelyliliana/unidad2/U2_12_IntegradorRedes.java)

## ¿Qué hace el ejemplo?

En 7000 acepta tres clientes: Ana envía saludo, Carlos estado y María hora; el servidor procesa cada par de líneas y devuelve una respuesta fija según la operación.

## Código clave

Este ejemplo integra:

- `ServerSocket`.
- `Socket`.
- TCP.
- Varios clientes.
- Hilos.
- `Runnable`.
- Procesamiento de solicitudes.
- Respuestas del servidor.

El servidor acepta varias conexiones:

```java
Socket socket =
        serverSocket.accept();
```

y crea un hilo para cada cliente:

```java
Thread hiloCliente =
        new Thread(
                new AtenderCliente(socket),
                "Atencion-" + i
        );
```

Cada cliente envía:

- Nombre.
- Tipo de operación.

El servidor procesa operaciones como:

```text
saludo
hora
estado
```

mediante una expresión `switch`.

## Flujo de ejecución

```text
Iniciar servidor
↓
esperar 500 ms
↓
tres clientes envían nombre y operación
↓
manejadores responden
↓
cierre y join()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_12_IntegradorRedes
```

Ejecuta **una sola vez esta clase**, con el puerto `7000` disponible: el programa inicia primero el hilo servidor y retrasa 500 ms el inicio de la conexión de los clientes locales. No requiere otra terminal ni datos por teclado. Esa pausa facilita la demostración, pero no garantiza que el servidor esté listo si el equipo está muy cargado.

Tras aceptar tres conexiones, el servidor cierra la escucha. Los manejadores responden y cierran los sockets; el proceso termina al finalizar los hilos. Si hay un error y queda una espera pendiente, detén la ejecución con `Ctrl+C`, comprueba el puerto y vuelve a ejecutar.

## Resultado esperado

Ana recibe «Hola, Ana. Bienvenido al servidor.», Carlos «Servidor activo y atendiendo solicitudes.» y María «Solicitud de hora recibida correctamente.». El orden varía; al final aparece «Ejemplo integrador finalizado.».

## Qué observar

- Cada solicitud contiene dos líneas.
- hora confirma la solicitud pero no consulta el reloj.
- Los nombres Atencion-N dependen del orden de conexión.

## Experimenta

Cambia la operación de un cliente a una no reconocida para observar la rama default. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo11/README.md)
