# U3_10 – Stream API: sorted y distinct

## Objetivo

Eliminar duplicados y ordenar un flujo.

## Conceptos principales

distinct() conserva valores distintos según igualdad; sorted() aplica orden natural o un Comparator. Estas operaciones no reordenan la lista original.

## Archivo principal

[U3_10_StreamSortedDistinct.java](../../src/main/java/com/lelyliliana/unidad3/U3_10_StreamSortedDistinct.java)

## ¿Qué hace el ejemplo?

Muestra los números originales, los valores sin repetir y esos valores en orden ascendente y descendente.

## Código clave

Este ejemplo utiliza las operaciones:

- `distinct()`: elimina los elementos repetidos.
- `sorted()`: ordena los elementos.
- `Comparator.reverseOrder()`: permite ordenar de mayor a menor.

Para eliminar valores repetidos:

```java
numeros.stream()
        .distinct()
        .forEach(System.out::println);
```

Para ordenar de menor a mayor:

```java
numeros.stream()
        .distinct()
        .sorted()
        .forEach(System.out::println);
```

Para ordenar de mayor a menor:

```java
numeros.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
```

## Flujo de ejecución

```text
Lista
↓
distinct()
↓
imprimir; nuevos flujos
↓
distinct()
↓
sorted()
↓
imprimir
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_10_StreamSortedDistinct
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Sin repetir: 8, 3, 5, 2, 10. Ascendente: 2, 3, 5, 8, 10. Descendente: 10, 8, 5, 3, 2.

```text
STREAM: SORTED Y DISTINCT
-------------------------
Lista original:
8
3
5
8
2
5
10
3

Valores sin repetir:
8
3
5
2
10

Valores ordenados de menor a mayor:
2
3
5
8
10

Valores ordenados de mayor a menor:
10
8
5
3
2
```

## Qué observar

- distinct() conserva el orden de aparición en este flujo ordenado.
- sorted() cambia el orden del resultado.
- reverseOrder() invierte el criterio natural.

## Experimenta

Añade otro 8 y un 1 a List.of(...) y observa cada sección. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo09/README.md) · [Siguiente ejemplo →](../ejemplo11/README.md)
