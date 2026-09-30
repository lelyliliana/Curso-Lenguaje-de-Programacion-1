# Lenguaje de Programación I

Repositorio de ejemplos prácticos del curso **Lenguaje de Programación I**, desarrollado con **Java 21 y Maven** y organizado progresivamente en tres unidades: concurrencia, comunicación en red y programación funcional.

## Objetivo del repositorio

Complementar el curso mediante ejemplos pequeños, progresivos, ejecutables, modificables y documentados, orientados a observar el comportamiento real de los conceptos estudiados. Cada ejemplo permite leer el código, ejecutarlo, modificar parámetros y comparar resultados.

## Tecnologías principales

- Java 21 y Maven.
- Java Threads: `Thread` y `Runnable`.
- `java.util.concurrent.locks`: `Lock` y `ReentrantLock`.
- `java.net`: direcciones, URL y sockets TCP y UDP.
- Java Serialization: `Serializable` y flujos de objetos de `java.io`.
- Java RMI.
- Interfaces funcionales, expresiones lambda y referencias a métodos.
- `java.util.function` y Stream API.

No se requieren frameworks ni bibliotecas externas para los ejemplos.

## Organización del repositorio

```text
Curso-Lenguaje-de-Programacion-1/
├── README.md
├── pom.xml
├── unidad1/
├── unidad2/
└── unidad3/
```

Cada unidad contiene su `pom.xml`, un `README.md` como índice, 12 ejemplos numerados en `src/main/java/com/lelyliliana/unidadX/` y sus guías en `docs/ejemploXX/README.md`. La Unidad 3 incluye además la clase de apoyo `Estudiante`.

La documentación se mantiene en una estructura paralela a los archivos Java para conservar sus paquetes y la secuencia pedagógica.

## Unidades

### [Unidad 1 – Concurrencia](unidad1/README.md)

Procesos e hilos, `Thread` y `Runnable`, diferencias entre `start()` y `run()`, `sleep()`, `join()`, estados de un hilo, condiciones de carrera, secciones críticas, exclusión mutua, `synchronized`, `wait()`, `notifyAll()` y `ReentrantLock`. Cierra con una cuenta bancaria compartida por dos clientes.

### [Unidad 2 – Concurrencia y Network](unidad2/README.md)

Host, IP, URL, puertos, sockets, arquitectura cliente-servidor, TCP, UDP, atención multicliente, serialización, envío de objetos y RMI. Integra concurrencia y comunicación en red mediante hilos que procesan solicitudes.

### [Unidad 3 – Programación funcional](unidad3/README.md)

Enfoques imperativo y funcional, funciones puras, interfaces funcionales, lambdas, `Predicate`, `Consumer`, `Supplier`, `Function`, referencias a métodos y Stream API (`filter`, `map`, `reduce`, `sorted`, `distinct`). Cierra con consultas y agregaciones sobre objetos `Estudiante`.

## Requisitos

- Java **JDK 21**.
- Apache Maven, utilizando ese JDK.
- Un editor o IDE compatible con Java es opcional.
- Para las demostraciones de red: comunicación local habilitada y puertos disponibles. No requieren servicios externos; el ejemplo de URL solo analiza una dirección.

Verifica la instalación:

```bash
java -version
mvn -version
```

La primera compilación puede necesitar conexión para descargar los complementos de Maven.

## Compilación

Todos los comandos de esta documentación parten de la **raíz del repositorio**.

Para compilar los tres módulos:

```bash
mvn compile
```

Para compilar una unidad:

```bash
mvn -pl unidad1 compile
mvn -pl unidad2 compile
mvn -pl unidad3 compile
```

También puedes seleccionar su POM directamente, por ejemplo `mvn -f unidad1/pom.xml compile`.

El POM raíz tiene empaquetado `pom` y agrega los tres módulos. Cada módulo configura Java 21 en su propio POM, sin heredar del POM raíz ni depender de los otros módulos. La compilación genera clases en `unidadX/target/classes` y debe finalizar con `BUILD SUCCESS`.

## Ejecución

Después de compilar, indica el directorio de clases y el nombre completo de la clase:

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_01_HiloBasico
```

También puedes ejecutar el método `main` desde el IDE. Los índices de unidad enlazan cada guía, con su comando concreto, resultado esperado y aspectos que observar. `Estudiante.java` es una clase de apoyo y no se ejecuta directamente.

## Forma recomendada de estudio

```text
Unidad 1: Concurrencia
↓
Unidad 2: Comunicación en red
↓
Unidad 3: Programación funcional
```

Sigue la numeración del 01 al 12 dentro de cada unidad. Lee el objetivo y el código, ejecuta el ejemplo, compara su salida y prueba las modificaciones pequeñas sugeridas. Cada guía permite regresar a su unidad o continuar con el ejemplo siguiente.

## Consideraciones especiales

- **Concurrencia:** el orden de los mensajes puede variar según la planificación de la JVM y el sistema operativo. En el ejemplo de condición de carrera también puede variar el total; no implica que concurrencia sea necesariamente ejecución simultánea.
- **Servidor y cliente separados:** inicia primero el servidor TCP 03 y luego el cliente 04, o el servidor UDP 07 y después el cliente 08, en dos terminales. Atienden un intercambio y terminan. Otros ejemplos crean servidor y clientes en una sola ejecución; consulta su guía.
- **TCP y UDP:** TCP proporciona un flujo ordenado con mecanismos de retransmisión, pero las conexiones pueden fallar. UDP no garantiza entrega ni orden; estos ejemplos no configuran timeout ni reintentos. Si una ejecución queda esperando, usa `Ctrl+C`.
- **Archivos:** el ejemplo de serialización crea o sobrescribe `estudiante.dat` en el directorio de ejecución.

| Servicio | Puerto local |
|---|---:|
| TCP eco | `5000` |
| TCP bidireccional | `5001` |
| TCP multicliente | `5002` |
| UDP | `6000` |
| Envío de objetos TCP | `6001` |
| Registro RMI | `1099` |
| Integrador de redes | `7000` |

RMI asigna además un puerto TCP dinámico al objeto remoto. Si aparece `Address already in use`, revisa si sigue activa otra ejecución. Si cambias un puerto para experimentar, cliente y servidor deben coincidir. Los detalles de arranque, intercambio y cierre están en las guías de la [Unidad 2](unidad2/README.md).

## Enfoque del repositorio

Los ejemplos buscan ser pequeños, progresivos, ejecutables, fáciles de localizar y suficientemente explicados. Complementan el material académico del curso y no lo reemplazan.

La navegación adopta la organización por unidades y guías individuales del repositorio de referencia [Lenguaje de Programación III](https://github.com/lelyliliana/Curso-Lenguaje-de-Programacion-3), conservando los contenidos propios de este curso.

## Autora

**Leli Liliana Díaz Izquierdo**

Docente investigadora

Facultad de Ingenierías

Corporación Universitaria Remington
