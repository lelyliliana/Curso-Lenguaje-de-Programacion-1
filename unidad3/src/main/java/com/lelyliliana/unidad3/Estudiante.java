package com.lelyliliana.unidad3;

public class Estudiante {

    private String nombre;
    private double nota;
    private String programa;

    public Estudiante(String nombre, double nota, String programa) {
        this.nombre = nombre;
        this.nota = nota;
        this.programa = programa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public String getPrograma() {
        return programa;
    }

    @Override
    public String toString() {
        return nombre
                + " | Nota: " + nota
                + " | Programa: " + programa;
    }
}