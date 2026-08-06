package com.lelyliliana.unidad1;

public class U1_12_IntegradorConcurrencia {

    static class CuentaBancaria {

        private double saldo;

        public CuentaBancaria(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public synchronized void retirar(
                String nombreCliente,
                double cantidad
        ) {

            System.out.println(
                    nombreCliente
                            + " intenta retirar $"
                            + cantidad
            );

            if (saldo >= cantidad) {

                System.out.println(
                        nombreCliente
                                + " puede realizar el retiro."
                );

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                saldo -= cantidad;

                System.out.println(
                        nombreCliente
                                + " retiró $"
                                + cantidad
                );

                System.out.println(
                        "Saldo disponible: $" + saldo
                );

            } else {

                System.out.println(
                        nombreCliente
                                + " no puede retirar $"
                                + cantidad
                                + ". Saldo insuficiente."
                );
            }

            System.out.println();
        }

        public synchronized double getSaldo() {
            return saldo;
        }
    }

    static class Cliente implements Runnable {

        private final String nombre;
        private final CuentaBancaria cuenta;
        private final double cantidad;

        public Cliente(
                String nombre,
                CuentaBancaria cuenta,
                double cantidad
        ) {
            this.nombre = nombre;
            this.cuenta = cuenta;
            this.cantidad = cantidad;
        }

        @Override
        public void run() {
            cuenta.retirar(nombre, cantidad);
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        CuentaBancaria cuenta =
                new CuentaBancaria(1000);

        Thread cliente1 = new Thread(
                new Cliente(
                        "Cliente A",
                        cuenta,
                        700
                ),
                "Hilo-Cliente-A"
        );

        Thread cliente2 = new Thread(
                new Cliente(
                        "Cliente B",
                        cuenta,
                        500
                ),
                "Hilo-Cliente-B"
        );

        System.out.println(
                "Saldo inicial: $" + cuenta.getSaldo()
        );

        System.out.println();

        cliente1.start();
        cliente2.start();

        cliente1.join();
        cliente2.join();

        System.out.println(
                "Saldo final: $" + cuenta.getSaldo()
        );
    }
}