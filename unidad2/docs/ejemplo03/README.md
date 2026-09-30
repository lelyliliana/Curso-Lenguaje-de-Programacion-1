# U2_03 – Servidor TCP tipo eco

## Objetivo

Comprender la espera y respuesta de un servidor TCP de una sola conexión.

## Conceptos principales

ServerSocket escucha conexiones; accept() espera un cliente. TCP transporta un flujo ordenado; readLine() delimita aquí los mensajes por salto de línea.

## Archivo principal

[U2_03_TCP_ServidorEco.java](../../src/main/java/com/lelyliliana/unidad2/U2_03_TCP_ServidorEco.java)

## ¿Qué hace el ejemplo?

Escucha en 5000, acepta un cliente, lee «Hola desde el cliente» y responde con el prefijo «Servidor responde: ».

## Código clave

Este ejemplo crea un servidor TCP básico.

La clase principal utilizada es:

```java
ServerSocket
```

La constante `PUERTO` vale `5000`. El servidor queda escuchando en ese puerto:

```java
try (ServerSocket servidor = new ServerSocket(PUERTO)) {
```

Después espera una conexión:

```java
Socket cliente =
        servidor.accept();
```

`accept()` bloquea el programa hasta que un cliente se conecte.

Una vez establecida la conexión, se utilizan flujos para leer y escribir datos.

## Flujo de ejecución

```text
Servidor escucha
↓
cliente conecta
↓
envía una línea
↓
servidor responde
↓
ambos cierran
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

Consulta también el [ejemplo complementario](../ejemplo04/README.md).

Si el servidor no está escuchando, la conexión puede fallar con «Connection refused». TCP entrega un flujo ordenado o informa fallos; no garantiza que el servidor pueda procesar una solicitud en cualquier circunstancia.

## Resultado esperado

En el servidor se observa «Mensaje recibido: Hola desde el cliente» y «Respuesta enviada.». La IP del cliente depende del entorno.

## Qué observar

- accept() espera hasta la conexión.
- println() delimita y envía la línea.
- El servidor atiende un solo intercambio y termina.

## Experimenta

Cambia el mensaje en el cliente del ejemplo 04 y reinicia ambos programas. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo02/README.md) · [Siguiente ejemplo →](../ejemplo04/README.md)
