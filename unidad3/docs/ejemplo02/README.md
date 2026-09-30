# U3_02 – Función pura

## Objetivo

Identificar un cálculo sin efectos secundarios.

## Conceptos principales

Una función pura depende de su entrada y no modifica estado externo; imprimir por consola sí es un efecto, realizado aquí fuera del método de cálculo.

## Archivo principal

[U3_02_FuncionPura.java](../../src/main/java/com/lelyliliana/unidad3/U3_02_FuncionPura.java)

## ¿Qué hace el ejemplo?

Llama dos veces a calcularCuadrado(6) y muestra ambos resultados desde main.

## Código clave

Este ejemplo presenta una función pura mediante el método:

```java
public static int calcularCuadrado(int numero) {
    return numero * numero;
}
```

Una función pura cumple dos condiciones principales:

- Para una misma entrada siempre produce la misma salida.
- No modifica datos externos ni genera efectos secundarios.

En el ejemplo, el valor `6` se envía dos veces al método y en ambos casos se obtiene como resultado `36`.

## Flujo de ejecución

```text
Elegir 6
↓
calcular cuadrado dos veces
↓
imprimir 36 y 36
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_02_FuncionPura
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La pureza corresponde a calcularCuadrado(), no a las impresiones de main.

```text
FUNCIÓN PURA
------------
Número recibido: 6
Primer resultado: 36
Segundo resultado: 36
```

## Qué observar

- Las llamadas tienen la misma entrada.
- El cálculo no imprime ni modifica variables externas.
- main se encarga de la salida.

## Experimenta

Cambia numero por -3 y compara los dos resultados. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo01/README.md) · [Siguiente ejemplo →](../ejemplo03/README.md)
