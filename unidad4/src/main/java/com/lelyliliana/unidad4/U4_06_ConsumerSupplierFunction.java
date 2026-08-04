package com.lelyliliana.unidad4;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class U4_06_ConsumerSupplierFunction {

    public static void main(String[] args) {

        Supplier<String> obtenerMensaje = () ->
                "Bienvenidos a la programación funcional en Java.";

        Consumer<String> mostrarMensaje = mensaje ->
                System.out.println(mensaje);

        Function<Integer, Integer> calcularCuadrado = numero ->
                numero * numero;

        System.out.println("CONSUMER, SUPPLIER Y FUNCTION");
        System.out.println("-----------------------------");

        String mensaje = obtenerMensaje.get();
        mostrarMensaje.accept(mensaje);

        int numero = 5;
        int resultado = calcularCuadrado.apply(numero);

        System.out.println();
        System.out.println("Número recibido: " + numero);
        System.out.println("Cuadrado del número: " + resultado);
    }
}