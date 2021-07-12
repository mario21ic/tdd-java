package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTestFixture {

    Nota nota1;
    Nota nota2;
    List<Nota> notas;

    @BeforeEach
    public void setUp() {
        this.nota1 = new Nota(5, "matematica");
        this.nota2 = new Nota(7, "lengua");
        this.notas = new ArrayList<Nota>();
        notas.add(nota1);
        notas.add(nota2);
    }

    @Test
    void testAddNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", this.notas);
        alumno1.addNota(new Nota(4, "ingles"));

        assertEquals(3, alumno1.getNotas().size());
    }

    @Test
    void testRemoveNotaAlumno() {
        Alumno alumno1 = new Alumno("Juan", notas);
        alumno1.removeNota(new Nota(5, "matematica"));

        assertEquals(1, alumno1.getNotas().size());
    }

    @Test
    void testNumeroDeSobresalientes() {
        // agregar nueva nota para no manipular los compartidos anteriores
        Nota notaNueva = new Nota(10, "ingles");
        List<Nota> notas = new ArrayList<Nota>();
        notas.add(notaNueva);

        Alumno alumno1 = new Alumno("Juan", notas);

        assertEquals(1, alumno1.getSobresalientes());
    }

}
