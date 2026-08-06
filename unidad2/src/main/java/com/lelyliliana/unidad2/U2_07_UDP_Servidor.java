package com.lelyliliana.unidad2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class U2_07_UDP_Servidor {

    private static final int PUERTO = 6000;
    private static final int TAMANO_BUFFER = 1024;

    public static void main(String[] args) {

        System.out.println("SERVIDOR UDP");
        System.out.println("------------");

        byte[] buffer = new byte[TAMANO_BUFFER];

        try (DatagramSocket socket =
                     new DatagramSocket(PUERTO)) {

            System.out.println(
                    "Servidor UDP escuchando en el puerto "
                            + PUERTO
            );

            DatagramPacket paqueteEntrada =
                    new DatagramPacket(
                            buffer,
                            buffer.length
                    );

            socket.receive(paqueteEntrada);

            String mensaje =
                    new String(
                            paqueteEntrada.getData(),
                            0,
                            paqueteEntrada.getLength(),
                            StandardCharsets.UTF_8
                    );

            System.out.println(
                    "Mensaje recibido: " + mensaje
            );

            System.out.println(
                    "IP del cliente: "
                            + paqueteEntrada
                                    .getAddress()
                                    .getHostAddress()
            );

            System.out.println(
                    "Puerto del cliente: "
                            + paqueteEntrada.getPort()
            );

            String respuesta =
                    "Servidor UDP recibió: " + mensaje;

            byte[] datosRespuesta =
                    respuesta.getBytes(
                            StandardCharsets.UTF_8
                    );

            DatagramPacket paqueteSalida =
                    new DatagramPacket(
                            datosRespuesta,
                            datosRespuesta.length,
                            paqueteEntrada.getAddress(),
                            paqueteEntrada.getPort()
                    );

            socket.send(paqueteSalida);

            System.out.println(
                    "Respuesta enviada al cliente."
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