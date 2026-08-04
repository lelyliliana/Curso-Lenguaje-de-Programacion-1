package com.lelyliliana.unidad4;

public class U4_02_FuncionPura {

    public static void main(String[] args) {

        int numero = 6;

        int resultado1 = calcularCuadrado(numero);
        int resultado2 = calcularCuadrado(numero);

        System.out.println("FUNCIÓN PURA");
        System.out.println("------------");
        System.out.println("Número recibido: " + numero);
        System.out.println("Primer resultado: " + resultado1);
        System.out.println("Segundo resultado: " + resultado2);
    }

    public static int calcularCuadrado(int numero) {
        return numero * numero;
    }
}