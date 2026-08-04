package com.lelyliliana.unidad4;

import java.util.List;
import java.util.function.Function;

public class U4_07_ReferenciaMetodos {

    public static void main(String[] args) {

        List<String> estudiantes = List.of(
                "Ana",
                "Carlos",
                "María",
                "Juan"
        );

        System.out.println("REFERENCIAS A MÉTODOS");
        System.out.println("---------------------");

        System.out.println("Expresión lambda:");

        estudiantes.forEach(nombre ->
                System.out.println(nombre));

        System.out.println();
        System.out.println("Referencia a método:");

        estudiantes.forEach(System.out::println);

        System.out.println();
        System.out.println("Conversión a mayúsculas:");

        Function<String, String> convertirMayusculas =
                String::toUpperCase;

        estudiantes.stream()
                .map(convertirMayusculas)
                .forEach(System.out::println);
    }
}