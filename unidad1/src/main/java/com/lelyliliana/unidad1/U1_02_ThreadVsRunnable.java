package com.lelyliliana.unidad1;

public class U1_02_ThreadVsRunnable {

    static class HiloConThread extends Thread {

        private final String nombre;

        public HiloConThread(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                        "Thread -> " + nombre + " - iteración " + i
                );
            }
        }
    }

    static class TareaConRunnable implements Runnable {

        private final String nombre;

        public TareaConRunnable(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                        "Runnable -> " + nombre + " - iteración " + i
                );
            }
        }
    }

    public static void main(String[] args) {

        HiloConThread hilo1 =
                new HiloConThread("Hilo A");

        Thread hilo2 =
                new Thread(
                        new TareaConRunnable("Hilo B")
                );

        System.out.println("Inicio del programa");

        hilo1.start();
        hilo2.start();

        System.out.println("Fin del hilo principal");
    }
}