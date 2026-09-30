# U2_09 – Serialización de objetos

## Objetivo

Guardar y reconstruir el estado de un objeto Java.

## Conceptos principales

Serializable habilita la serialización; ObjectOutputStream escribe el objeto y ObjectInputStream lo reconstruye. serialVersionUID identifica la versión de su representación serializada.

## Archivo principal

[U2_09_Serializacion.java](../../src/main/java/com/lelyliliana/unidad2/U2_09_Serializacion.java)

## ¿Qué hace el ejemplo?

Crea un Estudiante interno con Ana, Ingeniería de Sistemas y 4.5, lo guarda en estudiante.dat y lo recupera.

## Código clave

La clase `Estudiante` implementa:

```java
Serializable
```

El objeto se guarda mediante:

```java
ObjectOutputStream
```

y:

`writeObject()`

Por ejemplo:

```java
salida.writeObject(estudiante);
```

Después se recupera mediante:

```java
ObjectInputStream
```

y:

```java
readObject()
```

## Flujo de ejecución

```text
Crear objeto
↓
abrir archivo y serializar
↓
cerrar salida
↓
deserializar
↓
imprimir
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad2 compile
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_09_Serializacion
```

Se crea o sobrescribe `estudiante.dat` en la raíz al usar estos comandos. El archivo permanece después de la ejecución; puedes eliminarlo cuando termines de inspeccionarlo. No se abre ningún puerto.

## Resultado esperado

Aparecen «Objeto serializado correctamente.» y «Ana | Programa: Ingeniería de Sistemas | Nota: 4.5». estudiante.dat se crea o sobrescribe en el directorio de ejecución; se necesita permiso de escritura y no se elimina automáticamente.

## Qué observar

- El archivo es binario, no texto.
- Se recuperan los tres atributos.
- Esta clase Estudiante es interna y distinta del modelo de la Unidad 3.

## Experimenta

Cambia la nota de Ana y vuelve a ejecutar para observar el dato recuperado. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 2](../../README.md) · [← Ejemplo anterior](../ejemplo08/README.md) · [Siguiente ejemplo →](../ejemplo10/README.md)
