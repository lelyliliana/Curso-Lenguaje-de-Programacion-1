package com.lelyliliana.unidad2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class U2_01_InetAddress {

    public static void main(String[] args) {

        try {

            InetAddress equipoLocal = InetAddress.getLocalHost();

            System.out.println("INFORMACIÓN DEL EQUIPO LOCAL");
            System.out.println("----------------------------");

            System.out.println(
                    "Nombre del equipo: "
                            + equipoLocal.getHostName()
            );

            System.out.println(
                    "Dirección IP: "
                            + equipoLocal.getHostAddress()
            );

            System.out.println();

            InetAddress localhost =
                    InetAddress.getByName("localhost");

            System.out.println("INFORMACIÓN DE LOCALHOST");
            System.out.println("------------------------");

            System.out.println(
                    "Nombre: "
                            + localhost.getHostName()
            );

            System.out.println(
                    "Dirección IP: "
                            + localhost.getHostAddress()
            );

        } catch (UnknownHostException e) {

            System.out.println(
                    "No fue posible obtener la información de red."
            );
        }
    }
}