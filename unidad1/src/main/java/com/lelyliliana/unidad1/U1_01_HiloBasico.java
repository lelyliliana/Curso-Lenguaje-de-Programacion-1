package com.lelyliliana.unidad1;

public class U1_01_HiloBasico extends Thread {

    private final String nombre;

    public U1_01_HiloBasico(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " - iteración " + i);
        }
    }

    public static void main(String[] args) {

        U1_01_HiloBasico hilo1 =
                new U1_01_HiloBasico("Hilo A");

        U1_01_HiloBasico hilo2 =
                new U1_01_HiloBasico("Hilo B");

        System.out.println("Inicio del hilo principal");

        hilo1.start();
        hilo2.start();

        System.out.println("Fin del hilo principal");
    }
}