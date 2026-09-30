# U1_01 – Hilo básico con Thread

## Objetivo

Crear e iniciar hilos mediante una subclase de Thread.

## Conceptos principales

`Thread` representa un hilo; `run()` contiene su tarea y `start()` solicita su inicio. Concurrencia significa progreso de tareas en un mismo intervalo, sin exigir simultaneidad.

## Archivo principal

[U1_01_HiloBasico.java](../../src/main/java/com/lelyliliana/unidad1/U1_01_HiloBasico.java)

## ¿Qué hace el ejemplo?

Crea Hilo A y Hilo B, cada uno con cinco iteraciones; main imprime su inicio y su fin sin esperar explícitamente a ambos.

## Código clave

Este ejemplo presenta una de las formas más directas de crear un hilo en Java: extender la clase `Thread`.

La clase redefine el método:

```java
@Override
public void run() {
    for (int i = 1; i <= 5; i++) {
        System.out.println(nombre + " - iteración " + i);
    }
}
```

Luego se crean dos objetos:

```java
U1_01_HiloBasico hilo1 =
        new U1_01_HiloBasico("Hilo A");

U1_01_HiloBasico hilo2 =
        new U1_01_HiloBasico("Hilo B");
```

Los hilos se inician mediante:

```java
hilo1.start();
hilo2.start();
```

`start()` solicita a la JVM que inicie un nuevo hilo de ejecución y posteriormente invoque su método `run()`.

## Flujo de ejecución

```text
main crea dos hilos
↓
start()
↓
cada hilo imprime cinco iteraciones
↓
terminan
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_01_HiloBasico
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Se imprimen cinco iteraciones por tarea; su intercalado y la posición del mensaje final de main pueden variar.

## Qué observar

- El orden interno de las cinco iteraciones de cada hilo.
- La posición de «Fin del hilo principal» respecto a las tareas.
- La JVM sigue activa hasta que terminan estos hilos no daemon.

## Experimenta

Cambia el límite de cinco a tres iteraciones y compara varias ejecuciones. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [Siguiente ejemplo →](../ejemplo02/README.md)
