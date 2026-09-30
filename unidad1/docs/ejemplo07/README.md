# U1_07 – Condición de carrera

## Objetivo

Reconocer una actualización compartida sin exclusión mutua.

## Conceptos principales

Una condición de carrera hace depender el resultado del entrelazado de accesos. `valor++` combina lectura, incremento y escritura, y no es atómico.

## Archivo principal

[U1_07_CondicionCarrera.java](../../src/main/java/com/lelyliliana/unidad1/U1_07_CondicionCarrera.java)

## ¿Qué hace el ejemplo?

Dos hilos incrementan el mismo contador 100 000 veces cada uno; main espera y compara el resultado con 200 000.

## Código clave

Este ejemplo introduce uno de los problemas más importantes de la programación concurrente.

Dos hilos comparten el mismo objeto:

```java
Contador contador = new Contador();
```

y ambos ejecutan repetidamente:

```java
contador.incrementar();
```

El método contiene:

```java
valor++;
```

Aunque esta instrucción parece una sola operación, implica varios pasos internos:

1. Leer el valor.
2. Incrementarlo.
3. Guardar el nuevo valor.

Dos hilos pueden entrelazar esos pasos y producir una pérdida de actualizaciones.

El resultado esperado es:

```text
200000
```

pero el valor obtenido puede ser menor.

## Flujo de ejecución

```text
Compartir contador
↓
incrementar desde dos hilos
↓
join()
↓
comparar
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_07_CondicionCarrera
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El valor obtenido puede ser menor que 200000 o coincidir con él; no hay una salida única garantizada.

El resultado no determinista es precisamente parte del ejemplo.

En algunas ejecuciones puede coincidir con el valor esperado y en otras no.

## Qué observar

- La instancia del contador es compartida.
- join() espera, pero no protege el incremento.
- Obtener 200000 una vez no demuestra ausencia de carrera.

## Experimenta

Ejecuta varias veces y cambia la cantidad de iteraciones en ambos hilos, ajustando también el valor esperado impreso. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo06/README.md) · [Siguiente ejemplo →](../ejemplo08/README.md)
