package com.lelyliliana.unidad2;

import java.net.MalformedURLException;
import java.net.URL;

public class U2_02_URL {

    public static void main(String[] args) {

        try {

            URL direccion = java.net.URI.create(
                "https://www.ejemplo.com:443/cursos/java?unidad=2#network"
            ).toURL();

            System.out.println("COMPONENTES DE UNA URL");
            System.out.println("----------------------");

            System.out.println(
                    "Protocolo: " + direccion.getProtocol()
            );

            System.out.println(
                    "Host: " + direccion.getHost()
            );

            System.out.println(
                    "Puerto: " + direccion.getPort()
            );

            System.out.println(
                    "Puerto por defecto: "
                            + direccion.getDefaultPort()
            );

            System.out.println(
                    "Ruta: " + direccion.getPath()
            );

            System.out.println(
                    "Consulta: " + direccion.getQuery()
            );

            System.out.println(
                    "Referencia: " + direccion.getRef()
            );

        } catch (MalformedURLException e) {

            System.out.println(
                    "La dirección URL no es válida."
            );
        }
    }
}