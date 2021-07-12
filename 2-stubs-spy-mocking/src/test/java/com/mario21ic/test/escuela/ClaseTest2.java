package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Alumno;
import com.mario21ic.escuela.Clase;
import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(MockitoExtension.class)
public class ClaseTest2 {

    // Los objetos Mock por inyeccion de dependencias
    // utilizando anotaciones y configurara los mocks
    @Mock
    Alumno alumno1, alumno2;

    @Test
    void testNotaMediaClase() {
        Mockito.when(alumno1.getNotaMedia()).thenReturn(6.2);
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
        Mockito.when(alumno1.getMejorNota()).
                thenReturn(new Nota(8, "Lengua"));

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
