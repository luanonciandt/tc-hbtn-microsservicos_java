package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        assertEquals(5.0, calculator.sum(3.0, 2.0));
        assertNotEquals(6.0, calculator.sum(3.0, 3.9));
    }

    @Test
    public void numbersNullSumTest() {

        NullPointerException thrown;

        thrown = assertThrows(NullPointerException.class, () -> calculator.sum(null, 2.0));
        assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());

        thrown = assertThrows(NullPointerException.class, () -> calculator.sum(4.5, null));
        assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());

        thrown = assertThrows(NullPointerException.class, () -> calculator.sum(null, null));
        assertEquals("Número 1 e número 2 são obrigatórios.", thrown.getMessage());
    }

    @Test
    void subTest() {
        assertEquals(3.0, calculator.sub(7.0, 4.0));
        assertNotEquals(0.0, calculator.sub(5.0, 1.1));
    }

    @Test
    void divideTest() {
        assertEquals(5.0, calculator.divide(50.0, 10.0));
        assertNotEquals(12.0, calculator.divide(4.7, 3.6));
    }

    @Test
    public void divisionByZeroTest() {
        ArithmeticException thrown;
        thrown = assertThrows(ArithmeticException.class, () -> calculator.divide(2.0, 0.0));
        assertEquals("Divisão por zero não é permitido.", thrown.getMessage());
    }

    @Test
    void factorialTest() {
        assertEquals(24, calculator.factorial(4));
        assertNotEquals(721, calculator.factorial(6));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(101, calculator.integerToBinary(5));
        assertNotEquals(111, calculator.integerToBinary(3));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("37", calculator.integerToHexadecimal(55));
        assertNotEquals("AAA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(date1, date2));
        date1 = LocalDate.of(2020, 3, 15);
        date2 = LocalDate.of(2020, 3, 24);
        assertNotEquals(7, calculator.calculeDayBetweenDate(date1, date2));
    }

}
