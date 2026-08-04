package com.lelyliliana.unidad4;

import java.util.Comparator;
import java.util.List;

public class U4_10_StreamSortedDistinct {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(
                8, 3, 5, 8, 2, 5, 10, 3
        );

        System.out.println("STREAM: SORTED Y DISTINCT");
        System.out.println("-------------------------");

        System.out.println("Lista original:");
        numeros.forEach(System.out::println);

        System.out.println();
        System.out.println("Valores sin repetir:");

        numeros.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Valores ordenados de menor a mayor:");

        numeros.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Valores ordenados de mayor a menor:");

        numeros.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}