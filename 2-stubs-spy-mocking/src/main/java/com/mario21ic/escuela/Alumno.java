package com.mario21ic.escuela;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private String nombre;
    private List<Nota> notas = new ArrayList<Nota>();

    public Alumno() {
    }

    public Alumno(String nombre, List<Nota> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void addNota(Nota nota) {
        this.notas.add(nota);
    }

    public void removeNota(Nota nota) {
        this.notas.remove(nota);
    }

    public int getSobresalientes() {
        int sobresalientes = 0;
        for (Nota notas : this.getNotas()) {
            if (notas.getValor() >= 9 ) {
                sobresalientes++;
            }
        }
        return sobresalientes;
    }

    public int getSuspensos() {
        int suspensos = 0;
        for (Nota nota : this.getNotas()) {
            if (nota.getValor() < 5) {
                suspensos++;
            }
        }
        return suspensos;
    }

    public int getMuyDeficientes() {
        int deficientes = 0;
        for (Nota nota : this.getNotas()) {
            if (nota.getValor() < 3) {
                deficientes++;
            }
        }
        return deficientes;
    }

    public Nota getMejorNota() {
        double mejor = 0;
        Nota mejorNota = null;
        for (Nota nota:notas) {
            if (nota.getValor() >= mejor) {
                mejor = nota.getValor();
                mejorNota = nota;
            }
        }
        return mejorNota;
    }

    public Nota getPeorNota() {
        double peor = 0;
        Nota peorNota = null;
        for (Nota nota : notas) {
            if (nota.getValor() <= peor) {
                peor = nota.getValor();
                peorNota = nota;
            }
        }
        return peorNota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public double getNotaMedia() {
        // que un grupo de pruebas unitarias falle,
        // es casi peor que no tener unit tests
        // tipos de doubles:
        // dummy -> objeto vacios
        // stubs -> sustituye metodos concretos
        // spy -> graba invocaciones
        // mocks -> sustituye metodos y graba invocaciones
        // fake -> simula
        double total = 1;
//        double total = 0;
        for (Nota nota : notas) {
            total += nota.getValor();
        }

        return total/notas.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
