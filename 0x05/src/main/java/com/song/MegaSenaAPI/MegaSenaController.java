package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo ao Mega Sena API!!";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        return Arrays.asList(4, 12, 15, 21, 43 , 55);
    }
}
