# U2_04 – Cliente TCP tipo eco

## Objetivo

Realizar una solicitud y leer su respuesta por TCP.

## Conceptos principales

Socket conecta con un host y puerto. PrintWriter con autoFlush envía la línea al usar println(); BufferedReader lee la respuesta.

## Archivo principal

[U2_04_TCP_ClienteEco.java](../../src/main/java/com/lelyliliana/unidad2/U2_04_TCP_ClienteEco.java)

## ¿Qué hace el ejemplo?

Se conecta a localhost:5000, envía un texto fijo y lee el eco con prefijo; no solicita datos por teclado.

## Código clave

Este ejemplo se conecta al servidor anterior mediante:

```java
Socket socket = new Socket(HOST, PUERTO);
```

El cliente envía un mensaje y espera una respuesta.

## Flujo de ejecución

```text
Iniciar servidor 03
↓
conectar cliente 04
↓
enviar línea
↓
recibir eco
↓
cerrar
```

## Cómo ejecutar

Usa dos terminales situadas en la **raíz del repositorio**. Requisitos: JDK 21, Maven y el puerto local `5000` disponible.

1. Compila y ejecuta primero el servidor en la terminal 1:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_03_TCP_ServidorEco
```

2. Espera el mensaje de escucha y ejecuta el cliente en la terminal 2:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_04_TCP_ClienteEco
```

Ambos terminan después de un intercambio correcto y cierran sus sockets mediante try-with-resources. Para repetir, inicia nuevamente el servidor antes del cliente. No hay entrada por teclado; si una ejecución queda esperando, detenla con `Ctrl+C` en su terminal.

Consulta también el [ejemplo complementario](../ejemplo03/README.md).

Si el servidor no está escuchando, la conexión puede fallar con «Connection refused». TCP entrega un flujo ordenado o informa fallos; no garantiza que el servidor pueda procesar una solicitud en cualquier circunstancia.

## Resultado esperado

El cliente imprime «Respuesta recibida: Servidor responde: Hola desde el cliente».

## Qué observar

- El servidor debe estar listo antes del cliente.
- El mensaje está definido en el código.
- La respuesta conserva el texto enviado.

## Experimenta

Cambia «Hola desde el cliente» y comprueba la respuesta tras reiniciar el servidor. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo03/README.md) · [Siguiente ejemplo →](../ejemplo05/README.md)
