package com.lelyliliana.unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class U2_06_TCP_Multicliente {

    private static final int PUERTO = 5002;

    static class ManejadorCliente implements Runnable {

        private final Socket socket;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            String nombreHilo =
                    Thread.currentThread().getName();

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

                String mensaje = entrada.readLine();

                System.out.println(
                        nombreHilo
                                + " recibió: "
                                + mensaje
                );

                salida.println(
                        "Respuesta desde "
                                + nombreHilo
                                + ": "
                                + mensaje.toUpperCase()
                );

            } catch (IOException e) {

                System.out.println(
                        nombreHilo
                                + " - Error: "
                                + e.getMessage()
                );
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread servidor = new Thread(() -> {

            try (
                    ServerSocket serverSocket =
                            new ServerSocket(PUERTO)
            ) {

                System.out.println(
                        "Servidor multicliente escuchando en puerto "
                                + PUERTO
                );

                for (int i = 1; i <= 3; i++) {

                    Socket cliente =
                            serverSocket.accept();

                    Thread hiloCliente =
                            new Thread(
                                    new ManejadorCliente(cliente),
                                    "Cliente-" + i
                            );

                    hiloCliente.start();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error en servidor: "
                                + e.getMessage()
                );
            }

        }, "Servidor-Multicliente");

        servidor.start();

        Thread.sleep(500);

        Thread cliente1 =
                crearCliente(
                        "Mensaje del primer cliente",
                        "Cliente-A"
                );

        Thread cliente2 =
                crearCliente(
                        "Mensaje del segundo cliente",
                        "Cliente-B"
                );

        Thread cliente3 =
                crearCliente(
                        "Mensaje del tercer cliente",
                        "Cliente-C"
                );

        cliente1.start();
        cliente2.start();
        cliente3.start();

        cliente1.join();
        cliente2.join();
        cliente3.join();

        servidor.join();

        System.out.println(
                "Todos los clientes fueron atendidos."
        );
    }

    private static Thread crearCliente(
            String mensaje,
            String nombre
    ) {

        return new Thread(() -> {

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

                salida.println(mensaje);

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

        }, nombre);
    }
}