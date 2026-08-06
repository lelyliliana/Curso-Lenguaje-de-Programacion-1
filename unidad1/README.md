# Unidad 1 - Concurrencia en Java

Esta unidad presenta los fundamentos de la programación concurrente en Java mediante ejemplos progresivos sobre creación de hilos, ciclo de vida, condiciones de carrera, exclusión mutua y mecanismos de sincronización.

Los ejemplos están organizados para avanzar desde la creación básica de hilos hasta un caso integrador con recursos compartidos.

## Objetivos

- Comprender qué es un hilo y cómo se relaciona con un proceso.
- Crear hilos mediante la clase `Thread`.
- Implementar tareas concurrentes mediante `Runnable`.
- Diferenciar el uso de `start()` y `run()`.
- Utilizar `sleep()` y `join()`.
- Observar estados del ciclo de vida de un hilo.
- Identificar condiciones de carrera.
- Aplicar exclusión mutua mediante `synchronized`.
- Utilizar bloques sincronizados.
- Comprender la comunicación entre hilos mediante `wait()` y `notifyAll()`.
- Utilizar `ReentrantLock`.
- Integrar los principales mecanismos de concurrencia en una aplicación sencilla.

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java.

## Estructura del proyecto

```text
unidad1/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── lelyliliana/
                    └── unidad1/
                        ├── U1_01_HiloBasico.java
                        ├── U1_02_ThreadVsRunnable.java
                        ├── U1_03_StartVsRun.java
                        ├── U1_04_Sleep.java
                        ├── U1_05_Join.java
                        ├── U1_06_EstadosHilo.java
                        ├── U1_07_CondicionCarrera.java
                        ├── U1_08_SynchronizedMetodo.java
                        ├── U1_09_SynchronizedBloque.java
                        ├── U1_10_WaitNotify.java
                        ├── U1_11_ReentrantLock.java
                        └── U1_12_IntegradorConcurrencia.java
```

