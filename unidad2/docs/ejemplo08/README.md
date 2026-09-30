# U2_08 – Cliente UDP

## Objetivo

Enviar un datagrama y esperar una respuesta UDP.

## Conceptos principales

DatagramSocket sin puerto explícito usa un puerto local asignado por el sistema. send() envía el paquete y receive() espera otro datagrama.

## Archivo principal

[U2_08_UDP_Cliente.java](../../src/main/java/com/lelyliliana/unidad2/U2_08_UDP_Cliente.java)

## ¿Qué hace el ejemplo?

Envía «Hola desde el cliente UDP» a localhost:6000 y recibe el eco con prefijo en su socket.

## Código clave

El cliente construye un datagrama:

```java
DatagramPacket paqueteSalida =
        new DatagramPacket(
                datos,
                datos.length,
                direccionServidor,
                PUERTO
        );
```

y lo envía mediante:

```java
socket.send(paqueteSalida);
```

Después espera otro datagrama como respuesta.

## Flujo de ejecución

```text
Iniciar servidor 07
↓
cliente 08 envía datagrama
↓
espera respuesta
↓
imprime
↓
cierra
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

Consulta también el [ejemplo complementario](../ejemplo07/README.md).

UDP no garantiza entrega ni orden. No se configuran timeout ni reintentos: si se pierde la solicitud o la respuesta, receive() puede quedar esperando indefinidamente.

## Resultado esperado

El cliente imprime «Respuesta recibida: Servidor UDP recibió: Hola desde el cliente UDP» si recibe el datagrama de respuesta.

## Qué observar

- No hay accept() ni conexión TCP.
- El paquete especifica host y puerto de destino.
- El código no configura timeout ni reintentos.

## Experimenta

Cambia el texto enviado y compara la respuesta con la del ejemplo TCP. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo07/README.md) · [Siguiente ejemplo →](../ejemplo09/README.md)
