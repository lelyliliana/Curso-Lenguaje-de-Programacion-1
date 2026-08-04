# Unidad 4 - Programación funcional en Java

Esta unidad presenta los fundamentos de la programación funcional en Java mediante ejemplos sencillos y progresivos.

Los ejemplos permiten comparar el enfoque imperativo con el funcional y aplicar expresiones lambda, interfaces funcionales, referencias a métodos y operaciones de Stream API.

## Objetivos

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

## Requisitos

- Java JDK 21.
- Apache Maven.
- Un editor de código o IDE compatible con Java.

## Estructura del proyecto

```text
unidad4/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── lelyliliana/
                    └── unidad4/
                        ├── Estudiante.java
                        ├── U4_01_ImperativaVsFuncional.java
                        ├── U4_02_FuncionPura.java
                        ├── U4_03_InterfazFuncional.java
                        ├── U4_04_ExpresionesLambda.java
                        ├── U4_05_Predicate.java
                        ├── U4_06_ConsumerSupplierFunction.java
                        ├── U4_07_ReferenciaMetodos.java
                        ├── U4_08_StreamFilterMap.java
                        ├── U4_09_StreamReduce.java
                        ├── U4_10_StreamSortedDistinct.java
                        ├── U4_11_StreamObjetos.java
                        └── U4_12_IntegradorFuncional.java
```

## Compilación del proyecto

Desde la carpeta raíz del repositorio:

```bash
mvn -f unidad4/pom.xml compile
```

---

## Ejemplo 1. Programación imperativa y funcional

Archivo:

```text
U4_01_ImperativaVsFuncional.java
```

Este ejemplo calcula el valor mínimo de un arreglo mediante dos enfoques.

En la programación imperativa se utiliza un ciclo y una condición para indicar paso a paso cómo debe encontrarse el valor mínimo.

En la programación funcional se utiliza:

```java
Arrays.stream(numeros)
        .min()
        .orElseThrow();
```

La solución funcional expresa directamente qué resultado se desea obtener.

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_01_ImperativaVsFuncional
```

### Salida esperada

```text
PROGRAMACIÓN IMPERATIVA
-----------------------
El número menor es: 2

PROGRAMACIÓN FUNCIONAL
----------------------
El número menor es: 2
```

---

## Ejemplo 2. Función pura

Archivo:

```text
U4_02_FuncionPura.java
```

Este ejemplo presenta una función pura mediante el método:

```java
public static int calcularCuadrado(int numero) {
    return numero * numero;
}
```

Una función pura cumple dos condiciones principales:

- Para una misma entrada siempre produce la misma salida.
- No modifica datos externos ni genera efectos secundarios.

En el ejemplo, el valor `6` se envía dos veces al método y en ambos casos se obtiene como resultado `36`.

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_02_FuncionPura
```

### Salida esperada

```text
FUNCIÓN PURA
------------
Número recibido: 6
Primer resultado: 36
Segundo resultado: 36
```

---

## Ejemplo 3. Interfaz funcional

Archivo:

```text
U4_03_InterfazFuncional.java
```

Este ejemplo presenta una interfaz funcional llamada `OperacionMatematica`.

```java
@FunctionalInterface
interface OperacionMatematica {

    int calcular(int numero);
}
```

Una interfaz funcional:

- Contiene un único método abstracto.
- Puede identificarse con la anotación `@FunctionalInterface`.
- Puede implementarse mediante una expresión lambda.

En el ejemplo se crea una expresión lambda que duplica el número recibido:

```java
OperacionMatematica duplicar = numero -> numero * 2;
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_03_InterfazFuncional
```

### Salida esperada

```text
INTERFAZ FUNCIONAL
------------------
Número recibido: 7
Resultado al duplicar: 14
```

---

## Ejemplo 4. Expresiones lambda

Archivo:

```text
U4_04_ExpresionesLambda.java
```

Este ejemplo presenta expresiones lambda con diferentes cantidades de parámetros.

### Lambda sin parámetros

```java
Mensaje mensaje = () ->
        System.out.println("Ejemplo de lambda sin parámetros.");
```

### Lambda con un parámetro

