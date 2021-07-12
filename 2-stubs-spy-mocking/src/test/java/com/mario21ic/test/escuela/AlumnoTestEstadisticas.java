package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AlumnoTestEstadisticas {

//    List<Nota> notas;

    @BeforeEach
    public void setUp() {
//        Nota nota1 = new Nota(5, "matematica");
//        Nota nota2 = new Nota(7, "lengua");
//        Nota nota3 = new Nota(10, "fisica");
//        // Suspensos
//        Nota nota4 = new Nota(4, "lengua");
//        Nota nota5 = new Nota(3, "ingles");
//
//        Nota nota6 = new Nota(1, "fisica");
//
//        this.notas = new ArrayList<Nota>();
//        notas.add(nota1);
//        notas.add(nota2);
//        notas.add(nota3);
//        notas.add(nota4);
//        notas.add(nota5);
//        notas.add(nota6);
    }

    @Test
    void testNumeroDeSobresalientes() {
        Nota nota1 = new Nota(5, "matematica");
        Nota nota2 = new Nota(7, "lengua");
        Nota nota3 = new Nota(10, "fisica");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);

        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(1, equalTo(alumno1.getSobresalientes()));
    }

    @Test
    void testNumeroDeSuspensos() {
        Nota nota1 = new Nota(2, "matematica");
        Nota nota2 = new Nota(6, "lengua");
        Nota nota3 = new Nota(1, "fisica");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);

        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(2, equalTo(alumno1.getSuspensos()));
    }

    @Test
    void testNumeroMuyDeficientes() {
        Nota nota1 = new Nota(4, "matematica");
        Nota nota2 = new Nota(6, "lengua");
        Nota nota3 = new Nota(1, "fisica");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);

        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(1, equalTo(alumno1.getMuyDeficientes()));
    }

    @Test
    void testNotaMediaAlumno() {
        Nota nota1 = new Nota(2, "matematica");
        Nota nota2 = new Nota(5, "lengua");
        Nota nota3 = new Nota(7, "fisica");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);

        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(4.66, closeTo(alumno1.getNotaMedia(), 0.2));
    }

    @AfterEach
    void tearDown() {
        // cerrar recursos al terminar un test
//        notas=null;
    }
}
