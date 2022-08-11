package com.example.user.controller;

import com.example.user.exception.UserCPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) throws UserIdException {
        String msg = "";
        if (id < 100 && id > 0) {
            msg = "You have entered valid ID";
        } else {
            throw new UserIdException(Integer.toString(id));
        }
        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) throws UserNameException {
        String msg = "";
        if (userName.length() > 3 && userName.length() < 15) {
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException(userName);
        }
        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) throws CPFException {
        String msg = "";
        boolean isCPFValid = isCPF(cpf);
        if (isCPFValid) {
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }
        return msg;
    }

    boolean isCPF(String cpf) {
        return cpf.length() > 3 && cpf.length() < 15;
    }

}
