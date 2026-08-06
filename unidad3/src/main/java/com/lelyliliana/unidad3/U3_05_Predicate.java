package com.lelyliliana.unidad3;

import java.util.List;
import java.util.function.Predicate;

public class U3_05_Predicate {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(3, 8, 11, 14, 19, 22);

        Predicate<Integer> esPar = numero -> numero % 2 == 0;
        Predicate<Integer> esMayorQueDiez = numero -> numero > 10;

        System.out.println("USO DE PREDICATE");
        System.out.println("----------------");

        System.out.println("Números pares:");

        numeros.stream()
                .filter(esPar)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Números mayores que 10:");

        numeros.stream()
                .filter(esMayorQueDiez)
                .forEach(System.out::println);
    }
}