package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Clase;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        // tengo un test double es decir un objeto duplicado que va a ser
        // un STUB, que implemento solo una parte de su funcionalidad
        Alumno alumno1 = Mockito.mock(Alumno.class);
        Mockito.when(alumno1.getNotaMedia()).thenReturn(6.2);

        Alumno alumno2 = Mockito.mock(Alumno.class);
        Mockito.when(alumno2.getNotaMedia()).thenReturn(7.1);

        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        // nota media 5
        Clase c = new Clase("1A", alumnos);

        assertThat(6.6, closeTo(c.getMedia(), 0.2));
    }

    @Test
    void testMejorNota() {
        // tengo un test double es decir un objeto duplicado que va a ser
        // un STUB, que implemento solo una parte de su funcionalidad
        Alumno alumno1 = Mockito.mock(Alumno.class);
        Mockito.when(alumno1.getMejorNota()).
                thenReturn(new Nota(8, "Lengua"));

        Alumno alumno2 = Mockito.mock(Alumno.class);
        Mockito.when(alumno2.getMejorNota()).
                thenReturn(new Nota(10, "matematica"));

        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);

        Clase c = new Clase("1A", alumnos);

        // Que el estado de las clases sea el correcto
        // no implica que el resultado sea el optimo
        assertThat(c.getMejorNota(), equalTo(
                new Nota(10, "matematica")));

        // Spy y Stub
        // Verifica que cada vez que incovo a clase.getMejorNota()
        // se han invocado los metodos getMejorNota de cada alumno
        // es para ver si la relacion esta correctamente construida UNA SOLA VEZ
        Mockito.verify(alumno1, Mockito.times(1)).getMejorNota();
        Mockito.verify(alumno2, Mockito.times(1)).getMejorNota();
    }

}
