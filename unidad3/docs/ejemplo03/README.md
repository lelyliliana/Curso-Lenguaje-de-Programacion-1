# U3_03 – Interfaz funcional

## Objetivo

Definir un contrato funcional e implementarlo con una lambda.

## Conceptos principales

Una interfaz funcional tiene un único método abstracto. @FunctionalInterface permite que el compilador verifique esta condición.

## Archivo principal

[U3_03_InterfazFuncional.java](../../src/main/java/com/lelyliliana/unidad3/U3_03_InterfazFuncional.java)

## ¿Qué hace el ejemplo?

Declara OperacionMatematica en el mismo archivo y asigna una lambda que duplica 7.

## Código clave

Este ejemplo presenta una interfaz funcional llamada `OperacionMatematica`.

```java
@FunctionalInterface
interface OperacionMatematica {

    int calcular(int numero);
}
```

Una interfaz funcional:

- Contiene un único método abstracto.
- Puede identificarse con la anotación `@FunctionalInterface`.
- Puede implementarse mediante una expresión lambda.

En el ejemplo se crea una expresión lambda que duplica el número recibido:

```java
OperacionMatematica duplicar = numero -> numero * 2;
```

## Flujo de ejecución

```text
Definir contrato calcular(int)
↓
asignar lambda
↓
invocar calcular(7)
↓
imprimir 14
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_03_InterfazFuncional
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El resultado original al duplicar 7 es 14.

```text
INTERFAZ FUNCIONAL
------------------
Número recibido: 7
Resultado al duplicar: 14
```

## Qué observar

- La firma de la lambda coincide con el contrato.
- El comportamiento se ejecuta al llamar calcular().
- La interfaz y la clase principal comparten archivo.

## Experimenta

Sustituye numero * 2 por numero * 3 y vuelve a compilar. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo02/README.md) · [Siguiente ejemplo →](../ejemplo04/README.md)
