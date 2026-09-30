# U3_05 – Uso de Predicate

## Objetivo

Expresar condiciones reutilizables con Predicate.

## Conceptos principales

Predicate<T> evalúa un dato y devuelve boolean. filter() conserva los elementos que satisfacen el predicado sin modificar la colección original.

## Archivo principal

[U3_05_Predicate.java](../../src/main/java/com/lelyliliana/unidad3/U3_05_Predicate.java)

## ¿Qué hace el ejemplo?

Filtra por separado pares y mayores que diez de la lista 3, 8, 11, 14, 19 y 22.

## Código clave

Este ejemplo utiliza la interfaz funcional `Predicate<T>`.

`Predicate` recibe un dato y evalúa una condición. Su resultado siempre es un valor booleano.

En el ejemplo se crean dos condiciones:

```java
Predicate<Integer> esPar = numero -> numero % 2 == 0;
```

```java
Predicate<Integer> esMayorQueDiez = numero -> numero > 10;
```

Las condiciones se utilizan dentro de `filter()` para seleccionar los elementos que las cumplen.

```java
numeros.stream()
        .filter(esPar)
        .forEach(System.out::println);
```

## Flujo de ejecución

```text
Definir dos predicados
↓
crear flujo y filtrar pares
↓
crear otro flujo y filtrar mayores de diez
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_05_Predicate
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Los pares son 8, 14 y 22; los mayores de diez son 11, 14, 19 y 22.

```text
USO DE PREDICATE
----------------
Números pares:
8
14
22

Números mayores que 10:
11
14
19
22
```

## Qué observar

- Cada filtro usa un flujo nuevo.
- 14 y 22 satisfacen ambos predicados.
- Las dos consultas son independientes.

## Experimenta

Combina las condiciones con esPar.and(esMayorQueDiez) y observa 14 y 22. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo04/README.md) · [Siguiente ejemplo →](../ejemplo06/README.md)
