# U1_02 – Thread vs Runnable

## Objetivo

Separar la definición de una tarea de su hilo de ejecución.

## Conceptos principales

`Thread` es una clase de la que se puede heredar; `Runnable` es una interfaz que describe una tarea mediante `run()`.

## Archivo principal

[U1_02_ThreadVsRunnable.java](../../src/main/java/com/lelyliliana/unidad1/U1_02_ThreadVsRunnable.java)

## ¿Qué hace el ejemplo?

Ejecuta tres iteraciones con una subclase de Thread y otras tres con un Runnable entregado a un Thread.

## Código clave

Este ejemplo compara dos formas de definir tareas concurrentes en Java.

### Extendiendo Thread

```java
static class HiloConThread extends Thread {
```

La clase hereda directamente de `Thread` y redefine `run()`.

### Implementando Runnable

```java
static class TareaConRunnable implements Runnable {
```

La clase define la tarea, pero no representa por sí misma un hilo.

Posteriormente se crea el hilo:

```java
Thread hilo2 =
        new Thread(
                new TareaConRunnable("Hilo B")
        );
```

`Runnable` permite separar la tarea que se desea ejecutar del hilo que la ejecutará.

Además, una clase que implementa `Runnable` puede seguir heredando de otra clase si fuera necesario.

## Flujo de ejecución

```text
Definir ambas tareas
↓
construir sus hilos
↓
start()
↓
imprimir iteraciones
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_02_ThreadVsRunnable
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Aparecen tres líneas con «Thread -> Hilo A» y tres con «Runnable -> Hilo B»; el orden global no es determinista.

## Qué observar

- Ambas tareas se inician mediante start().
- El Runnable necesita un hilo para ejecutarse concurrentemente.
- La salida de las dos tareas puede intercalarse.

## Experimenta

Cambia el número de iteraciones de una tarea y observa que la otra conserva su comportamiento. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo01/README.md) · [Siguiente ejemplo →](../ejemplo03/README.md)
