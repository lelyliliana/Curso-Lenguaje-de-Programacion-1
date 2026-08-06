package com.lelyliliana.unidad1;

public class U1_05_Join {

    static class Tarea implements Runnable {

        private final String nombre;

        public Tarea(String nombre) {
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

                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println(nombre + " ha terminado.");
        }
    }

    public static void main(String[] args) {

        Thread hilo1 =
                new Thread(new Tarea("Tarea A"), "Hilo-A");

        Thread hilo2 =
                new Thread(new Tarea("Tarea B"), "Hilo-B");

        System.out.println("Inicio del hilo principal");

        hilo1.start();
        hilo2.start();

        try {

            System.out.println(
                    "El hilo principal esperará a que terminen los otros hilos."
            );

            hilo1.join();
            hilo2.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Los dos hilos terminaron. Continúa el hilo principal."
        );
    }
}