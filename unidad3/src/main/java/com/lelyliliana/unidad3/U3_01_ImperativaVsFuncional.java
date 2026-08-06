package com.lelyliliana.unidad3;

import java.util.Arrays;

public class U3_01_ImperativaVsFuncional {

    public static void main(String[] args) {

        int[] numeros = {8, 3, 12, 5, 2, 10};

        System.out.println("PROGRAMACIÓN IMPERATIVA");
        System.out.println("-----------------------");

        int minimoImperativo = numeros[0];

        for (int numero : numeros) {
            if (numero < minimoImperativo) {
                minimoImperativo = numero;
            }
        }

        System.out.println("El número menor es: " + minimoImperativo);

        System.out.println();
        System.out.println("PROGRAMACIÓN FUNCIONAL");
        System.out.println("----------------------");

        int minimoFuncional = Arrays.stream(numeros)
                .min()
                .orElseThrow();

        System.out.println("El número menor es: " + minimoFuncional);
    }
}