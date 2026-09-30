# U3_07 – Referencias a métodos

## Objetivo

Usar métodos existentes como implementaciones funcionales.

## Conceptos principales

El operador :: referencia un método compatible con la interfaz destino. System.out::println consume un valor; String::toUpperCase transforma una cadena.

## Archivo principal

[U3_07_ReferenciaMetodos.java](../../src/main/java/com/lelyliliana/unidad3/U3_07_ReferenciaMetodos.java)

## ¿Qué hace el ejemplo?

Imprime Ana, Carlos, María y Juan con lambda y con referencia a método; después muestra sus nombres en mayúsculas.

## Código clave

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

## Flujo de ejecución

```text
Recorrer con lambda
↓
recorrer con println referenciado
↓
map(toUpperCase)
↓
imprimir
```

## Cómo ejecutar

Desde la **raíz del repositorio**, con JDK 21 y Maven:

```bash
mvn -pl unidad3 compile
java -cp unidad3/target/classes com.lelyliliana.unidad3.U3_07_ReferenciaMetodos
```

La ejecución termina automáticamente al completar el ejemplo.

## Resultado esperado

Las dos primeras secuencias coinciden; la tercera muestra ANA, CARLOS, MARÍA y JUAN con la configuración regional habitual.

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

## Qué observar

- Las primeras dos listas son iguales.
- map produce cadenas transformadas.
- La lista original mantiene sus nombres.

## Experimenta

Sustituye String::toUpperCase por String::toLowerCase y ajusta la etiqueta. Después de editar el código, vuelve a compilar la unidad.

---

[← Volver a la Unidad 3](../../README.md) · [← Ejemplo anterior](../ejemplo06/README.md) · [Siguiente ejemplo →](../ejemplo08/README.md)
