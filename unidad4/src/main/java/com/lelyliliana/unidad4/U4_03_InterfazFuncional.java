package com.lelyliliana.unidad4;

@FunctionalInterface
interface OperacionMatematica {

    int calcular(int numero);
}

public class U4_03_InterfazFuncional {

    public static void main(String[] args) {

        OperacionMatematica duplicar = numero -> numero * 2;

        int numero = 7;
        int resultado = duplicar.calcular(numero);

        System.out.println("INTERFAZ FUNCIONAL");
        System.out.println("------------------");
        System.out.println("Número recibido: " + numero);
        System.out.println("Resultado al duplicar: " + resultado);
    }
}