```java
Saludo saludo = nombre ->
        System.out.println("Hola, " + nombre + ".");
```

### Lambda con dos parámetros

```java
Suma suma = (numero1, numero2) ->
        numero1 + numero2;
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_04_ExpresionesLambda
```

### Salida esperada

```text
EXPRESIONES LAMBDA
------------------
Ejemplo de lambda sin parámetros.
Hola, Leli.
Resultado de la suma: 13
```

---

## Ejemplo 5. Uso de Predicate

Archivo:

```text
U4_05_Predicate.java
```

Este ejemplo utiliza la interfaz funcional `Predicate<T>`.

`Predicate` recibe un dato y evalúa una condición. Su resultado siempre es un valor booleano.

En el ejemplo se crean dos condiciones:

```java
Predicate<Integer> esPar = numero -> numero % 2 == 0;
```

```java
Predicate<Integer> esMayorQueDiez = numero -> numero > 10;
```

Las condiciones se utilizan dentro de `filter()` para seleccionar los elementos que las cumplen.

```java
numeros.stream()
        .filter(esPar)
        .forEach(System.out::println);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_05_Predicate
```

### Salida esperada

```text
USO DE PREDICATE
----------------
Números pares:
8
14
22

Números mayores que 10:
11
14
19
22
```

---

## Ejemplo 6. Consumer, Supplier y Function

Archivo:

```text
U4_06_ConsumerSupplierFunction.java
```

Este ejemplo utiliza tres interfaces funcionales incluidas en el paquete `java.util.function`.

### Supplier

`Supplier<T>` no recibe parámetros y devuelve un valor.

```java
Supplier<String> obtenerMensaje = () ->
        "Bienvenidos a la programación funcional en Java.";
```

El valor se obtiene mediante:

```java
obtenerMensaje.get();
```

### Consumer

`Consumer<T>` recibe un dato y realiza una acción, pero no devuelve ningún valor.

```java
Consumer<String> mostrarMensaje = mensaje ->
        System.out.println(mensaje);
```

La acción se ejecuta mediante:

```java
mostrarMensaje.accept(mensaje);
```

### Function

`Function<T, R>` recibe un dato de tipo `T` y devuelve un resultado de tipo `R`.

```java
Function<Integer, Integer> calcularCuadrado = numero ->
        numero * numero;
```

La función se ejecuta mediante:

```java
calcularCuadrado.apply(numero);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_06_ConsumerSupplierFunction
```

### Salida esperada

```text
CONSUMER, SUPPLIER Y FUNCTION
-----------------------------
Bienvenidos a la programación funcional en Java.

Número recibido: 5
Cuadrado del número: 25
```

---

## Ejemplo 7. Referencias a métodos

Archivo:

```text
U4_07_ReferenciaMetodos.java
```

Este ejemplo presenta el uso del operador `::` para crear referencias a métodos.

Primero se utiliza una expresión lambda:

```java
estudiantes.forEach(nombre ->
        System.out.println(nombre));
```

Luego se reemplaza por una referencia al método `println`:

```java
estudiantes.forEach(System.out::println);
```

Ambas instrucciones producen el mismo resultado.

También se utiliza una referencia al método `toUpperCase` de la clase `String`:

```java
Function<String, String> convertirMayusculas =
        String::toUpperCase;
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_07_ReferenciaMetodos
```

### Salida esperada

```text
REFERENCIAS A MÉTODOS
---------------------
Expresión lambda:
Ana
Carlos
María
Juan

Referencia a método:
Ana
Carlos
María
Juan

Conversión a mayúsculas:
ANA
CARLOS
MARÍA
JUAN
```

---

## Ejemplo 8. Stream API: filter y map

Archivo:

```text
U4_08_StreamFilterMap.java
```

Este ejemplo presenta dos operaciones intermedias de Stream API.

- `filter()`: selecciona los elementos que cumplen una condición.
- `map()`: transforma cada elemento del flujo.

Primero se filtran los números pares:

```java
numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .forEach(System.out::println);
```

Después se filtran los números pares y se calcula el cuadrado de cada uno:

```java
numeros.stream()
        .filter(numero -> numero % 2 == 0)
        .map(numero -> numero * numero)
        .forEach(System.out::println);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_08_StreamFilterMap
```

