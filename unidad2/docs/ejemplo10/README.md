# U2_10 – Envío de objetos por TCP

## Objetivo

Transferir un objeto serializado por una conexión TCP.

## Conceptos principales

Los flujos de objetos codifican datos Java sobre el socket. El orden complementario de creación de ObjectInputStream y ObjectOutputStream evita que ambos extremos esperen primero la cabecera de entrada.

## Archivo principal

[U2_10_EnvioObjetosTCP.java](../../src/main/java/com/lelyliliana/unidad2/U2_10_EnvioObjetosTCP.java)

## ¿Qué hace el ejemplo?

El cliente envía un Estudiante interno con María, Ingeniería de Sistemas y 4.8; el servidor lo imprime y devuelve una cadena de confirmación.

## Código clave

Este ejemplo integra:

- TCP.
- Sockets.
- Serialización.
- `ObjectInputStream`.
- `ObjectOutputStream`.

El cliente envía un objeto:

```java
salida.writeObject(estudiante);
```

El servidor lo recupera mediante:

```java
Estudiante estudiante =
        (Estudiante) entrada.readObject();
```

Luego el servidor devuelve una confirmación al cliente.

## Flujo de ejecución

```text
Hilo servidor en 6001
↓
cliente espera 500 ms
↓
conectar
↓
enviar objeto
↓
leer y confirmar
↓
join()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_10_EnvioObjetosTCP
```

Ejecuta **una sola vez esta clase**, con el puerto `6001` disponible: el programa inicia primero el hilo servidor y retrasa 500 ms el inicio de la conexión de los clientes locales. No requiere otra terminal ni datos por teclado. Esa pausa facilita la demostración, pero no garantiza que el servidor esté listo si el equipo está muy cargado.

Tras recibir la confirmación se cierran los flujos y sockets; main espera al servidor y al cliente. Si hay un error y queda una espera pendiente, detén la ejecución con `Ctrl+C`, comprueba el puerto y vuelve a ejecutar.

## Resultado esperado

El servidor muestra «María | Programa: Ingeniería de Sistemas | Nota: 4.8»; el cliente recibe «Objeto recibido correctamente» y termina con «Transferencia de objeto finalizada.». El intercalado de mensajes puede variar.

## Qué observar

- Ambos extremos conocen la misma clase serializable.
- El servidor crea primero su flujo de entrada y el cliente el de salida.
- La respuesta también se envía como objeto.

## Experimenta

Cambia los atributos del estudiante enviado y comprueba su representación en el servidor. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo09/README.md) · [Siguiente ejemplo →](../ejemplo11/README.md)
