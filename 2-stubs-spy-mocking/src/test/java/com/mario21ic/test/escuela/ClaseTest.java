package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Clase;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;


public class ClaseTest {

    @Test
    void testAddAlumnoALaClase() {
        Alumno alumno1 = new Alumno("Juan");
        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);

        Clase clase = new Clase("1A", alumnos);
        clase.addAlumno(new Alumno("Ana"));


        assertThat(clase.getAlumnos(), hasItem(new Alumno("Ana")));
    }

    @Test
    void testRemoveAlumnoALaClase() {
        Alumno alumno1 = new Alumno("Juan");
        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);

        Clase clase = new Clase("1A", alumnos);
        clase.removeAlumno(new Alumno("Juan"));


        assertThat(clase.getAlumnos(), not (hasItem(new Alumno("Juan"))));
    }

    @Test
    void testNotaMediaClase() {
        // nota media 4
        Nota nota1 = new Nota(3, "matematica");
        Nota nota2 = new Nota(5, "lengua");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
        Alumno alumno1 = new Alumno("Juan", notas);

        // nota media 5
        Nota nota3 = new Nota(5, "matematica");
        Nota nota4 = new Nota(5, "lengua");
        List<Nota> notas2 = new ArrayList<Nota>();
        notas2.add(nota3);
        notas2.add(nota4);
        Alumno alumno2 = new Alumno("Ana", notas2);

        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        // nota media 5
        Clase c = new Clase("1A", alumnos);

        assertThat(4.5, closeTo(c.getMedia(), 0.2));
    }

}
