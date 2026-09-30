# U1_10 – wait() y notifyAll()

## Objetivo

Coordinar productor y consumidor mediante una condición compartida.

## Conceptos principales

`wait()` libera el monitor mientras espera y lo readquiere antes de continuar; `notifyAll()` notifica a quienes esperan, pero no les entrega inmediatamente el monitor. El while vuelve a verificar la condición.

## Archivo principal

[U1_10_WaitNotify.java](../../src/main/java/com/lelyliliana/unidad1/U1_10_WaitNotify.java)

## ¿Qué hace el ejemplo?

El consumidor espera un mensaje en una bandeja; el productor lo publica y notifica; ambos terminan antes del mensaje final.

## Código clave

Este ejemplo presenta comunicación y coordinación entre hilos mediante un esquema productor-consumidor sencillo.

El consumidor comprueba si existe un mensaje disponible:

```java
while (!disponible) {
    try {
        wait();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return null;
    }
}
```

Si todavía no existe, ejecuta:

```java
wait();
```

`wait()`:

- Suspende el hilo.
- Libera el bloqueo del objeto.
- Permite que otro hilo pueda entrar al método sincronizado.

El productor guarda el mensaje y ejecuta:

```java
notifyAll();
```

`notifyAll()` despierta a los hilos que esperan sobre el mismo objeto.

Cuando despiertan, deben volver a comprobar la condición.

Por esta razón se utiliza:

```java
while
```

en lugar de:

```java
if
```

## Flujo de ejecución

```text
Consumidor comprueba disponible
↓
espera si hace falta
↓
productor publica y notifica
↓
consumidor retira
↓
join()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_10_WaitNotify
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Sin interrupciones se conserva el orden productor envió → consumidor recibió → proceso terminado, aunque la planificación varía.

```text
Productor envió: Mensaje enviado entre hilos
Consumidor recibió: Mensaje enviado entre hilos
Proceso terminado.
```

## Qué observar

- Ambos métodos usan el monitor de la misma bandeja.
- El while protege frente a despertares sin condición satisfecha.
- La coordinación depende de disponible, no de acertar la pausa de 500 ms.

## Experimenta

Reduce la pausa de main a cero y comprueba que el mensaje sigue transfiriéndose. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo09/README.md) · [Siguiente ejemplo →](../ejemplo11/README.md)
