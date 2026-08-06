package com.lelyliliana.unidad2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class U2_08_UDP_Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 6000;
    private static final int TAMANO_BUFFER = 1024;

    public static void main(String[] args) {

        System.out.println("CLIENTE UDP");
        System.out.println("-----------");

        try (DatagramSocket socket = new DatagramSocket()) {

            String mensaje =
                    "Hola desde el cliente UDP";

            byte[] datos =
                    mensaje.getBytes(
                            StandardCharsets.UTF_8
                    );

            InetAddress direccionServidor =
                    InetAddress.getByName(HOST);

            DatagramPacket paqueteSalida =
                    new DatagramPacket(
                            datos,
                            datos.length,
                            direccionServidor,
                            PUERTO
                    );

            System.out.println(
                    "Enviando mensaje: " + mensaje
            );

            socket.send(paqueteSalida);

            byte[] buffer =
                    new byte[TAMANO_BUFFER];

            DatagramPacket paqueteEntrada =
                    new DatagramPacket(
                            buffer,
                            buffer.length
                    );

            socket.receive(paqueteEntrada);

            String respuesta =
                    new String(
                            paqueteEntrada.getData(),
                            0,
                            paqueteEntrada.getLength(),
                            StandardCharsets.UTF_8
                    );

            System.out.println(
                    "Respuesta recibida: " + respuesta
            );

        } catch (SocketException e) {

            System.out.println(
                    "Error al crear el socket UDP: "
                            + e.getMessage()
            );

        } catch (IOException e) {

            System.out.println(
                    "Error de comunicación UDP: "
                            + e.getMessage()
            );
        }
    }
}