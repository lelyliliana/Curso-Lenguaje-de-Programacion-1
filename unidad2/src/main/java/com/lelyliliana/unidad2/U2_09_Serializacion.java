package com.lelyliliana.unidad2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class U2_09_Serializacion {

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

        String nombreArchivo = "estudiante.dat";

        Estudiante estudiante =
                new Estudiante(
                        "Ana",
                        "Ingeniería de Sistemas",
                        4.5
                );

        System.out.println("SERIALIZACIÓN DE OBJETOS");
        System.out.println("------------------------");

        try (
                ObjectOutputStream salida =
                        new ObjectOutputStream(
                                new FileOutputStream(
                                        nombreArchivo
                                )
                        )
        ) {

            salida.writeObject(estudiante);

            System.out.println(
                    "Objeto serializado correctamente."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al serializar: "
                            + e.getMessage()
            );
        }

        try (
                ObjectInputStream entrada =
                        new ObjectInputStream(
                                new FileInputStream(
                                        nombreArchivo
                                )
                        )
        ) {

            Estudiante estudianteRecuperado =
                    (Estudiante) entrada.readObject();

            System.out.println(
                    "Objeto recuperado:"
            );

            System.out.println(
                    estudianteRecuperado
            );

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "Error al deserializar: "
                            + e.getMessage()
            );
        }
    }
}