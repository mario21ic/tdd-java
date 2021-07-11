package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Nota;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
//    @DisplayName("misma asignatura")
    void testMismaAsignaturaNota() {
        // arrange
        Nota nota1 = new Nota(8, "lengua");
        Nota nota2 = new Nota(7, "lengua");
        Nota nota3 = new Nota(8, "matematica");

        // act
        boolean esMisma = nota1.esMismaAsignatura(nota2);
        boolean esDistinta = nota1.esMismaAsignatura(nota3);

        // assert
        assertTrue(esMisma);
        assertFalse(esDistinta);
    }

    @Test
    void testIgualdadNotas() {
        // arrange
        Nota nota1 = new Nota(8, "lengua");
        Nota nota2 = new Nota(8, "lengua");
        Nota nota3 = new Nota(8, "matematica");

        // act
        boolean iguales = nota1.equals(nota2);
        boolean noIguales = nota1.equals(nota3);

        // assert
        assertTrue(iguales);
        assertFalse(noIguales);
    }

    @Test
    void testNotaEsMayorQueOtra() {
        // arrange
        Nota nota1 = new Nota(8, "lengua");
        Nota nota2 = new Nota(5, "lengua");

        // act & assert
        assertTrue(nota1.esMayor(nota2));
    }

    @Test
    void testNotaNoEsComparableConOtra() {
        // arrange
        Nota nota1 = new Nota(8, "lengua");
        Nota nota2 = new Nota(5, "matematica");

        // act & assert an exception
        assertThrows(RuntimeException.class, ()-> nota1.esMayor(nota2));
    }


}
