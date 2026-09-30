# U2_01 – InetAddress

## Objetivo

Consultar nombres y direcciones mediante InetAddress.

## Conceptos principales

Un host se identifica por nombre o dirección IP. InetAddress representa una dirección; localhost corresponde a la interfaz de retorno local.

## Archivo principal

[U2_01_InetAddress.java](../../src/main/java/com/lelyliliana/unidad2/U2_01_InetAddress.java)

## ¿Qué hace el ejemplo?

Consulta el equipo local y localhost e imprime nombre e IP; captura UnknownHostException.

## Código clave

Este ejemplo utiliza la clase:

```java
java.net.InetAddress
```

para consultar información del equipo local.

Se obtiene el host mediante:

```java
InetAddress equipoLocal =
        InetAddress.getLocalHost();
```

Después pueden consultarse datos como:

`equipoLocal.getHostName()`

y:

`equipoLocal.getHostAddress()`

También se consulta:

```text
localhost
```

mediante:

```java
InetAddress.getByName("localhost");
```

## Flujo de ejecución

```text
Resolver equipo local
↓
imprimir nombre e IP
↓
resolver localhost
↓
imprimir
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_01_InetAddress
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Se muestran nombres y direcciones propios del equipo. Si no se resuelve su nombre, aparece «No fue posible obtener la información de red.»; no existe una IP universal para esta salida.

En algunos sistemas Linux, el nombre del equipo puede resolverse a `127.0.1.1`, mientras que `localhost` suele resolverse a `127.0.0.1` o a la dirección IPv6 `::1`. Estos valores dependen de la configuración local.

## Qué observar

- El nombre y la IP dependen del sistema.
- localhost puede resolverse a IPv4 o IPv6.
- La resolución del nombre local puede fallar.

## Experimenta

Cambia localhost por 127.0.0.1 y compara los datos obtenidos. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [Siguiente ejemplo →](../ejemplo02/README.md)
