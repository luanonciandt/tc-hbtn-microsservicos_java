package com.example.calculator.model;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class Calculator {

    public Double sum(Double number1, Double number2) {
        checkIfNumbersNotNull(number1, number2);
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        checkIfNumbersNotNull(number1, number2);
        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        checkIfNumbersNotNull(number1, number2);
        checkIfDivByZero(number2);
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        checkIfNumberNotNull(factorial);
        int fat = 1;
        for (int i = 2; i <= factorial; i++) {
            fat *= i;
        }
        return fat;
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        return Math.abs(period.getDays());
    }

    public static void checkIfNumbersNotNull(Double n1, Double n2) {
        if (n1 == null || n2 == null) throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public static void checkIfNumberNotNull(Integer n1) {
        if (n1 == null) throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public static void checkIfDivByZero(Double divisor) {
        if (divisor == 0) throw new ArithmeticException("Divisão por zero não é permitido.");
    }
}
