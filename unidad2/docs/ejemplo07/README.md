# U2_07 – Servidor UDP

## Objetivo

Recibir y responder un datagrama UDP.

## Conceptos principales

UDP envía datagramas sin establecer conexión ni garantizar entrega u orden. DatagramPacket conserva dirección, puerto y longitud del mensaje recibido.

## Archivo principal

[U2_07_UDP_Servidor.java](../../src/main/java/com/lelyliliana/unidad2/U2_07_UDP_Servidor.java)

## ¿Qué hace el ejemplo?

Escucha en 6000, recibe un texto UTF-8 y responde al host y puerto de origen con «Servidor UDP recibió: » más el mensaje.

## Código clave

Con `PUERTO = 6000`, el servidor crea:

```java
try (DatagramSocket socket =
             new DatagramSocket(PUERTO)) {
```

Después prepara un paquete de recepción:

```java
DatagramPacket paqueteEntrada =
        new DatagramPacket(
                buffer,
                buffer.length
        );
```

y espera mediante:

```java
socket.receive(paqueteEntrada);
```

Después responde al mismo host y puerto desde donde llegó el datagrama.

## Flujo de ejecución

```text
Iniciar servidor
↓
receive()
↓
decodificar longitud recibida
↓
responder al origen
↓
cerrar
```

## Cómo ejecutar

Usa dos terminales situadas en la **raíz del repositorio**. Requisitos: JDK 21, Maven y el puerto local `6000` disponible.

1. Compila y ejecuta primero el servidor en la terminal 1:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_07_UDP_Servidor
```

2. Espera el mensaje de escucha y ejecuta el cliente en la terminal 2:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_08_UDP_Cliente
```

Ambos terminan después de un intercambio correcto y cierran sus sockets mediante try-with-resources. Para repetir, inicia nuevamente el servidor antes del cliente. No hay entrada por teclado; si una ejecución queda esperando, detenla con `Ctrl+C` en su terminal.

Consulta también el [ejemplo complementario](../ejemplo08/README.md).

UDP no garantiza entrega ni orden. No se configuran timeout ni reintentos: si se pierde la solicitud o la respuesta, receive() puede quedar esperando indefinidamente.

## Resultado esperado

El servidor muestra «Mensaje recibido: Hola desde el cliente UDP», la IP y el puerto de origen, y «Respuesta enviada al cliente.».

## Qué observar

- El puerto del cliente no tiene por qué ser 6000.
- Se usa getLength() para no decodificar todo el búfer.
- El servidor atiende un único datagrama.

## Experimenta

Cambia el texto del cliente 08 manteniéndolo por debajo de 1024 bytes y reinicia ambos programas. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo06/README.md) · [Siguiente ejemplo →](../ejemplo08/README.md)
