package com.mario21ic.test.utils;

import com.mario21ic.utils.Calculadora;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    @DisplayName("suma de dos numeros")
    void testSumar() {
//        fail("Not yet implemented");
        // arrange
        Calculadora calc = new Calculadora();
        // act
        double suma = calc.sumar(2, 2);
        // assert
        assertEquals(4, suma);
    }

    @Test
    @DisplayName("resta de dos numeros")
    void testRestar() {
        // arrange
        Calculadora calc = new Calculadora();
        // act
        double resta = calc.restar(2, 2);
        // assert
        assertEquals(0, resta);
    }

    @Test
    @DisplayName("multiplicacion de dos numeros")
    void testMultiplicar() {
        // arrange
        Calculadora calc = new Calculadora();
        // act
        double multiplica = calc.multiplicar(2, 3);
        // assert
        assertEquals(6, multiplica);
    }

    @Test
    @DisplayName("division de dos numeros")
    void testDividir() {
        // arrange
        Calculadora calc = new Calculadora();
        // act
        double division = calc.dividir(4, 2);
        // assert
        assertEquals(2, division);

        // Other asserts
        assertNull(null);
        assertNotNull(division);
//        assertArrayEquals([1,2,3], [1,2,3]);
        assertSame(Calculadora.class, calc.getClass());
//        assertThrows();
    }
}