## Compilación del proyecto

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad1/pom.xml compile
```

También puede compilarse todo el repositorio multimódulo desde la raíz:

```bash
mvn compile
```

---

## Ejemplo 1. Hilo básico con Thread

Archivo:

```text
U1_01_HiloBasico.java
```

Este ejemplo presenta una de las formas más directas de crear un hilo en Java: extender la clase `Thread`.

La clase redefine el método:

```java
@Override
public void run() {
    // tarea del hilo
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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_01_HiloBasico
```

### Observación

El orden de las iteraciones puede variar entre ejecuciones porque los hilos se ejecutan de manera concurrente.

---

## Ejemplo 2. Thread vs Runnable

Archivo:

```text
U1_02_ThreadVsRunnable.java
```

Este ejemplo compara dos formas de definir tareas concurrentes en Java.

### Extendiendo Thread

```java
static class HiloConThread extends Thread {
```

La clase hereda directamente de `Thread` y redefine `run()`.

### Implementando Runnable

```java
static class TareaConRunnable implements Runnable {
```

La clase define la tarea, pero no representa por sí misma un hilo.

Posteriormente se crea el hilo:

```java
Thread hilo2 =
        new Thread(
                new TareaConRunnable("Hilo B")
        );
```

`Runnable` permite separar la tarea que se desea ejecutar del hilo que la ejecutará.

Además, una clase que implementa `Runnable` puede seguir heredando de otra clase si fuera necesario.

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_02_ThreadVsRunnable
```

---

## Ejemplo 3. start() vs run()

Archivo:

```text
U1_03_StartVsRun.java
```

Este ejemplo muestra una diferencia fundamental.

Cuando se invoca directamente:

```java
hilo.run();
```

no se crea un nuevo hilo.

El método se ejecuta como una llamada normal dentro del hilo actual.

Por esta razón, al mostrar:

```java
Thread.currentThread().getName()
```

la ejecución mediante `run()` aparecerá asociada normalmente al hilo:

```text
main
```

En cambio:

```java
hilo.start();
```

inicia un nuevo hilo de ejecución.

En ese caso pueden aparecer nombres como:

```text
Thread-0
Thread-1
```

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_03_StartVsRun
```

---

## Ejemplo 4. Uso de sleep()

Archivo:

```text
U1_04_Sleep.java
```

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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_04_Sleep
```

### Observación

Los mensajes de `Hilo-A` y `Hilo-B` pueden aparecer intercalados.

---

## Ejemplo 5. Uso de join()

Archivo:

```text
U1_05_Join.java
```

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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_05_Join
```

---

## Ejemplo 6. Estados de un hilo

Archivo:

```text
U1_06_EstadosHilo.java
```

Java permite consultar el estado de un hilo mediante:

```java
hilo.getState();
```

En el ejemplo se observan estados como:

### NEW

El hilo fue creado, pero todavía no se ha iniciado.

### RUNNABLE

El hilo está disponible para ser ejecutado o se encuentra en ejecución.

### TIMED_WAITING

El hilo espera durante un tiempo determinado, por ejemplo, debido a:

```java
Thread.sleep(...)
```

### TERMINATED

El hilo terminó su ejecución.

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_06_EstadosHilo
```

### Salida aproximada

```text
Estado al crear el hilo: NEW
Estado después de start(): RUNNABLE
Dentro del hilo. Estado actual: RUNNABLE
Estado mientras está en sleep(): TIMED_WAITING
Estado después de terminar: TERMINATED
```

El estado observado inmediatamente después de `start()` puede variar dependiendo de la planificación de la JVM.

---

## Ejemplo 7. Condición de carrera

Archivo:

```text
U1_07_CondicionCarrera.java
```

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

Dos hilos pueden ejecutar esos pasos al mismo tiempo y producir una pérdida de actualizaciones.

El resultado esperado es:

```text
200000
```

pero el valor obtenido puede ser menor.

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_07_CondicionCarrera
```

### Importante

El resultado no determinista es precisamente parte del ejemplo.

En algunas ejecuciones puede coincidir con el valor esperado y en otras no.

---

## Ejemplo 8. Método synchronized

Archivo:

```text
U1_08_SynchronizedMetodo.java
```

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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_08_SynchronizedMetodo
```

### Salida esperada

```text
Valor esperado: 200000
Valor obtenido: 200000
```

---

## Ejemplo 9. Bloque synchronized

Archivo:

```text
U1_09_SynchronizedBloque.java
```

No siempre es necesario sincronizar un método completo.

Puede protegerse únicamente la sección crítica:

```java
synchronized (this) {
    valor++;
}
```

El resto del método puede ejecutarse sin mantener el bloqueo.

Esta estrategia permite reducir el tiempo durante el cual otros hilos deben esperar.

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_09_SynchronizedBloque
```

### Salida esperada

```text
Valor esperado: 200000
Valor obtenido: 200000
```

---

## Ejemplo 10. wait() y notifyAll()

Archivo:

```text
U1_10_WaitNotify.java
```

Este ejemplo presenta comunicación y coordinación entre hilos mediante un esquema productor-consumidor sencillo.

El consumidor comprueba si existe un mensaje disponible:

```java
while (!disponible) {
    wait();
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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_10_WaitNotify
```

### Salida aproximada

```text
Productor envió: Mensaje enviado entre hilos
Consumidor recibió: Mensaje enviado entre hilos
Proceso terminado.
```

---

## Ejemplo 11. ReentrantLock

Archivo:

```text
U1_11_ReentrantLock.java
```

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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_11_ReentrantLock
```

### Salida esperada

```text
Valor esperado: 200000
Valor obtenido: 200000
```

---

## Ejemplo 12. Ejercicio integrador de concurrencia

Archivo:

```text
U1_12_IntegradorConcurrencia.java
```

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
public synchronized void retirar(...)
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

### Ejecución

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_12_IntegradorConcurrencia
```

### Importante

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

---

# Conceptos principales de la unidad

## Proceso

Programa que se encuentra en ejecución y dispone de sus propios recursos.

## Hilo

Camino de ejecución dentro de un proceso.

Los hilos de un mismo proceso pueden compartir recursos y memoria.

## Concurrencia

Permite que varias tareas progresen durante un mismo intervalo de tiempo.

No implica necesariamente que todas estén ejecutándose exactamente al mismo instante.

## Paralelismo

Implica que varias tareas se ejecutan realmente al mismo tiempo utilizando diferentes recursos de procesamiento.

## Sección crítica

Parte del programa que accede a un recurso compartido y que puede producir inconsistencias si varios hilos la ejecutan simultáneamente.

## Condición de carrera

Situación en la que el resultado depende del orden o del momento exacto en que diferentes hilos acceden a datos compartidos.

## Exclusión mutua

Mecanismo que garantiza que solamente un hilo pueda ejecutar una sección crítica en un momento determinado.

---

# Métodos y mecanismos utilizados

| Elemento | Propósito |
|---|---|
| `Thread` | Representa un hilo de ejecución. |
| `Runnable` | Representa una tarea que puede ejecutar un hilo. |
| `start()` | Inicia un nuevo hilo. |
| `run()` | Contiene la tarea que ejecutará el hilo. |
| `sleep()` | Suspende temporalmente el hilo actual. |
| `join()` | Espera a que otro hilo termine. |
| `getState()` | Permite consultar el estado de un hilo. |
| `synchronized` | Proporciona exclusión mutua mediante el bloqueo de un objeto. |
| `wait()` | Suspende un hilo y libera temporalmente el bloqueo del objeto. |
| `notify()` | Despierta uno de los hilos que esperan sobre un objeto. |
| `notifyAll()` | Despierta todos los hilos que esperan sobre un objeto. |
| `ReentrantLock` | Proporciona control explícito sobre un bloqueo. |
| `lock()` | Adquiere un bloqueo explícito. |
| `unlock()` | Libera un bloqueo explícito. |

---

# Estados de Thread utilizados

| Estado | Descripción |
|---|---|
| `NEW` | El hilo fue creado pero todavía no se ha iniciado. |
| `RUNNABLE` | El hilo está disponible para ejecución o está ejecutándose. |
| `BLOCKED` | El hilo espera obtener un bloqueo de monitor. |
| `WAITING` | El hilo espera indefinidamente por otro hilo. |
| `TIMED_WAITING` | El hilo espera durante un tiempo determinado. |
| `TERMINATED` | El hilo terminó su ejecución. |

---

# Orden recomendado de estudio

1. Hilo básico con `Thread`.
2. Diferencia entre `Thread` y `Runnable`.
3. Diferencia entre `start()` y `run()`.
4. Uso de `sleep()`.
5. Uso de `join()`.
6. Estados del ciclo de vida.
7. Condición de carrera.
8. Método `synchronized`.
9. Bloque `synchronized`.
10. `wait()` y `notifyAll()`.
11. `ReentrantLock`.
12. Ejercicio integrador.

---

# Recomendaciones

La salida de los programas concurrentes no siempre tendrá el mismo orden.

Esto no significa necesariamente que exista un error.

Cuando varios hilos se ejecutan concurrentemente, la JVM y el sistema operativo participan en la planificación de su ejecución.

Por esta razón, al estudiar los ejemplos es recomendable:

- Ejecutarlos varias veces.
- Comparar las salidas.
- Observar qué resultados son deterministas y cuáles pueden variar.
- Identificar cuándo existe un recurso compartido.
- Analizar qué fragmentos de código constituyen una sección crítica.
- Comparar los resultados antes y después de utilizar mecanismos de sincronización.

La sincronización debe utilizarse cuando realmente exista acceso concurrente a recursos compartidos. Sincronizar código innecesariamente puede reducir el rendimiento de una aplicación.