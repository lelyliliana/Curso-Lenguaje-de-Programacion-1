# U1_03 – start() vs run()

## Objetivo

Distinguir una llamada ordinaria a run() de iniciar un hilo con start().

## Conceptos principales

`run()` ejecutado directamente usa el hilo llamador; `start()` crea una ejecución independiente que invoca `run()`.

## Archivo principal

[U1_03_StartVsRun.java](../../src/main/java/com/lelyliliana/unidad1/U1_03_StartVsRun.java)

## ¿Qué hace el ejemplo?

Ejecuta A y B directamente en main; después inicia C y D en hilos nuevos y muestra el nombre del hilo real.

## Código clave

Este ejemplo muestra una diferencia fundamental.

Cuando se invoca directamente:

```java
hilo1.run();
hilo2.run();
```

no se crea un nuevo hilo.

El método se ejecuta como una llamada normal dentro del hilo actual.

Por esta razón, al mostrar:

```java
Thread.currentThread().getName()
```

la ejecución mediante `run()` aparecerá asociada normalmente al hilo:

```text
main
```

En cambio:

```java
hilo3.start();
hilo4.start();
```

inicia un nuevo hilo de ejecución.

En ese caso pueden aparecer nombres como:

```text
Thread-2
Thread-3
```

## Flujo de ejecución

```text
run() de A
↓
run() de B
↓
start() de C y D
↓
ejecución concurrente
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_03_StartVsRun
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

A y B completan tres iteraciones cada una en main; C y D completan otras tres con orden variable. Los sufijos de Thread no deben asumirse fijos.

## Qué observar

- A y B muestran main y se ejecutan en secuencia.
- C y D muestran nombres de hilos distintos de main.
- El orden de C y D puede cambiar.

## Experimenta

Sustituye una llamada directa a run() por start() y compara los nombres impresos. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo02/README.md) · [Siguiente ejemplo →](../ejemplo04/README.md)
