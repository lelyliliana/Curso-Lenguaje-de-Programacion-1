# U3_04 – Expresiones lambda

## Objetivo

Relacionar parámetros y retorno de lambdas con sus interfaces.

## Conceptos principales

Una lambda implementa el método abstracto de su interfaz destino. Mensaje no recibe parámetros; Saludo recibe uno y Suma recibe dos y devuelve int.

## Archivo principal

[U3_04_ExpresionesLambda.java](../../src/main/java/com/lelyliliana/unidad3/U3_04_ExpresionesLambda.java)

## ¿Qué hace el ejemplo?

Ejecuta un mensaje, saluda a Leli y suma 8 con 5 mediante tres interfaces declaradas en el archivo.

## Código clave

Este ejemplo presenta expresiones lambda con diferentes cantidades de parámetros.

### Lambda sin parámetros

```java
Mensaje mensaje = () ->
        System.out.println("Ejemplo de lambda sin parámetros.");
```

### Lambda con un parámetro

```java
Saludo saludo = nombre ->
        System.out.println("Hola, " + nombre + ".");
```

### Lambda con dos parámetros

```java
Suma suma = (numero1, numero2) ->
        numero1 + numero2;
```

## Flujo de ejecución

```text
Crear tres lambdas
↓
mostrar()
↓
saludar("Leli")
↓
calcular(8, 5)
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_04_ExpresionesLambda
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La suma original da 13.

```text
EXPRESIONES LAMBDA
------------------
Ejemplo de lambda sin parámetros.
Hola, Leli.
Resultado de la suma: 13
```

## Qué observar

- Los paréntesis vacíos indican ausencia de parámetros.
- Los parámetros de suma corresponden a su contrato.
- Mostrar y saludar devuelven void, calcular devuelve int.

## Experimenta

Cambia los valores pasados a suma.calcular() y el nombre del saludo. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo03/README.md) · [Siguiente ejemplo →](../ejemplo05/README.md)
