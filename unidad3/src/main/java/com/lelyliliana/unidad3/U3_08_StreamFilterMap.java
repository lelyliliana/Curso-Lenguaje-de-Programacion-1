package com.lelyliliana.unidad3;

import java.util.List;

public class U3_08_StreamFilterMap {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(
                2, 5, 8, 11, 14, 17, 20
        );

        System.out.println("STREAM: FILTER Y MAP");
        System.out.println("--------------------");

        System.out.println("Lista original:");
        numeros.forEach(System.out::println);

        System.out.println();
        System.out.println("Números pares:");

        numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Cuadrado de los números pares:");

        numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * numero)
                .forEach(System.out::println);
    }
}