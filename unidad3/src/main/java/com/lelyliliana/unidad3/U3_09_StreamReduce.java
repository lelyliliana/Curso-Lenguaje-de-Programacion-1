package com.lelyliliana.unidad3;

import java.util.List;

public class U3_09_StreamReduce {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(
                2, 4, 6, 8, 10
        );

        System.out.println("STREAM: REDUCE");
        System.out.println("--------------");

        int sumaImperativa = 0;

        for (int numero : numeros) {
            sumaImperativa += numero;
        }

        System.out.println("Suma con programación imperativa: "
                + sumaImperativa);

        int sumaFuncional = numeros.stream()
                .reduce(0, (acumulador, numero) ->
                        acumulador + numero);

        System.out.println("Suma con programación funcional: "
                + sumaFuncional);

        int producto = numeros.stream()
                .reduce(1, (acumulador, numero) ->
                        acumulador * numero);

        System.out.println("Producto de los números: " + producto);
    }
}