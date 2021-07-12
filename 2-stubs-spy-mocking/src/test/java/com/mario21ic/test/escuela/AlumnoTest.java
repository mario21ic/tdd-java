package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;


public class AlumnoTest {

    List<Nota> notas;

    @BeforeEach
    public void setUp() {
        Nota nota1 = new Nota(5, "matematica");
        Nota nota2 = new Nota(7, "lengua");
        Nota nota3 = new Nota(10, "fisica");
        // Suspensos
        Nota nota4 = new Nota(4, "lengua");
        Nota nota5 = new Nota(3, "ingles");

        Nota nota6 = new Nota(1, "fisica");
        Nota nota7 = new Nota(0, "informatica");

        this.notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);
        notas.add(nota4);
        notas.add(nota5);
        notas.add(nota6);
        notas.add(nota7);
    }

    @Test
    void testAddNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", this.notas);
        alumno1.addNota(new Nota(4, "ingles"));

        assertThat(alumno1.getNotas(), hasItem(
                new Nota(4, "ingles")));
    }

    @Test
    void testRemoveNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", notas);
        alumno1.removeNota(new Nota(5, "matematica"));

        assertThat(alumno1.getNotas(), not(hasItem(
                new Nota(5, "matematica"))));
    }

    @Test
    void testMejorNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(alumno1.getMejorNota(), equalTo(
                new Nota(10, "fisica")));
    }

    @Test
    void testPeorNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", notas);

        assertThat(alumno1.getPeorNota(), equalTo(
                new Nota(0, "informatica")));
    }

    @Test
    void testIgualdadEntreAlumnos() {
        Alumno alumno1 = new Alumno("Juan");
        Alumno alumno2 = new Alumno("Juan");

        assertThat(alumno1, equalTo(alumno2));
    }

    @AfterEach
    void tearDown() {
        // cerrar recursos al terminar un test
        notas=null;
    }
}
