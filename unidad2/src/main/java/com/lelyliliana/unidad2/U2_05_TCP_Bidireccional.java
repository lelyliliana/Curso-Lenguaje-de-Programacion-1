package com.lelyliliana.unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class U2_05_TCP_Bidireccional {

    private static final int PUERTO = 5001;

    public static void main(String[] args) {

        Thread servidor = new Thread(() -> {

            try (
                    ServerSocket serverSocket =
                            new ServerSocket(PUERTO);

                    Socket socket =
                            serverSocket.accept();

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

                System.out.println(
                        "Servidor: cliente conectado."
                );

                String mensaje;

                while ((mensaje = entrada.readLine()) != null) {

                    System.out.println(
                            "Servidor recibió: " + mensaje
                    );

                    if (mensaje.equalsIgnoreCase("salir")) {
                        salida.println("Conexión finalizada.");
                        break;
                    }

                    salida.println(
                            "Respuesta del servidor: "
                                    + mensaje.toUpperCase()
                    );
                }

            } catch (IOException e) {

                System.out.println(
                        "Error en servidor: "
                                + e.getMessage()
                );
            }

        }, "Servidor-TCP");

        Thread cliente = new Thread(() -> {

            try {

                Thread.sleep(500);

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

                    String[] mensajes = {
                            "Hola servidor",
                            "Estamos trabajando con TCP",
                            "salir"
                    };

                    for (String mensaje : mensajes) {

                        System.out.println(
                                "Cliente envía: " + mensaje
                        );

                        salida.println(mensaje);

                        String respuesta =
                                entrada.readLine();

                        System.out.println(
                                "Cliente recibe: "
                                        + respuesta
                        );

                        if (mensaje.equalsIgnoreCase("salir")) {
                            break;
                        }
                    }
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            } catch (IOException e) {

                System.out.println(
                        "Error en cliente: "
                                + e.getMessage()
                );
            }

        }, "Cliente-TCP");

        servidor.start();
        cliente.start();

        try {
            servidor.join();
            cliente.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Comunicación finalizada.");
    }
}