# U1_05 – Uso de join()

## Objetivo

Esperar la terminación de otros hilos antes de continuar.

## Conceptos principales

`join()` hace esperar al hilo llamador hasta que termina el hilo objetivo; no inicia ese hilo ni impone el orden de sus operaciones.

## Archivo principal

[U1_05_Join.java](../../src/main/java/com/lelyliliana/unidad1/U1_05_Join.java)

## ¿Qué hace el ejemplo?

Inicia dos tareas de tres iteraciones con pausas de 400 ms y espera ambas antes del mensaje final.

## Código clave

`join()` permite que un hilo espere hasta que otro termine.

En el ejemplo:

```java
hilo1.start();
hilo2.start();
```

los dos hilos comienzan su ejecución.

Después el hilo principal ejecuta:

```java
hilo1.join();
hilo2.join();
```

Esto hace que el hilo principal espere a que ambos finalicen.

Solo entonces continúa y muestra:

```text
Los dos hilos terminaron. Continúa el hilo principal.
```

## Flujo de ejecución

```text
start() de ambos
↓
main espera con join()
↓
tareas terminan
↓
main continúa
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_05_Join
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La garantía descrita corresponde a una ejecución sin interrupciones de main: si se interrumpe un join(), el catch permite continuar hasta el mensaje final.

## Qué observar

- Los dos start() ocurren antes de los join().
- Las tareas pueden intercalarse.
- Sin interrupciones, el mensaje final aparece después de ambas terminaciones.

## Experimenta

Cambia la pausa de una tarea y comprueba que main espera también a la más lenta. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo04/README.md) · [Siguiente ejemplo →](../ejemplo06/README.md)
