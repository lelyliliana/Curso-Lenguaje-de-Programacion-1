# Estudiante – Clase de apoyo

## Objetivo

Representar los datos consultados por los ejemplos 11 y 12.

## Archivo principal

[Estudiante.java](../../src/main/java/com/lelyliliana/unidad3/Estudiante.java)

## Estructura y código clave

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

Los getters permiten consultar los atributos; `toString()` produce la representación `nombre | Nota: nota | Programa: programa`. No hay setters públicos.

## Cómo utilizarla

No se ejecuta directamente: no contiene `main`. Se compila con `mvn -pl unidad3 compile` desde la raíz y se utiliza al ejecutar [U3_11](../ejemplo11/README.md) o [U3_12](../ejemplo12/README.md).

El constructor recibe los argumentos en el orden **nombre, nota, programa**. Es un modelo distinto de las clases internas serializables de la Unidad 2.

## Qué observar

- Los predicados leen la nota y el programa mediante getters.
- Las referencias a métodos permiten extraer nombres o comparar notas.

[← Volver a la Unidad 3](../../README.md)
