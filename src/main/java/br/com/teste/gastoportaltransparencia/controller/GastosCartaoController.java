package br.com.teste.gastoportaltransparencia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/api/gastos-cartoes")
public class GastosCartaoController {

    @GetMapping("/")
    public void getGastosPorCartao(@RequestParam String mesInicio, @RequestParam String mesFim) {

    }

}