### Salida esperada

```text
STREAM: FILTER Y MAP
--------------------
Lista original:
2
5
8
11
14
17
20

Números pares:
2
8
14
20

Cuadrado de los números pares:
4
64
196
400
```

---

## Ejemplo 9. Stream API: reduce

Archivo:

```text
U4_09_StreamReduce.java
```

Este ejemplo utiliza la operación `reduce()` para combinar todos los elementos de un flujo y producir un único resultado.

Primero se calcula la suma mediante programación imperativa:

```java
int sumaImperativa = 0;

for (int numero : numeros) {
    sumaImperativa += numero;
}
```

Luego se calcula mediante programación funcional:

```java
int sumaFuncional = numeros.stream()
        .reduce(0, (acumulador, numero) ->
                acumulador + numero);
```

El primer parámetro de `reduce()` es el valor inicial del acumulador.

También se utiliza `reduce()` para calcular el producto:

```java
int producto = numeros.stream()
        .reduce(1, (acumulador, numero) ->
                acumulador * numero);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_09_StreamReduce
```

### Salida esperada

```text
STREAM: REDUCE
--------------
Suma con programación imperativa: 30
Suma con programación funcional: 30
Producto de los números: 3840
```

---

## Ejemplo 10. Stream API: sorted y distinct

Archivo:

```text
U4_10_StreamSortedDistinct.java
```

Este ejemplo utiliza las operaciones:

- `distinct()`: elimina los elementos repetidos.
- `sorted()`: ordena los elementos.
- `Comparator.reverseOrder()`: permite ordenar de mayor a menor.

Para eliminar valores repetidos:

```java
numeros.stream()
        .distinct()
        .forEach(System.out::println);
```

Para ordenar de menor a mayor:

```java
numeros.stream()
        .distinct()
        .sorted()
        .forEach(System.out::println);
```

Para ordenar de mayor a menor:

```java
numeros.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_10_StreamSortedDistinct
```

### Salida esperada

```text
STREAM: SORTED Y DISTINCT
-------------------------
Lista original:
8
3
5
8
2
5
10
3

Valores sin repetir:
8
3
5
2
10

Valores ordenados de menor a mayor:
2
3
5
8
10

Valores ordenados de mayor a menor:
10
8
5
3
2
```

---

## Clase de apoyo. Estudiante

Archivo:

```text
Estudiante.java
```

Esta clase representa un estudiante mediante los atributos:

- `nombre`
- `nota`
- `programa`

La clase contiene:

- Constructor.
- Métodos de acceso.
- Método `toString()`.

```java
public class Estudiante {

    private String nombre;
    private double nota;
    private String programa;

    public Estudiante(String nombre, double nota, String programa) {
        this.nombre = nombre;
        this.nota = nota;
        this.programa = programa;
    }
}
```

Esta clase no contiene el método `main`, porque funciona como modelo de datos para los ejemplos 11 y 12.

---

## Ejemplo 11. Stream API con objetos

Archivo:

```text
U4_11_StreamObjetos.java
```

Este ejemplo utiliza Stream API para procesar una colección de objetos de tipo `Estudiante`.

Las operaciones realizadas son:

- Mostrar la lista completa.
- Filtrar estudiantes aprobados.
- Filtrar estudiantes por programa.
- Ordenar estudiantes por nota.
- Obtener solamente los nombres.

### Filtrar estudiantes aprobados

```java
estudiantes.stream()
        .filter(estudiante -> estudiante.getNota() >= 3.0)
        .forEach(System.out::println);
```

### Filtrar por programa

```java
estudiantes.stream()
        .filter(estudiante ->
                estudiante.getPrograma()
                        .equals("Ingeniería de Sistemas"))
        .forEach(System.out::println);
```

### Ordenar por nota

```java
estudiantes.stream()
        .sorted(Comparator.comparingDouble(
                Estudiante::getNota).reversed())
        .forEach(System.out::println);
```

### Transformar objetos en nombres

```java
estudiantes.stream()
        .filter(estudiante -> estudiante.getNota() >= 3.0)
        .map(Estudiante::getNombre)
        .forEach(System.out::println);
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_11_StreamObjetos
```

