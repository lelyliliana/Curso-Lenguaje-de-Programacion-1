# U3_11 – Stream API con objetos

## Objetivo

Aplicar filtros, ordenación y proyección a objetos.

## Conceptos principales

Un predicado consulta atributos del objeto; Comparator.comparingDouble ordena por nota y map(Estudiante::getNombre) proyecta cada estudiante a su nombre.

## Archivo principal

[U3_11_StreamObjetos.java](../../src/main/java/com/lelyliliana/unidad3/U3_11_StreamObjetos.java)

## ¿Qué hace el ejemplo?

Consulta cinco estudiantes: aprobados con nota >= 3.0, integrantes de Sistemas, orden por nota y nombres de aprobados. Utiliza [Estudiante.java](../../src/main/java/com/lelyliliana/unidad3/Estudiante.java); Maven compila también esta clase de apoyo.

## Código clave

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

## Flujo de ejecución

```text
Construir estudiantes
↓
filtrar por nota
↓
filtrar por programa
↓
ordenar
↓
proyectar nombres
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_11_StreamObjetos
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Consulta también la [clase de apoyo Estudiante](../estudiante/README.md), usada por este ejemplo.

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

## Qué observar

- Juan no aprueba con 2.9.
- El filtro por programa es independiente de la aprobación.
- El orden por nota es descendente.

## Experimenta

Cambia la nota de Juan a 3.0 y observa su inclusión entre aprobados. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo10/README.md) · [Siguiente ejemplo →](../ejemplo12/README.md)
