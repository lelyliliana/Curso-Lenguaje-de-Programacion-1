package com.lelyliliana.unidad4;

import java.util.Comparator;
import java.util.List;

public class U4_11_StreamObjetos {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = List.of(
                new Estudiante("Ana", 4.5, "Ingeniería de Sistemas"),
                new Estudiante("Carlos", 3.2, "Ingeniería Industrial"),
                new Estudiante("María", 4.8, "Ingeniería de Sistemas"),
                new Estudiante("Juan", 2.9, "Ingeniería de Sistemas"),
                new Estudiante("Laura", 3.9, "Ingeniería Industrial")
        );

        System.out.println("STREAM CON OBJETOS");
        System.out.println("------------------");

        System.out.println("Lista completa:");

        estudiantes.forEach(System.out::println);

        System.out.println();
        System.out.println("Estudiantes aprobados:");

        estudiantes.stream()
                .filter(estudiante -> estudiante.getNota() >= 3.0)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Estudiantes de Ingeniería de Sistemas:");

        estudiantes.stream()
                .filter(estudiante ->
                        estudiante.getPrograma()
                                .equals("Ingeniería de Sistemas"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Estudiantes ordenados por nota:");

        estudiantes.stream()
                .sorted(Comparator.comparingDouble(
                        Estudiante::getNota).reversed())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Nombres de los estudiantes aprobados:");

        estudiantes.stream()
                .filter(estudiante -> estudiante.getNota() >= 3.0)
                .map(Estudiante::getNombre)
                .forEach(System.out::println);
    }
}