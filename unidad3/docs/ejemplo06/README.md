# U3_06 – Consumer, Supplier y Function

## Objetivo

Distinguir provisión de valores, consumo y transformación.

## Conceptos principales

Supplier no recibe datos y devuelve un valor con get(); Consumer recibe un dato con accept() y no retorna valor; Function transforma una entrada mediante apply().

## Archivo principal

[U3_06_ConsumerSupplierFunction.java](../../src/main/java/com/lelyliliana/unidad3/U3_06_ConsumerSupplierFunction.java)

## ¿Qué hace el ejemplo?

Obtiene un mensaje, lo imprime y calcula el cuadrado de 5.

## Código clave

Este ejemplo utiliza tres interfaces funcionales incluidas en el paquete `java.util.function`.

### Supplier

`Supplier<T>` no recibe parámetros y devuelve un valor.

```java
Supplier<String> obtenerMensaje = () ->
        "Bienvenidos a la programación funcional en Java.";
```

El valor se obtiene mediante:

```java
obtenerMensaje.get();
```

### Consumer

`Consumer<T>` recibe un dato y realiza una acción, pero no devuelve ningún valor.

```java
Consumer<String> mostrarMensaje = mensaje ->
        System.out.println(mensaje);
```

La acción se ejecuta mediante:

```java
mostrarMensaje.accept(mensaje);
```

### Function

`Function<T, R>` recibe un dato de tipo `T` y devuelve un resultado de tipo `R`.

```java
Function<Integer, Integer> calcularCuadrado = numero ->
        numero * numero;
```

La función se ejecuta mediante:

```java
calcularCuadrado.apply(numero);
```

## Flujo de ejecución

```text
Supplier.get()
↓
Consumer.accept()
↓
Function.apply(5)
↓
imprimir 25
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_06_ConsumerSupplierFunction
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El mensaje se imprime una vez y el cuadrado obtenido es 25.

```text
CONSUMER, SUPPLIER Y FUNCTION
-----------------------------
Bienvenidos a la programación funcional en Java.

Número recibido: 5
Cuadrado del número: 25
```

## Qué observar

- El mensaje pasa del proveedor al consumidor.
- El consumidor imprime como efecto secundario.
- Function produce un resultado que main puede utilizar.

## Experimenta

Cambia la Function para calcular el triple y ajusta la etiqueta de la salida. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo05/README.md) · [Siguiente ejemplo →](../ejemplo07/README.md)
