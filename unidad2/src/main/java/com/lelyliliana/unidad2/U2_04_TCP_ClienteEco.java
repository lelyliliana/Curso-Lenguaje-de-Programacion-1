package com.lelyliliana.unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class U2_04_TCP_ClienteEco {

    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;

    public static void main(String[] args) {

        System.out.println("CLIENTE TCP - ECO");
        System.out.println("-----------------");

        try (
                Socket socket = new Socket(HOST, PUERTO);

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
                    "Conectado al servidor "
                            + HOST
                            + ":"
                            + PUERTO
            );

            String mensaje = "Hola desde el cliente";

            System.out.println(
                    "Mensaje enviado: " + mensaje
            );

            salida.println(mensaje);

            String respuesta = entrada.readLine();

            System.out.println(
                    "Respuesta recibida: " + respuesta
            );

        } catch (IOException e) {

            System.out.println(
                    "Error en el cliente: " + e.getMessage()
            );
        }
    }
}