# U1_11 – ReentrantLock

## Objetivo

Usar un bloqueo explícito para proteger un recurso compartido.

## Conceptos principales

`ReentrantLock` implementa Lock; `lock()` adquiere el bloqueo y `unlock()` lo libera. `finally` permite liberar el bloqueo aunque el cuerpo lance una excepción.

## Archivo principal

[U1_11_ReentrantLock.java](../../src/main/java/com/lelyliliana/unidad1/U1_11_ReentrantLock.java)

## ¿Qué hace el ejemplo?

Dos hilos incrementan el contador protegido por la misma instancia de Lock y main espera para leer el total.

## Código clave

Además de `synchronized`, Java dispone de mecanismos explícitos de bloqueo dentro del paquete:

```java
java.util.concurrent.locks
```

El ejemplo utiliza:

```java
private final Lock lock = new ReentrantLock();
```

Antes de entrar a la sección crítica:

```java
lock.lock();
```

Después de terminar:

```java
lock.unlock();
```

La liberación del bloqueo se realiza dentro de un bloque `finally`:

```java
lock.lock();

try {
    valor++;
} finally {
    lock.unlock();
}
```

Esto garantiza que el bloqueo sea liberado incluso si ocurre una excepción durante la operación.

## Flujo de ejecución

```text
lock()
↓
incrementar dentro de try
↓
unlock() en finally
↓
join()
↓
leer total
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_11_ReentrantLock
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

La planificación puede variar; el total final es determinista.

```text
Valor esperado: 200000
Valor obtenido: 200000
```

## Qué observar

- Los dos hilos comparten el mismo lock.
- unlock() se encuentra en finally.
- No se configura una política de equidad ni un orden de acceso.

## Experimenta

Cambia la cantidad de incrementos y compara el total con el ejemplo synchronized. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo10/README.md) · [Siguiente ejemplo →](../ejemplo12/README.md)
