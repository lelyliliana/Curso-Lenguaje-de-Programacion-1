# U3_09 – Stream API: reduce

## Objetivo

Acumular elementos en un único resultado mediante reduce().

## Conceptos principales

reduce() combina elementos con una operación y una identidad: 0 para suma y 1 para producto. La identidad mantiene el valor al combinarse y es el resultado para un flujo vacío.

## Archivo principal

[U3_09_StreamReduce.java](../../src/main/java/com/lelyliliana/unidad3/U3_09_StreamReduce.java)

## ¿Qué hace el ejemplo?

Suma 2, 4, 6, 8 y 10 con un ciclo y reduce(); también calcula su producto.

## Código clave

Este ejemplo utiliza la operación `reduce()` para combinar todos los elementos de un flujo y producir un único resultado.

Primero se calcula la suma mediante programación imperativa:

```java
int sumaImperativa = 0;

for (int numero : numeros) {
    sumaImperativa += numero;
}
```

Luego se calcula mediante programación funcional:

```java
int sumaFuncional = numeros.stream()
        .reduce(0, (acumulador, numero) ->
                acumulador + numero);
```

El primer parámetro de `reduce()` es el valor inicial del acumulador.

También se utiliza `reduce()` para calcular el producto:

```java
int producto = numeros.stream()
        .reduce(1, (acumulador, numero) ->
                acumulador * numero);
```

## Flujo de ejecución

```text
Crear lista
↓
sumar con ciclo
↓
reducir con 0 y suma
↓
reducir con 1 y multiplicación
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_09_StreamReduce
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La suma es 30 y el producto 3840.

```text
STREAM: REDUCE
--------------
Suma con programación imperativa: 30
Suma con programación funcional: 30
Producto de los números: 3840
```

## Qué observar

- Ambas sumas dan 30.
- El producto utiliza identidad 1.
- Una identidad 0 en multiplicación anularía el producto.

## Experimenta

Cambia la lista a List.of() y observa suma 0 y producto 1. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo08/README.md) · [Siguiente ejemplo →](../ejemplo10/README.md)
