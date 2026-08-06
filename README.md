# Curso Lenguaje de Programación I

Repositorio de ejemplos prácticos del curso **Lenguaje de Programación I**, desarrollado en Java 21 y organizado como un proyecto Maven multimódulo.

El repositorio reúne ejemplos progresivos de las tres unidades del curso:

1. Concurrencia.
2. Concurrencia y Network.
3. Programación funcional.

La organización sigue los temas planteados en el módulo del curso, pero los ejemplos fueron actualizados y reorganizados para trabajar con código más limpio, compilable y compatible con Java 21. :contentReference[oaicite:0]{index=0}

---

## Objetivo del repositorio

Este repositorio tiene como propósito servir como material de apoyo para el estudio y práctica de los principales conceptos del curso.

Cada unidad contiene ejemplos independientes que permiten:

- Revisar un concepto específico.
- Ejecutar el código.
- Comparar resultados.
- Modificar parámetros.
- Analizar el comportamiento de las aplicaciones.

---

# Estructura general

```text
Curso-Lenguaje-de-Programacion-1/
├── pom.xml
├── README.md
├── .gitignore
│
├── unidad1/
│   ├── pom.xml
│   ├── README.md
│   └── src/main/java/com/lelyliliana/unidad1/
│
├── unidad2/
│   ├── pom.xml
│   ├── README.md
│   └── src/main/java/com/lelyliliana/unidad2/
│
└── unidad3/
    ├── pom.xml
    ├── README.md
    └── src/main/java/com/lelyliliana/unidad3/
```

---

# Unidad 1 - Concurrencia

Esta unidad introduce la programación concurrente en Java.

Se trabajan conceptos relacionados con:

- Procesos e hilos.
- Clase `Thread`.
- Interfaz `Runnable`.
- `start()` y `run()`.
- `sleep()`.
- `join()`.
- Estados del ciclo de vida de un hilo.
- Condiciones de carrera.
- Secciones críticas.
- Exclusión mutua.
- Métodos y bloques `synchronized`.
- `wait()`.
- `notifyAll()`.
- `ReentrantLock`.

La unidad termina con un ejercicio integrador basado en una cuenta bancaria compartida.

## Ejemplos

```text
U1_01_HiloBasico.java
U1_02_ThreadVsRunnable.java
U1_03_StartVsRun.java
U1_04_Sleep.java
U1_05_Join.java
U1_06_EstadosHilo.java
U1_07_CondicionCarrera.java
U1_08_SynchronizedMetodo.java
U1_09_SynchronizedBloque.java
U1_10_WaitNotify.java
U1_11_ReentrantLock.java
U1_12_IntegradorConcurrencia.java
```

Documentación completa:

```text
unidad1/README.md
```

---

# Unidad 2 - Concurrencia y Network

Esta unidad desarrolla los fundamentos de comunicación en red con Java.

Se trabajan conceptos como:

- Host.
- Dirección IP.
- URL.
- Puerto.
- Socket.
- Cliente-servidor.
- TCP.
- UDP.
- Servidores multicliente.
- Serialización de objetos.
- Envío de objetos por red.
- RMI.

También se integran conceptos de concurrencia mediante servidores que atienden diferentes clientes en hilos independientes.

## Ejemplos

```text
U2_01_InetAddress.java
U2_02_URL.java
U2_03_TCP_ServidorEco.java
U2_04_TCP_ClienteEco.java
U2_05_TCP_Bidireccional.java
U2_06_TCP_Multicliente.java
U2_07_UDP_Servidor.java
U2_08_UDP_Cliente.java
U2_09_Serializacion.java
U2_10_EnvioObjetosTCP.java
U2_11_RMI.java
U2_12_IntegradorRedes.java
```

Documentación completa:

```text
unidad2/README.md
```

---

# Unidad 3 - Programación funcional

Esta unidad introduce los principales elementos de programación funcional disponibles en Java.

Se trabajan conceptos relacionados con:

- Programación imperativa y funcional.
- Funciones puras.
- Interfaces funcionales.
- Expresiones lambda.
- `Predicate`.
- `Consumer`.
- `Supplier`.
- `Function`.
- Referencias a métodos.
- Stream API.
- `filter()`.
- `map()`.
- `reduce()`.
- `sorted()`.
- `distinct()`.
- Procesamiento de colecciones de objetos.

La unidad termina con un ejercicio integrador que combina varias interfaces funcionales y operaciones de Stream API.

## Ejemplos

```text
U3_01_ImperativaVsFuncional.java
U3_02_FuncionPura.java
U3_03_InterfazFuncional.java
U3_04_ExpresionesLambda.java
U3_05_Predicate.java
U3_06_ConsumerSupplierFunction.java
U3_07_ReferenciaMetodos.java
U3_08_StreamFilterMap.java
U3_09_StreamReduce.java
U3_10_StreamSortedDistinct.java
U3_11_StreamObjetos.java
U3_12_IntegradorFuncional.java
```

