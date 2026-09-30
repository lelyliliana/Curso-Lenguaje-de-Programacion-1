# U3_08 – Stream API: filter y map

## Objetivo

Encadenar selección y transformación de elementos.

## Conceptos principales

filter() selecciona y map() transforma; son operaciones intermedias. forEach() es terminal y activa el recorrido del flujo.

## Archivo principal

[U3_08_StreamFilterMap.java](../../src/main/java/com/lelyliliana/unidad3/U3_08_StreamFilterMap.java)

## ¿Qué hace el ejemplo?

Muestra la lista original, sus números pares y el cuadrado de cada par.

## Código clave

Este ejemplo presenta dos operaciones intermedias de Stream API.

- `filter()`: selecciona los elementos que cumplen una condición.
- `map()`: transforma cada elemento del flujo.

Primero se filtran los números pares:

```java
numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .forEach(System.out::println);
```

Después se filtran los números pares y se calcula el cuadrado de cada uno:

```java
numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .map(numero -> numero * numero)
        .forEach(System.out::println);
```

## Flujo de ejecución

```text
Lista
↓
filter(par)
↓
map(cuadrado)
↓
forEach(imprimir)
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_08_StreamFilterMap
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Los pares 2, 8, 14 y 20 generan 4, 64, 196 y 400.

```text
STREAM: FILTER Y MAP
--------------------
Lista original:
2
5
8
11
14
17
20

Números pares:
2
8
14
20

Cuadrado de los números pares:
4
64
196
400
```

## Qué observar

- El filtro precede al cálculo del cuadrado.
- La lista original no se modifica.
- Cada consulta vuelve a llamar a stream().

## Experimenta

Cambia la transformación a numero * 2 y compara con los cuadrados. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo07/README.md) · [Siguiente ejemplo →](../ejemplo09/README.md)
