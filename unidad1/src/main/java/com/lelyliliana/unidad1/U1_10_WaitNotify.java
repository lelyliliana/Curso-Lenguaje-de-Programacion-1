package com.lelyliliana.unidad1;

public class U1_10_WaitNotify {

    static class Bandeja {

        private String mensaje;
        private boolean disponible = false;

        public synchronized void producir(String nuevoMensaje) {

            while (disponible) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            mensaje = nuevoMensaje;
            disponible = true;

            System.out.println(
                    "Productor envió: " + mensaje
            );

            notifyAll();
        }

        public synchronized String consumir() {

            while (!disponible) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }

            String resultado = mensaje;
            disponible = false;

            notifyAll();

            return resultado;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Bandeja bandeja = new Bandeja();

        Thread consumidor = new Thread(() -> {

            String mensaje = bandeja.consumir();

            System.out.println(
                    "Consumidor recibió: " + mensaje
            );

        }, "Consumidor");

        Thread productor = new Thread(() -> {

            bandeja.producir(
                    "Mensaje enviado entre hilos"
            );

        }, "Productor");

        consumidor.start();

        Thread.sleep(500);

        productor.start();

        consumidor.join();
        productor.join();

        System.out.println("Proceso terminado.");
    }
}