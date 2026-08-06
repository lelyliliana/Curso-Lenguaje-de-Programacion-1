package com.lelyliliana.unidad1;

public class U1_06_EstadosHilo {

    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new Thread(() -> {

            System.out.println(
                    "Dentro del hilo. Estado actual: "
                            + Thread.currentThread().getState()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }, "Hilo-Ejemplo");

        System.out.println("Estado al crear el hilo: "
                + hilo.getState());

        hilo.start();

        System.out.println("Estado después de start(): "
                + hilo.getState());

        Thread.sleep(200);

        System.out.println("Estado mientras está en sleep(): "
                + hilo.getState());

        hilo.join();

        System.out.println("Estado después de terminar: "
                + hilo.getState());
    }
}