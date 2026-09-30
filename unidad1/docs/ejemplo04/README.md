# U1_04 – Uso de sleep()

## Objetivo

Observar cómo sleep() pausa el hilo actual.

## Conceptos principales

`sleep()` introduce una espera temporal; no garantiza una hora exacta de reanudación ni libera monitores que el hilo posea. `InterruptedException` señala una interrupción de la espera.

## Archivo principal

[U1_04_Sleep.java](../../src/main/java/com/lelyliliana/unidad1/U1_04_Sleep.java)

## ¿Qué hace el ejemplo?

Dos tareas imprimen cinco iteraciones y duermen 500 ms después de cada una; ante una interrupción restauran la marca y retornan.

## Código clave

El método:

```java
Thread.sleep(500);
```

pausa temporalmente el hilo que ejecuta esa instrucción.

En el ejemplo, cada hilo realiza una iteración y después espera aproximadamente medio segundo antes de continuar.

El método puede lanzar:

```java
InterruptedException
```

Por esta razón se maneja la excepción y se conserva el estado de interrupción mediante:

```java
Thread.currentThread().interrupt();
```

## Flujo de ejecución

```text
Iniciar tareas
↓
imprimir
↓
dormir 500 ms
↓
repetir cinco veces
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_04_Sleep
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Se muestran cinco iteraciones de cada tarea; el orden global y la duración exacta pueden variar.

Los mensajes de `Hilo-A` y `Hilo-B` pueden aparecer intercalados.

## Qué observar

- main continúa sin esperar las tareas.
- Cada tarea conserva su secuencia aunque el intercalado cambie.
- La pausa afecta al hilo que llama a sleep().

## Experimenta

Cambia 500 por 1000 ms y observa la duración aproximada de las tareas. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo03/README.md) · [Siguiente ejemplo →](../ejemplo05/README.md)
