package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {

    @Test
    void testAddNotaAlumno() {
        Nota nota1 = new Nota(5, "matematica");
        Nota nota2 = new Nota(7, "lengua");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);

        Alumno alumno1 = new Alumno("Juan", notas);
        alumno1.addNota(new Nota(4, "ingles"));

        assertEquals(3, alumno1.getNotas().size());
    }

    @Test
    void testRemoveNotaAlumno() {
        Nota nota1 = new Nota(5, "matematica");
        Nota nota2 = new Nota(7, "lengua");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);

        Alumno alumno1 = new Alumno("Juan", notas);
        alumno1.removeNota(new Nota(5, "matematica"));

        assertEquals(1, alumno1.getNotas().size());
    }

}
