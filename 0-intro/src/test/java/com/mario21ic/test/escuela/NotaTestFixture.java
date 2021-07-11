package com.mario21ic.test.escuela;

import com.mario21ic.escuela.Nota;
import com.mario21ic.escuela.Nota.Tipo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTestFixture {

    Nota nota1=null;
    Nota nota2=null;
    Nota nota3=null;
    Nota nota4=null;
    Nota nota5=null;
    Nota nota6=null;
    Nota nota7=null;

    @BeforeEach
    public void setUp() {
        // arrange
        // compartir un testfixture entre varias unit tests
        nota1 = new Nota(8, "lengua");
        nota2 = new Nota(7, "lengua");
        nota3 = new Nota(9, "matematica");
        nota4 = new Nota(8, "lengua");
        nota5 = new Nota(10, "lengua");
        nota6 = new Nota(6, "lengua");
        nota7 = new Nota(5.2, "lengua");
    }

    @Test
//    @DisplayName("misma asignatura")
    void testMismaAsignaturaNota() {
        // arrange from setUp

        // act
        boolean esMisma = nota1.esMismaAsignatura(nota2);
        boolean esDistinta = nota1.esMismaAsignatura(nota3);

        // assert
        assertTrue(esMisma);
        assertFalse(esDistinta);
    }

    @Test
    void testIgualdadNotas() {
        // arrange from setUp

        // act
        boolean iguales = nota1.equals(nota4);
        boolean noIguales = nota1.equals(nota3);

        // assert
        assertTrue(iguales);
        assertFalse(noIguales);
    }

    @Test
    void testNotaEsMayorQueOtra() {
        // arrange from SetUp

        // act & assert
        assertTrue(nota1.esMayor(nota2));
    }

    @Test
    void testNotaNoEsComparableConOtra() {
        // arrange  from SetUp

        // act & assert an exception
        assertThrows(RuntimeException.class, ()-> nota1.esMayor(nota3));
    }

    @Test
    void testNotaTipoBien() {
        // arrange  from SetUp
        // act
        Tipo miTipoNota = nota7.getTipo();
        // assert
        assertEquals(Tipo.BIEN, miTipoNota);
    }

    @Test
    void testNotaTipoNotable() {
        // arrange  from SetUp
        // act
        Tipo miTipoNota = nota4.getTipo();
        // assert
        assertEquals(Tipo.NOTABLE, miTipoNota);
    }

    @Test
    void testNotaTipoSobresaliente() {
        // arrange  from SetUp
        // act
        Tipo miTipoNota = nota5.getTipo();
        // assert
        assertEquals(Tipo.SOBRESALIENTE, miTipoNota);
    }

}
