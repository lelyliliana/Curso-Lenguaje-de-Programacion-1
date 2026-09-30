# U1_12 – Ejercicio integrador de concurrencia

## Objetivo

Integrar tareas, exclusión mutua y espera sobre una cuenta compartida.

## Conceptos principales

La sección crítica abarca comprobar fondos y descontar el saldo. `synchronized` protege ambas operaciones juntas y `join()` permite leer el resultado al terminar.

## Archivo principal

[U1_12_IntegradorConcurrencia.java](../../src/main/java/com/lelyliliana/unidad1/U1_12_IntegradorConcurrencia.java)

## ¿Qué hace el ejemplo?

Desde un saldo de 1000, A intenta retirar 700 y B intenta retirar 500; solo uno puede completar su retiro.

## Código clave

Este ejemplo representa una cuenta bancaria compartida por dos clientes.

La cuenta comienza con:

```text
$1000
```

Los clientes intentan retirar:

```text
Cliente A -> $700
Cliente B -> $500
```

Ambos clientes utilizan el mismo objeto:

```java
CuentaBancaria cuenta =
        new CuentaBancaria(1000);
```

Cada cliente implementa `Runnable`:

```java
static class Cliente implements Runnable
```

y se ejecuta en su propio hilo.

La operación de retiro se protege mediante:

```java
public synchronized void retirar(
        String nombreCliente,
        double cantidad
) {
```

De esta manera:

1. Un cliente obtiene acceso al saldo.
2. Comprueba si existen fondos.
3. Realiza el retiro.
4. Libera el acceso.
5. El siguiente cliente puede comprobar el saldo actualizado.

Los dos hilos se inician mediante:

```java
cliente1.start();
cliente2.start();
```

Después:

```java
cliente1.join();
cliente2.join();
```

garantiza que el hilo principal espere antes de mostrar el saldo final.

## Flujo de ejecución

```text
Compartir cuenta
↓
iniciar clientes
↓
comprobar y retirar con monitor
↓
esperar ambos
↓
mostrar saldo
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad1 compile
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_12_IntegradorConcurrencia
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Sin interrupciones, el saldo final es 300.0 si retira A o 500.0 si retira B. Las transcripciones siguientes resumen el comportamiento; el programa imprime importes double y mensajes adicionales.

El orden de los clientes puede variar.

Por ejemplo, si `Cliente A` obtiene primero el bloqueo:

```text
Cliente A retira $700
Cliente B no puede retirar $500
Saldo final: $300
```

Si `Cliente B` obtiene primero el bloqueo:

```text
Cliente B retira $500
Cliente A no puede retirar $700
Saldo final: $500
```

Ambos resultados son válidos porque dependen del orden de planificación de los hilos.

Lo importante es que el saldo nunca quede en un estado inconsistente.

## Qué observar

- El saldo final depende de quién accede primero.
- sleep() dentro del método no libera el monitor.
- La comprobación y el descuento quedan protegidos juntos.

## Experimenta

Cambia el saldo inicial a 1500 y observa que ambos retiros pueden completarse. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 1](../../README.md) · [← Ejemplo anterior](../ejemplo11/README.md)
