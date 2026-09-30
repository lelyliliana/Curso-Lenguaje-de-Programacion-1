# U2_05 – TCP bidireccional

## Objetivo

Intercambiar varias solicitudes usando una misma conexión TCP.

## Conceptos principales

Una conexión bidireccional permite enviar y recibir. «salir» es una orden del protocolo de este ejemplo, no una instrucción propia de TCP.

## Archivo principal

[U2_05_TCP_Bidireccional.java](../../src/main/java/com/lelyliliana/unidad2/U2_05_TCP_Bidireccional.java)

## ¿Qué hace el ejemplo?

El cliente envía «Hola servidor», «Estamos trabajando con TCP» y «salir»; el servidor convierte los dos primeros a mayúsculas y confirma el cierre del tercero.

## Código clave

Este ejemplo permite intercambiar varios mensajes utilizando una sola conexión TCP.

El servidor permanece leyendo mensajes mediante:

```java
while ((mensaje = entrada.readLine()) != null) {
```

Cada mensaje recibe una respuesta.

Cuando llega:

```text
salir
```

la comunicación termina.

En este ejemplo cliente y servidor se ejecutan dentro de hilos diferentes para facilitar la demostración desde una sola clase.

## Flujo de ejecución

```text
Arrancar hilo servidor en 5001
↓
cliente espera 500 ms
↓
conectar
↓
intercambiar tres mensajes
↓
cerrar y join()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_05_TCP_Bidireccional
```

Ejecuta **una sola vez esta clase**, con el puerto `5001` disponible: el programa inicia primero el hilo servidor y retrasa 500 ms el inicio de la conexión de los clientes locales. No requiere otra terminal ni datos por teclado. Esa pausa facilita la demostración, pero no garantiza que el servidor esté listo si el equipo está muy cargado.

El cliente envía salir automáticamente; recibe la confirmación, se cierran los recursos y main espera ambos hilos. Si hay un error y queda una espera pendiente, detén la ejecución con `Ctrl+C`, comprueba el puerto y vuelve a ejecutar.

## Resultado esperado

El cliente recibe «Respuesta del servidor: HOLA SERVIDOR», «Respuesta del servidor: ESTAMOS TRABAJANDO CON TCP» y «Conexión finalizada.». Al final aparece «Comunicación finalizada.»; otros mensajes pueden intercalarse.

## Qué observar

- Se reutiliza una sola conexión.
- El cliente espera respuesta por cada envío.
- salir también recibe una respuesta antes del cierre.

## Experimenta

Añade un mensaje al arreglo antes de salir y observa el intercambio adicional. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo04/README.md) · [Siguiente ejemplo →](../ejemplo06/README.md)
