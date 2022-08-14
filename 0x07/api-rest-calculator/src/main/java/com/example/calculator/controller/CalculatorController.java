package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @Autowired
    public Calculator calculator;

    @GetMapping("/welcome")
    public String messageWelcome() {

        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
        return calculator.sum(n1, n2).toString();
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {

        return calculator.sub(n1, n2).toString();
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {

        return calculator.divide(n1, n2).toString();
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {

        return calculator.factorial(factorial).toString();
    }

    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) -> n tava funcionando :(

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(@RequestParam("localDate1")  CharSequence localDate1, @RequestParam("localDate2") CharSequence localDate2) {
        System.out.println(localDate1 + " " + localDate2);
        return Integer.toString(calculator.calculeDayBetweenDate(LocalDate.parse(localDate1), LocalDate.parse(localDate2)));
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {

        return calculator.integerToBinary(n1).toString();
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {

        return calculator.integerToHexadecimal(n1);
    }
}