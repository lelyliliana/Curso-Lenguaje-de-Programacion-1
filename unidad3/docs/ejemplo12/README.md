# U3_12 – Ejercicio integrador de programación funcional

## Objetivo

Combinar predicados, transformaciones y agregaciones.

## Conceptos principales

and() exige ambas condiciones; count() cuenta y reduce() suma notas. Un promedio requiere dividir la suma entre la cantidad, comprobando antes que no sea cero.

## Archivo principal

[U3_12_IntegradorFuncional.java](../../src/main/java/com/lelyliliana/unidad3/U3_12_IntegradorFuncional.java)

## ¿Qué hace el ejemplo?

Muestra aprobados de Sistemas ordenados por nota, sus nombres en mayúsculas y el conteo y promedio de todos los aprobados. Utiliza [Estudiante.java](../../src/main/java/com/lelyliliana/unidad3/Estudiante.java); Maven compila también esta clase de apoyo.

## Código clave

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

## Flujo de ejecución

```text
Crear predicados
↓
combinar y ordenar
↓
transformar nombres
↓
contar aprobados
↓
sumar notas
↓
calcular promedio
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_12_IntegradorFuncional
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

El promedio 4.10 corresponde a Ana, Carlos, María y Laura; el separador decimal depende de la configuración regional. Consulta la [clase de apoyo Estudiante](../estudiante/README.md).

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

## Qué observar

- La primera consulta combina programa y aprobación.
- El conteo y promedio abarcan todos los programas.
- La consulta de nombres no contiene sorted(), por eso muestra Ana antes de María.

## Experimenta

Cambia el umbral de aprobación a 5.0 y observa cantidad 0 y promedio 0.00, sin división entre cero. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo11/README.md)
