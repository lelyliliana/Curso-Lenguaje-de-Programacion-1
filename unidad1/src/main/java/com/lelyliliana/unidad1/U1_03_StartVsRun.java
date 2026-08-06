package com.lelyliliana.unidad1;

public class U1_03_StartVsRun {

    static class MiHilo extends Thread {

        private final String nombre;

        public MiHilo(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                        nombre
                                + " - iteración " + i
                                + " - ejecutado por: "
                                + Thread.currentThread().getName()
                );
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("EJECUCIÓN CON run()");
        System.out.println("-------------------");

        MiHilo hilo1 = new MiHilo("Tarea A");
        MiHilo hilo2 = new MiHilo("Tarea B");

        hilo1.run();
        hilo2.run();

        System.out.println();
        System.out.println("EJECUCIÓN CON start()");
        System.out.println("---------------------");

        MiHilo hilo3 = new MiHilo("Tarea C");
        MiHilo hilo4 = new MiHilo("Tarea D");

        hilo3.start();
        hilo4.start();
    }
}