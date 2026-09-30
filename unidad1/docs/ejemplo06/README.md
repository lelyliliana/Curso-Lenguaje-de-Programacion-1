# U1_06 – Estados de un hilo

## Objetivo

Consultar estados del ciclo de vida de un hilo.

## Conceptos principales

`getState()` devuelve una observación puntual. `NEW` precede al inicio, `RUNNABLE` indica ejecución o disponibilidad, `TIMED_WAITING` espera temporal y `TERMINATED` finalización.

## Archivo principal

[U1_06_EstadosHilo.java](../../src/main/java/com/lelyliliana/unidad1/U1_06_EstadosHilo.java)

## ¿Qué hace el ejemplo?

Crea un hilo que duerme 1000 ms y consulta su estado al crearlo, iniciarlo, tras una pausa de main y después de join().

## Código clave

Java permite consultar el estado de un hilo mediante:

```java
System.out.println("Estado al crear el hilo: "
        + hilo.getState());
```

En el ejemplo se observan estados como:

### NEW

El hilo fue creado, pero todavía no se ha iniciado.

### RUNNABLE

El hilo está disponible para ser ejecutado o se encuentra en ejecución.

### TIMED_WAITING

El hilo espera durante un tiempo determinado, por ejemplo, debido a:

```java
Thread.sleep(1000);
```

### TERMINATED

El hilo terminó su ejecución.

## Flujo de ejecución

```text
Crear
↓
consultar
↓
start()
↓
pausa de main
↓
consultar
↓
join()
↓
consultar
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_06_EstadosHilo
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Las observaciones intermedias y su orden pueden variar; este ejemplo no fuerza ni muestra necesariamente todos los estados posibles de Thread.

```text
Estado al crear el hilo: NEW
Estado después de start(): RUNNABLE
Dentro del hilo. Estado actual: RUNNABLE
Estado mientras está en sleep(): TIMED_WAITING
Estado después de terminar: TERMINATED
```

El estado observado inmediatamente después de `start()` puede variar dependiendo de la planificación de la JVM.

## Qué observar

- NEW y TERMINATED delimitan el ciclo.
- La consulta posterior a start() depende de la planificación.
- La pausa de 200 ms no garantiza que se observe TIMED_WAITING.

## Experimenta

Cambia la pausa de main de 200 a 1200 ms y compara el estado observado. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo05/README.md) · [Siguiente ejemplo →](../ejemplo07/README.md)
