# U2_02 – Componentes de una URL

## Objetivo

Reconocer los componentes de una URL sin conectarse al recurso.

## Conceptos principales

URI identifica un recurso; URL permite consultar protocolo, host, puerto, ruta, consulta y fragmento. El puerto explícito se distingue del predeterminado del protocolo.

## Archivo principal

[U2_02_URL.java](../../src/main/java/com/lelyliliana/unidad2/U2_02_URL.java)

## ¿Qué hace el ejemplo?

Convierte una URI en URL y muestra sus siete componentes; no realiza solicitudes HTTP.

## Código clave

Este ejemplo analiza diferentes partes de una URL.

Se utiliza una dirección similar a:

```text
https://www.ejemplo.com:443/cursos/java?unidad=2#network
```

y se consultan componentes como:

- Protocolo.
- Host.
- Puerto.
- Puerto por defecto.
- Ruta.
- Consulta.
- Referencia.

La URL se obtiene desde un objeto `URI`:

```java
URL direccion = java.net.URI.create(
        "https://www.ejemplo.com:443/cursos/java?unidad=2#network"
).toURL();
```

## Flujo de ejecución

```text
Crear URI
↓
convertir a URL
↓
consultar componentes
↓
imprimir
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_02_URL
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La salida de componentes es determinista para la URL incluida.

```text
COMPONENTES DE UNA URL
----------------------
Protocolo: https
Host: www.ejemplo.com
Puerto: 443
Puerto por defecto: 443
Ruta: /cursos/java
Consulta: unidad=2
Referencia: network
```

## Qué observar

- La consulta unidad=2 está separada de la ruta.
- network es el fragmento.
- No se abre ninguna conexión al dominio de ejemplo.

## Experimenta

Quita :443 y compara getPort() con getDefaultPort(): el primero devuelve -1 cuando no hay puerto explícito. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo01/README.md) · [Siguiente ejemplo →](../ejemplo03/README.md)
