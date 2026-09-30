# U1_08 – Método synchronized

## Objetivo

Proteger un incremento mediante un método synchronized.

## Conceptos principales

Un método synchronized de instancia adquiere el monitor de esa instancia. La exclusión mutua impide que dos hilos ejecuten simultáneamente la sección protegida por el mismo monitor.

## Archivo principal

[U1_08_SynchronizedMetodo.java](../../src/main/java/com/lelyliliana/unidad1/U1_08_SynchronizedMetodo.java)

## ¿Qué hace el ejemplo?

Repite el contador compartido con 100 000 incrementos por hilo y sincroniza incrementar().

## Código clave

Este ejemplo corrige la condición de carrera anterior.

El método:

```java
public synchronized void incrementar() {
    valor++;
}
```

solo puede ser ejecutado por un hilo a la vez sobre la misma instancia del objeto.

Cuando un hilo entra al método sincronizado obtiene el bloqueo asociado al objeto.

Los demás hilos deben esperar hasta que ese bloqueo sea liberado.

## Flujo de ejecución

```text
Compartir contador
↓
adquirir monitor
↓
incrementar
↓
liberar
↓
join()
↓
leer
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_08_SynchronizedMetodo
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El orden de acceso de los hilos puede variar aunque el total final sea determinista.

```text
Valor esperado: 200000
Valor obtenido: 200000
```

## Qué observar

- Ambos hilos usan el mismo objeto.
- El bloqueo abarca todo incrementar().
- El total se lee después de esperar ambos hilos.

## Experimenta

Cambia el número de iteraciones y comprueba el nuevo total, ajustando el mensaje de valor esperado. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo07/README.md) · [Siguiente ejemplo →](../ejemplo09/README.md)
