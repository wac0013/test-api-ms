package br.com.teste.gastoportaltransparencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicacaoController {

    @GetMapping("/index")
    public String getIndex() {
        return "home";
    }
}
