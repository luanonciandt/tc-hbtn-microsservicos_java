package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Calculator calculator;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        Mockito.when(this.calculator.sum(2.0, 2.5)).thenReturn(4.5);
        RequestBuilder request = get("/calculator/addNumbers?number1=2.0&number2=2.5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("4.5",  result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        Mockito.when(this.calculator.sub(5.3, 1.1)).thenReturn(4.2);
        RequestBuilder request = get("/calculator/subNumbers?number1=5.3&number2=1.1");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("4.2",  result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        Mockito.when(this.calculator.divide(10.0, 0.5)).thenReturn(20.0);
        RequestBuilder request = get("/calculator/divideNumbers?number1=10.0&number2=0.5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("20.0",  result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        Mockito.when(this.calculator.factorial(5)).thenReturn(120);
        RequestBuilder request = get("/calculator/factorial?factorial=5");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("120",  result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        Mockito.when(this.calculator.calculeDayBetweenDate(LocalDate.parse("2020-3-15"), LocalDate.parse("2020-3-29"))).thenReturn(14);
        RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2020-3-15&localDate2=2020-3-29");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("14",  result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        Mockito.when(this.calculator.integerToBinary(10)).thenReturn(1010);
        RequestBuilder request = get("/calculator/integerToBinary?number1=10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("1010",  result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        Mockito.when(this.calculator.integerToHexadecimal(12)).thenReturn("c");
        RequestBuilder request = get("/calculator/integerToHexadecimal?number1=12");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("c",  result.getResponse().getContentAsString());
    }

}