package com.lelyliliana.unidad2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class U2_10_EnvioObjetosTCP {

    private static final int PUERTO = 6001;

    static class Estudiante implements Serializable {

        private static final long serialVersionUID = 1L;

        private final String nombre;
        private final String programa;
        private final double nota;

        public Estudiante(
                String nombre,
                String programa,
                double nota
        ) {
            this.nombre = nombre;
            this.programa = programa;
            this.nota = nota;
        }

        @Override
        public String toString() {
            return nombre
                    + " | Programa: " + programa
                    + " | Nota: " + nota;
        }
    }

    public static void main(String[] args) {

        Thread servidor = new Thread(() -> {

            try (
                    ServerSocket serverSocket =
                            new ServerSocket(PUERTO);

                    Socket socket =
                            serverSocket.accept();

                    ObjectInputStream entrada =
                            new ObjectInputStream(
                                    socket.getInputStream()
                            );

                    ObjectOutputStream salida =
                            new ObjectOutputStream(
                                    socket.getOutputStream()
                            )
            ) {

                System.out.println(
                        "Servidor: cliente conectado."
                );

                Estudiante estudiante =
                        (Estudiante) entrada.readObject();

                System.out.println(
                        "Servidor recibió:"
                );

                System.out.println(estudiante);

                salida.writeObject(
                        "Objeto recibido correctamente"
                );

                salida.flush();

            } catch (IOException | ClassNotFoundException e) {

                System.out.println(
                        "Error en servidor: "
                                + e.getMessage()
                );
            }

        }, "Servidor-Objetos");

        Thread cliente = new Thread(() -> {

            try {

                Thread.sleep(500);

                try (
                        Socket socket =
                                new Socket(
                                        "localhost",
                                        PUERTO
                                );

                        ObjectOutputStream salida =
                                new ObjectOutputStream(
                                        socket.getOutputStream()
                                );

                        ObjectInputStream entrada =
                                new ObjectInputStream(
                                        socket.getInputStream()
                                )
                ) {

                    Estudiante estudiante =
                            new Estudiante(
                                    "María",
                                    "Ingeniería de Sistemas",
                                    4.8
                            );

                    System.out.println(
                            "Cliente envía:"
                    );

                    System.out.println(estudiante);

                    salida.writeObject(estudiante);
                    salida.flush();

                    String respuesta =
                            (String) entrada.readObject();

                    System.out.println(
                            "Cliente recibe: "
                                    + respuesta
                    );
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            } catch (IOException | ClassNotFoundException e) {

                System.out.println(
                        "Error en cliente: "
                                + e.getMessage()
                );
            }

        }, "Cliente-Objetos");

        servidor.start();
        cliente.start();

        try {

            servidor.join();
            cliente.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Transferencia de objeto finalizada."
        );
    }
}