# U1_09 – Bloque synchronized

## Objetivo

Delimitar una sección crítica con un bloque synchronized.

## Conceptos principales

`synchronized (this)` adquiere el monitor del contador solo durante el bloque. Una variable local como temporal pertenece a cada invocación.

## Archivo principal

[U1_09_SynchronizedBloque.java](../../src/main/java/com/lelyliliana/unidad1/U1_09_SynchronizedBloque.java)

## ¿Qué hace el ejemplo?

Protege valor++ y deja fuera las operaciones locales independientes.

## Código clave

No siempre es necesario sincronizar un método completo.

Puede protegerse únicamente la sección crítica:

```java
synchronized (this) {
    valor++;
}
```

El resto del método puede ejecutarse sin mantener el bloqueo.

Esta estrategia permite reducir el tiempo durante el cual otros hilos deben esperar.

## Flujo de ejecución

```text
Operación local
↓
entrar al bloque
↓
incrementar
↓
salir
↓
operación local
↓
join()
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_09_SynchronizedBloque
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El orden de acceso puede variar aunque el total final sea determinista.

```text
Valor esperado: 200000
Valor obtenido: 200000
```

## Qué observar

- Solo valor++ está dentro del bloque.
- this representa el mismo contador para ambos hilos.
- El resultado coincide con el del método sincronizado.

## Experimenta

Mueve el cálculo local dentro del bloque y compara el alcance del bloqueo, sin atribuir mejoras de tiempo a una sola ejecución. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo08/README.md) · [Siguiente ejemplo →](../ejemplo10/README.md)
