package com.mario21ic.escuela;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String nombre;
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }

    public double getMedia() {
        double total = 0;
        for (Alumno alumno : alumnos) {
            total += alumno.getNotaMedia();
        }

        return total/alumnos.size();
    }

    public Clase() {
    }

    public Clase(String nombre, List<Alumno> alumnos) {
        this.nombre = nombre;
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
