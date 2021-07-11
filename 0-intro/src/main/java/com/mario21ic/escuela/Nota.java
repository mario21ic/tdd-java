package com.mario21ic.escuela;

import java.util.Objects;

public class Nota {
    private double valor;
    private String asignatura;

    public Nota() {
    }

    public Nota(double valor, String asignatura) {
        this.valor = valor;
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean esMismaAsignatura(Nota otra) {
        if (this.getAsignatura().equals(otra.getAsignatura())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Double.compare(nota.valor, valor) == 0 && Objects.equals(asignatura, nota.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, asignatura);
    }

    public boolean esMayor(Nota otra) {
        if (this.esMismaAsignatura(otra)) {
            if (this.getValor() > otra.getValor()) {
                return true;
            }
            return false;
        }
        throw new RuntimeException("Las notas no son comparables por no coincidir asignatura");
    }

}
