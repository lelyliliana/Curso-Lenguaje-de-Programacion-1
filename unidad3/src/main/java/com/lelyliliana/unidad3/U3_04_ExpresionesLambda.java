package com.lelyliliana.unidad3;

@FunctionalInterface
interface Mensaje {
    void mostrar();
}

@FunctionalInterface
interface Saludo {
    void saludar(String nombre);
}

@FunctionalInterface
interface Suma {
    int calcular(int numero1, int numero2);
}

public class U3_04_ExpresionesLambda {

    public static void main(String[] args) {

        Mensaje mensaje = () ->
                System.out.println("Ejemplo de lambda sin parámetros.");

        Saludo saludo = nombre ->
                System.out.println("Hola, " + nombre + ".");

        Suma suma = (numero1, numero2) ->
                numero1 + numero2;

        System.out.println("EXPRESIONES LAMBDA");
        System.out.println("------------------");

        mensaje.mostrar();
        saludo.saludar("Leli");

        int resultado = suma.calcular(8, 5);

        System.out.println("Resultado de la suma: " + resultado);
    }
}