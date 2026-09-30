# Unidad 3 – Programación funcional

Esta unidad presenta los fundamentos de la programación funcional en Java mediante ejemplos sencillos y progresivos.

Los ejemplos permiten comparar el enfoque imperativo con el funcional y aplicar expresiones lambda, interfaces funcionales, referencias a métodos y operaciones de Stream API.

## Objetivos de la unidad

- Diferenciar la programación imperativa de la programación funcional.
- Comprender el concepto de función pura.
- Crear y utilizar interfaces funcionales.
- Implementar expresiones lambda.
- Aplicar las interfaces `Predicate`, `Consumer`, `Supplier` y `Function`.
- Utilizar referencias a métodos mediante el operador `::`.
- Procesar colecciones mediante Stream API.
- Aplicar operaciones como `filter`, `map`, `reduce`, `sorted`, `distinct` y `count`.
- Procesar colecciones de objetos.
- Integrar diferentes elementos de programación funcional en una misma solución.

## Tecnologías o APIs utilizadas

Java 21, Maven, interfaces funcionales, expresiones lambda, `java.util.function`, referencias a métodos, `java.util.stream`, `List`, `Arrays` y `Comparator`.

## Ejemplos

| Ejemplo | Tema |
|---|---|
| [U3_01](docs/ejemplo01/README.md) | Programación imperativa y funcional |
| [U3_02](docs/ejemplo02/README.md) | Función pura |
| [U3_03](docs/ejemplo03/README.md) | Interfaz funcional |
| [U3_04](docs/ejemplo04/README.md) | Expresiones lambda |
| [U3_05](docs/ejemplo05/README.md) | Uso de Predicate |
| [U3_06](docs/ejemplo06/README.md) | Consumer, Supplier y Function |
| [U3_07](docs/ejemplo07/README.md) | Referencias a métodos |
| [U3_08](docs/ejemplo08/README.md) | Stream API: filter y map |
| [U3_09](docs/ejemplo09/README.md) | Stream API: reduce |
| [U3_10](docs/ejemplo10/README.md) | Stream API: sorted y distinct |
| [U3_11](docs/ejemplo11/README.md) | Stream API con objetos |
| [U3_12](docs/ejemplo12/README.md) | Ejercicio integrador de programación funcional |

Cada enlace abre la guía del ejemplo con acceso directo al archivo Java, ejecución, resultados y navegación al ejemplo siguiente. La documentación vive en `docs/`; los paquetes Java conservan su ubicación.

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java (opcional).

## Estructura del proyecto

```text
unidad3/
├── pom.xml
├── README.md
├── docs/                         # README por ejemplo
└── src/
    └── main/
        └── java/
            └── com/
                └── lelyliliana/
                    └── unidad3/
                        ├── Estudiante.java
                        ├── U3_01_ImperativaVsFuncional.java
                        ├── U3_02_FuncionPura.java
                        ├── U3_03_InterfazFuncional.java
                        ├── U3_04_ExpresionesLambda.java
                        ├── U3_05_Predicate.java
                        ├── U3_06_ConsumerSupplierFunction.java
                        ├── U3_07_ReferenciaMetodos.java
                        ├── U3_08_StreamFilterMap.java
                        ├── U3_09_StreamReduce.java
                        ├── U3_10_StreamSortedDistinct.java
                        ├── U3_11_StreamObjetos.java
                        └── U3_12_IntegradorFuncional.java
```

## Ejecución

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad3/pom.xml compile
```

Los comandos de esta unidad y de sus ejemplos se ejecutan desde la **raíz del repositorio**. Después de compilar, ejecuta una clase por su nombre completo, por ejemplo:

```bash
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_01_ImperativaVsFuncional
```

También puedes ejecutar su método `main` desde el IDE. Consulta cada guía para los detalles y resultados esperados.

## Clase de apoyo

[Estudiante](docs/estudiante/README.md) representa nombre, nota y programa; no tiene main y se utiliza en los ejemplos 11 y 12. Consulta también su [archivo Java](src/main/java/com/lelyliliana/unidad3/Estudiante.java).

## Conceptos principales

### Programación imperativa

Describe paso a paso cómo debe realizarse una operación.

### Programación funcional

Expresa qué resultado se desea obtener mediante funciones y operaciones sobre datos.

### Función pura

Produce siempre el mismo resultado para la misma entrada y no modifica datos externos.

### Interfaz funcional

Interfaz que contiene un único método abstracto y puede implementarse mediante una expresión lambda.

### Expresión lambda

Función anónima que permite implementar de manera breve el comportamiento de una interfaz funcional.

### Referencia a método

Forma abreviada de utilizar un método existente mediante el operador `::`.

### Stream API

Herramienta para procesar colecciones mediante una secuencia de operaciones.

## Operaciones de Stream API utilizadas

| Operación | Descripción |
|---|---|
| `stream()` | Crea un flujo a partir de una colección. |
| `filter()` | Selecciona los elementos que cumplen una condición. |
| `map()` | Transforma los elementos del flujo. |
| `forEach()` | Ejecuta una acción sobre cada elemento. |
| `reduce()` | Combina los elementos para producir un resultado. |
| `sorted()` | Ordena los elementos. |
| `distinct()` | Elimina los elementos repetidos. |
| `count()` | Cuenta la cantidad de elementos. |
| `min()` | Obtiene el menor elemento. |

## Interfaces funcionales utilizadas

| Interfaz | Entrada | Salida | Método principal |
|---|---|---|---|
| `Predicate<T>` | Un dato de tipo `T` | `boolean` | `test()` |
| `Consumer<T>` | Un dato de tipo `T` | Sin retorno | `accept()` |
| `Supplier<T>` | Sin parámetros | Un dato de tipo `T` | `get()` |
| `Function<T, R>` | Un dato de tipo `T` | Un dato de tipo `R` | `apply()` |

## Orden recomendado de estudio

```text
Programación imperativa → funciones → interfaces funcionales → lambda
→ java.util.function → referencias a métodos → Stream API
→ procesamiento de objetos → ejercicio integrador
```

1. Programación imperativa y funcional.
2. Funciones puras.
3. Interfaces funcionales.
4. Expresiones lambda.
5. `Predicate`.
6. `Consumer`, `Supplier` y `Function`.
7. Referencias a métodos.
8. `filter()` y `map()`.
9. `reduce()`.
10. `sorted()` y `distinct()`.
11. Procesamiento de objetos.
12. Ejercicio integrador.

[← Volver al inicio del repositorio](../README.md)
