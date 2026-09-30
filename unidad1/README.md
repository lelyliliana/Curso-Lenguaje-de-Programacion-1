# Unidad 1 – Concurrencia

Esta unidad presenta los fundamentos de la programación concurrente en Java mediante ejemplos progresivos sobre creación de hilos, ciclo de vida, condiciones de carrera, exclusión mutua y mecanismos de sincronización.

Los ejemplos están organizados para avanzar desde la creación básica de hilos hasta un caso integrador con recursos compartidos.

## Objetivos de la unidad

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

## Tecnologías o APIs utilizadas

Java 21, Maven, `Thread`, `Runnable`, monitores (`synchronized`, `wait()`, `notifyAll()`) y `java.util.concurrent.locks` (`Lock`, `ReentrantLock`).

## Ejemplos

| Ejemplo | Tema |
|---|---|
| [U1_01](docs/ejemplo01/README.md) | Hilo básico con Thread |
| [U1_02](docs/ejemplo02/README.md) | Thread vs Runnable |
| [U1_03](docs/ejemplo03/README.md) | start() vs run() |
| [U1_04](docs/ejemplo04/README.md) | Uso de sleep() |
| [U1_05](docs/ejemplo05/README.md) | Uso de join() |
| [U1_06](docs/ejemplo06/README.md) | Estados de un hilo |
| [U1_07](docs/ejemplo07/README.md) | Condición de carrera |
| [U1_08](docs/ejemplo08/README.md) | Método synchronized |
| [U1_09](docs/ejemplo09/README.md) | Bloque synchronized |
| [U1_10](docs/ejemplo10/README.md) | wait() y notifyAll() |
| [U1_11](docs/ejemplo11/README.md) | ReentrantLock |
| [U1_12](docs/ejemplo12/README.md) | Ejercicio integrador de concurrencia |

Cada enlace abre la guía del ejemplo con acceso directo al archivo Java, ejecución, resultados y navegación al ejemplo siguiente. La documentación vive en `docs/`; los paquetes Java conservan su ubicación.

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java (opcional).

## Estructura del proyecto

```text
unidad1/
├── pom.xml
├── README.md
├── docs/                         # README por ejemplo
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

## Ejecución

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad1/pom.xml compile
```

También puede compilarse todo el repositorio multimódulo desde la raíz:

```bash
mvn compile
```

Los comandos de esta unidad y de sus ejemplos se ejecutan desde la **raíz del repositorio**. Después de compilar, ejecuta una clase por su nombre completo, por ejemplo:

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_01_HiloBasico
```

También puedes ejecutar su método `main` desde el IDE. Consulta cada guía para los detalles y resultados esperados.

## Conceptos principales

### Proceso

Programa que se encuentra en ejecución y dispone de sus propios recursos.

### Hilo

Camino de ejecución dentro de un proceso.

Los hilos de un mismo proceso pueden compartir recursos y memoria.

### Concurrencia

Permite que varias tareas progresen durante un mismo intervalo de tiempo.

No implica necesariamente que todas estén ejecutándose exactamente al mismo instante.

### Paralelismo

Implica que varias tareas se ejecutan realmente al mismo tiempo utilizando diferentes recursos de procesamiento.

### Sección crítica

Parte del programa que accede a un recurso compartido y que puede producir inconsistencias si varios hilos la ejecutan simultáneamente.

### Condición de carrera

Situación en la que el resultado depende del orden o del momento exacto en que diferentes hilos acceden a datos compartidos.

### Exclusión mutua

Mecanismo que garantiza que solamente un hilo pueda ejecutar una sección crítica en un momento determinado.

---

## Métodos y mecanismos utilizados

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
| `notifyAll()` | Despierta todos los hilos que esperan sobre un objeto. |
| `ReentrantLock` | Proporciona control explícito sobre un bloqueo. |
| `lock()` | Adquiere un bloqueo explícito. |
| `unlock()` | Libera un bloqueo explícito. |

---

## Estados del ciclo de vida de Thread

La tabla incluye los seis estados posibles. El ejemplo 06 no los fuerza todos: las consultas intermedias dependen de la planificación.

| Estado | Descripción |
|---|---|
| `NEW` | El hilo fue creado pero todavía no se ha iniciado. |
| `RUNNABLE` | El hilo está disponible para ejecución o está ejecutándose. |
| `BLOCKED` | El hilo espera obtener un bloqueo de monitor. |
| `WAITING` | El hilo espera indefinidamente por otro hilo. |
| `TIMED_WAITING` | El hilo espera durante un tiempo determinado. |
| `TERMINATED` | El hilo terminó su ejecución. |

---

## Orden recomendado de estudio

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

## Recomendaciones

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

[← Volver al inicio del repositorio](../README.md)
