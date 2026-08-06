package com.lelyliliana.unidad1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class U1_11_ReentrantLock {

    static class Contador {

        private int valor = 0;

        private final Lock lock = new ReentrantLock();

        public void incrementar() {

            lock.lock();

            try {
                valor++;
            } finally {
                lock.unlock();
            }
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

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
        System.out.println(
                "Valor obtenido: " + contador.getValor()
        );
    }
}