### Salida esperada

```text
STREAM CON OBJETOS
------------------
Lista completa:
Ana | Nota: 4.5 | Programa: Ingeniería de Sistemas
Carlos | Nota: 3.2 | Programa: Ingeniería Industrial
María | Nota: 4.8 | Programa: Ingeniería de Sistemas
Juan | Nota: 2.9 | Programa: Ingeniería de Sistemas
Laura | Nota: 3.9 | Programa: Ingeniería Industrial

Estudiantes aprobados:
Ana | Nota: 4.5 | Programa: Ingeniería de Sistemas
Carlos | Nota: 3.2 | Programa: Ingeniería Industrial
María | Nota: 4.8 | Programa: Ingeniería de Sistemas
Laura | Nota: 3.9 | Programa: Ingeniería Industrial

Estudiantes de Ingeniería de Sistemas:
Ana | Nota: 4.5 | Programa: Ingeniería de Sistemas
María | Nota: 4.8 | Programa: Ingeniería de Sistemas
Juan | Nota: 2.9 | Programa: Ingeniería de Sistemas

Estudiantes ordenados por nota:
María | Nota: 4.8 | Programa: Ingeniería de Sistemas
Ana | Nota: 4.5 | Programa: Ingeniería de Sistemas
Laura | Nota: 3.9 | Programa: Ingeniería Industrial
Carlos | Nota: 3.2 | Programa: Ingeniería Industrial
Juan | Nota: 2.9 | Programa: Ingeniería de Sistemas

Nombres de los estudiantes aprobados:
Ana
Carlos
María
Laura
```

---

## Ejemplo 12. Ejercicio integrador de programación funcional

Archivo:

```text
U4_12_IntegradorFuncional.java
```

Este ejemplo combina diferentes elementos de programación funcional:

- `Predicate`
- `Function`
- Composición de condiciones
- `filter`
- `map`
- `sorted`
- `count`
- `reduce`
- Referencias a métodos

### Predicate para estudiantes aprobados

```java
Predicate<Estudiante> estaAprobado =
        estudiante -> estudiante.getNota() >= 3.0;
```

### Predicate para estudiantes de Ingeniería de Sistemas

```java
Predicate<Estudiante> perteneceASistemas =
        estudiante -> estudiante.getPrograma()
                .equals("Ingeniería de Sistemas");
```

### Function para obtener el nombre

```java
Function<Estudiante, String> obtenerNombre =
        Estudiante::getNombre;
```

### Composición de condiciones

Los dos objetos `Predicate` se combinan mediante el método `and()`:

```java
.filter(estaAprobado.and(perteneceASistemas))
```

### Conversión de nombres a mayúsculas

```java
estudiantes.stream()
        .filter(estaAprobado.and(perteneceASistemas))
        .map(obtenerNombre)
        .map(String::toUpperCase)
        .forEach(System.out::println);
```

### Conteo de estudiantes aprobados

```java
long cantidadAprobados = estudiantes.stream()
        .filter(estaAprobado)
        .count();
```

### Suma de notas con reduce

```java
double sumaNotas = estudiantes.stream()
        .filter(estaAprobado)
        .map(Estudiante::getNota)
        .reduce(0.0, Double::sum);
```

### Cálculo del promedio

```java
double promedio = cantidadAprobados > 0
        ? sumaNotas / cantidadAprobados
        : 0.0;
```

### Ejecución

```bash
java -cp unidad4/target/classes com.lelyliliana.unidad4.U4_12_IntegradorFuncional
```

### Salida esperada

La representación del separador decimal puede variar según la configuración regional del sistema.

```text
EJERCICIO INTEGRADOR
--------------------
Estudiantes aprobados de Ingeniería de Sistemas:
María | Nota: 4.8 | Programa: Ingeniería de Sistemas
Ana | Nota: 4.5 | Programa: Ingeniería de Sistemas

Nombres en mayúsculas:
ANA
MARÍA

Cantidad de estudiantes aprobados: 4
Promedio de notas de los estudiantes aprobados: 4,10
```

## Conceptos principales de la unidad

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