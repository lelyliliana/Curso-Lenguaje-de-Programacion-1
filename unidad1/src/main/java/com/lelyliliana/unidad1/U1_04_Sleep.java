package com.lelyliliana.unidad1;

public class U1_04_Sleep {

    static class Tarea implements Runnable {

        private final String nombre;

        public Tarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {

            for (int i = 1; i <= 5; i++) {

                System.out.println(
                        nombre
                                + " - iteración " + i
                                + " - hilo: "
                                + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(nombre + " fue interrumpido.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread hilo1 =
                new Thread(new Tarea("Tarea A"), "Hilo-A");

        Thread hilo2 =
                new Thread(new Tarea("Tarea B"), "Hilo-B");

        System.out.println("Inicio del programa");

        hilo1.start();
        hilo2.start();

        System.out.println("El hilo principal continúa su ejecución.");
    }
}