Clase de apoyo:

```text
Estudiante.java
```

Documentación completa:

```text
unidad3/README.md
```

---

# Requisitos

Para ejecutar los ejemplos se recomienda disponer de:

- Java JDK 21.
- Apache Maven.
- Visual Studio Code, IntelliJ IDEA, Eclipse o cualquier IDE compatible con Java.

Verificar Java:

```bash
java -version
```

Verificar Maven:

```bash
mvn -version
```

---

# Compilar todo el proyecto

Desde la raíz del repositorio:

```bash
mvn compile
```

Maven compilará las tres unidades:

```text
unidad1
unidad2
unidad3
```

Si todo está correctamente configurado debe finalizar con:

```text
BUILD SUCCESS
```

---

# Compilar una sola unidad

## Unidad 1

```bash
mvn -pl unidad1 compile
```

## Unidad 2

```bash
mvn -pl unidad2 compile
```

## Unidad 3

```bash
mvn -pl unidad3 compile
```

---

# Ejecutar un ejemplo

Después de compilar, puede ejecutarse una clase indicando su módulo y paquete.

Por ejemplo:

```bash
java -cp unidad1/target/classes com.lelyliliana.unidad1.U1_01_HiloBasico
```

Otro ejemplo:

```bash
java -cp unidad2/target/classes com.lelyliliana.unidad2.U2_01_InetAddress
```

Y para programación funcional:

```bash
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_01_ImperativaVsFuncional
```

También pueden ejecutarse directamente desde el IDE mediante la opción `Run` disponible sobre el método `main`.

---

# Consideraciones sobre concurrencia

Los programas concurrentes pueden producir salidas diferentes entre ejecuciones.

Esto ocurre porque la planificación de los hilos depende de la JVM y del sistema operativo.

Por esta razón, ejemplos como:

```text
U1_07_CondicionCarrera.java
```

pueden producir diferentes resultados.

Esto forma parte del comportamiento que se desea observar.

---

# Consideraciones sobre comunicación en red

En algunos ejemplos existen dos programas independientes: servidor y cliente.

Debe ejecutarse primero el servidor.

Por ejemplo:

```text
U2_03_TCP_ServidorEco.java
```

y después:

```text
U2_04_TCP_ClienteEco.java
```

Lo mismo ocurre con UDP:

```text
U2_07_UDP_Servidor.java
```

antes de:

```text
U2_08_UDP_Cliente.java
```

---

# Puertos utilizados

Los ejemplos utilizan los siguientes puertos locales:

| Servicio | Puerto |
|---|---:|
| TCP eco | `5000` |
| TCP bidireccional | `5001` |
| TCP multicliente | `5002` |
| UDP | `6000` |
| Envío de objetos TCP | `6001` |
| RMI | `1099` |
| Integrador de redes | `7000` |

Si un puerto está ocupado puede modificarse, siempre que cliente y servidor utilicen el mismo número.

---

# Organización Maven

El repositorio utiliza una estructura Maven multimódulo.

El archivo:

```text
pom.xml
```

ubicado en la raíz contiene:

```xml
<modules>
    <module>unidad1</module>
    <module>unidad2</module>
    <module>unidad3</module>
</modules>
```

Cada unidad posee además su propio archivo:

```text
pom.xml
```

Esto permite compilar una unidad de forma independiente o construir todo el repositorio desde la raíz.

---

# Tecnologías utilizadas

- Java 21
- Maven
- Java Threads
- `java.util.concurrent`
- `java.net`
- TCP
- UDP
- Java Serialization
- Java RMI
- Lambda Expressions
- Stream API

---

# Orden recomendado de estudio

Para estudiantes que recorren el repositorio por primera vez se recomienda mantener el siguiente orden:

```text
Unidad 1
   ↓
Concurrencia
   ↓
Unidad 2
   ↓
Comunicación en red
   ↓
Unidad 3
   ↓
Programación funcional
```

Dentro de cada unidad los archivos también están numerados siguiendo un orden progresivo.

---

# Nota académica

Los ejemplos de este repositorio están diseñados con fines educativos y buscan complementar los contenidos del curso mediante implementaciones sencillas, ejecutables y modificables.

Se recomienda no limitarse a ejecutar el código.

Para comprender cada concepto es conveniente:

- Leer el ejemplo.
- Identificar las clases utilizadas.
- Ejecutarlo varias veces.
- Modificar valores.
- Comparar resultados.
- Analizar los cambios producidos.
- Consultar el `README.md` correspondiente a cada unidad.

---

# Autora

**Leli Liliana Díaz Izquierdo**

Docente investigadora  
Facultad de Ingenierías  
Corporación Universitaria Remington