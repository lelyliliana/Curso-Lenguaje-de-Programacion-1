# U3_01 – Programación imperativa y funcional

## Objetivo

Comparar dos maneras de calcular el mínimo de un arreglo.

## Conceptos principales

El enfoque imperativo explicita recorrido y condición; el funcional usa operaciones sobre un flujo. min() produce un resultado opcional y orElseThrow() exige que exista.

## Archivo principal

[U3_01_ImperativaVsFuncional.java](../../src/main/java/com/lelyliliana/unidad3/U3_01_ImperativaVsFuncional.java)

## ¿Qué hace el ejemplo?

Calcula el mínimo de 8, 3, 12, 5, 2 y 10 con un ciclo y con Arrays.stream().

## Código clave

Este ejemplo calcula el valor mínimo de un arreglo mediante dos enfoques.

En la programación imperativa se utiliza un ciclo y una condición para indicar paso a paso cómo debe encontrarse el valor mínimo.

En la programación funcional se utiliza:

```java
Arrays.stream(numeros)
        .min()
        .orElseThrow();
```

La solución funcional expresa directamente qué resultado se desea obtener.

## Flujo de ejecución

```text
Crear arreglo
↓
recorrer con if
↓
imprimir mínimo
↓
stream().min()
↓
imprimir mínimo
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_01_ImperativaVsFuncional
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

No vacíes el arreglo sin adaptar ambas soluciones: la primera accede a numeros[0] y la segunda exige un mínimo presente.

```text
PROGRAMACIÓN IMPERATIVA
-----------------------
El número menor es: 2

PROGRAMACIÓN FUNCIONAL
----------------------
El número menor es: 2
```

## Qué observar

- Ambos métodos devuelven 2.
- El enfoque imperativo mantiene una variable mutable.
- Ambas soluciones presuponen un arreglo no vacío.

## Experimenta

Añade -4 al arreglo y compara ambos resultados. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [Siguiente ejemplo →](../ejemplo02/README.md)
