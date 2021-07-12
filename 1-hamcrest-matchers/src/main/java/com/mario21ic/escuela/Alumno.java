package com.mario21ic.escuela;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private List<Nota> notas = new ArrayList<Nota>();

    public Alumno() {
    }

    public Alumno(String nombre, List<Nota> notas) {
        this.nombre = nombre;
        this.notas = notas;
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
}
