package com.lelyliliana.unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class U2_12_IntegradorRedes {

    private static final int PUERTO = 7000;

    static class Servidor implements Runnable {

        @Override
        public void run() {

            try (
                    ServerSocket serverSocket =
                            new ServerSocket(PUERTO)
            ) {

                System.out.println(
                        "Servidor disponible en el puerto "
                                + PUERTO
                );

                for (int i = 1; i <= 3; i++) {

                    Socket socket =
                            serverSocket.accept();

                    Thread hiloCliente =
                            new Thread(
                                    new AtenderCliente(socket),
                                    "Atencion-" + i
                            );

                    hiloCliente.start();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error en servidor: "
                                + e.getMessage()
                );
            }
        }
    }

    static class AtenderCliente implements Runnable {

        private final Socket socket;

        public AtenderCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (
                    Socket cliente = socket;

                    BufferedReader entrada =
                            new BufferedReader(
                                    new InputStreamReader(
                                            cliente.getInputStream()
                                    )
                            );

                    PrintWriter salida =
                            new PrintWriter(
                                    cliente.getOutputStream(),
                                    true
                            )
            ) {

                String nombre = entrada.readLine();
                String operacion = entrada.readLine();

                System.out.println(
                        Thread.currentThread().getName()
                                + " atiende a "
                                + nombre
                );

                String respuesta =
                        procesarOperacion(
                                nombre,
                                operacion
                        );

                salida.println(respuesta);

            } catch (IOException e) {

                System.out.println(
                        "Error atendiendo cliente: "
                                + e.getMessage()
                );
            }
        }
    }

    static class Cliente implements Runnable {

        private final String nombre;
        private final String operacion;

        public Cliente(
                String nombre,
                String operacion
        ) {
            this.nombre = nombre;
            this.operacion = operacion;
        }

        @Override
        public void run() {

            try (
                    Socket socket =
                            new Socket(
                                    "localhost",
                                    PUERTO
                            );

                    BufferedReader entrada =
                            new BufferedReader(
                                    new InputStreamReader(
                                            socket.getInputStream()
                                    )
                            );

                    PrintWriter salida =
                            new PrintWriter(
                                    socket.getOutputStream(),
                                    true
                            )
            ) {

                salida.println(nombre);
                salida.println(operacion);

                String respuesta =
                        entrada.readLine();

                System.out.println(
                        nombre
                                + " recibió: "
                                + respuesta
                );

            } catch (IOException e) {

                System.out.println(
                        nombre
                                + " - Error: "
                                + e.getMessage()
                );
            }
        }
    }

    private static String procesarOperacion(
            String nombre,
            String operacion
    ) {

        return switch (operacion.toLowerCase()) {

            case "saludo" ->
                    "Hola, "
                            + nombre
                            + ". Bienvenido al servidor.";

            case "hora" ->
                    "Solicitud de hora recibida correctamente.";

            case "estado" ->
                    "Servidor activo y atendiendo solicitudes.";

            default ->
                    "Operación no reconocida.";
        };
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread servidor =
                new Thread(
                        new Servidor(),
                        "Servidor-Principal"
                );

        servidor.start();

        Thread.sleep(500);

        Thread cliente1 =
                new Thread(
                        new Cliente(
                                "Ana",
                                "saludo"
                        )
                );

        Thread cliente2 =
                new Thread(
                        new Cliente(
                                "Carlos",
                                "estado"
                        )
                );

        Thread cliente3 =
                new Thread(
                        new Cliente(
                                "María",
                                "hora"
                        )
                );

        cliente1.start();
        cliente2.start();
        cliente3.start();

        cliente1.join();
        cliente2.join();
        cliente3.join();

        servidor.join();

        System.out.println(
                "Ejemplo integrador finalizado."
        );
    }
}