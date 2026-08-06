package com.lelyliliana.unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class U2_03_TCP_ServidorEco {

    private static final int PUERTO = 5000;

    public static void main(String[] args) {

        System.out.println("SERVIDOR TCP - ECO");
        System.out.println("------------------");

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {

            System.out.println(
                    "Servidor escuchando en el puerto " + PUERTO
            );

            try (
                    Socket cliente = servidor.accept();

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

                System.out.println(
                        "Cliente conectado desde: "
                                + cliente.getInetAddress().getHostAddress()
                );

                String mensaje = entrada.readLine();

                System.out.println(
                        "Mensaje recibido: " + mensaje
                );

                salida.println(
                        "Servidor responde: " + mensaje
                );

                System.out.println("Respuesta enviada.");

            }

        } catch (IOException e) {

            System.out.println(
                    "Error en el servidor: " + e.getMessage()
            );
        }
    }
}