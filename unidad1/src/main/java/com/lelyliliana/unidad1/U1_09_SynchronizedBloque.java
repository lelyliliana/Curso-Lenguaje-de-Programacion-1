package com.lelyliliana.unidad1;

public class U1_09_SynchronizedBloque {

    static class Contador {

        private int valor = 0;

        public void incrementar() {

            // Código que no necesita sincronización
            int temporal = 1 + 1;

            synchronized (this) {
                valor++;
            }

            // Otra operación independiente
            if (temporal == 2) {
                // No se requiere hacer nada
            }
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        Runnable tarea = () -> {

            for (int i = 0; i < 100_000; i++) {
                contador.incrementar();
            }
        };

        Thread hilo1 = new Thread(tarea, "Hilo-A");
        Thread hilo2 = new Thread(tarea, "Hilo-B");

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Valor esperado: 200000");
        System.out.println("Valor obtenido: " + contador.getValor());
    }
}