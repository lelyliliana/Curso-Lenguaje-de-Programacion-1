package com.lelyliliana.unidad3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class U3_12_IntegradorFuncional {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = List.of(
                new Estudiante("Ana", 4.5, "Ingeniería de Sistemas"),
                new Estudiante("Carlos", 3.2, "Ingeniería Industrial"),
                new Estudiante("María", 4.8, "Ingeniería de Sistemas"),
                new Estudiante("Juan", 2.9, "Ingeniería de Sistemas"),
                new Estudiante("Laura", 3.9, "Ingeniería Industrial")
        );

        Predicate<Estudiante> estaAprobado =
                estudiante -> estudiante.getNota() >= 3.0;

        Predicate<Estudiante> perteneceASistemas =
                estudiante -> estudiante.getPrograma()
                        .equals("Ingeniería de Sistemas");

        Function<Estudiante, String> obtenerNombre =
                Estudiante::getNombre;

        System.out.println("EJERCICIO INTEGRADOR");
        System.out.println("--------------------");

        System.out.println("Estudiantes aprobados de Ingeniería de Sistemas:");

        estudiantes.stream()
                .filter(estaAprobado.and(perteneceASistemas))
                .sorted(Comparator.comparingDouble(
                        Estudiante::getNota).reversed())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Nombres en mayúsculas:");

        estudiantes.stream()
                .filter(estaAprobado.and(perteneceASistemas))
                .map(obtenerNombre)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        long cantidadAprobados = estudiantes.stream()
                .filter(estaAprobado)
                .count();

        double sumaNotas = estudiantes.stream()
                .filter(estaAprobado)
                .map(Estudiante::getNota)
                .reduce(0.0, Double::sum);

        double promedio = cantidadAprobados > 0
                ? sumaNotas / cantidadAprobados
                : 0.0;

        System.out.println();
        System.out.println("Cantidad de estudiantes aprobados: "
                + cantidadAprobados);

        System.out.printf(
                "Promedio de notas de los estudiantes aprobados: %.2f%n",
                promedio
        );
    }
}