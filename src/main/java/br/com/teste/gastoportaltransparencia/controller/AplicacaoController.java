package br.com.teste.gastoportaltransparencia.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.teste.gastoportaltransparencia.controller.request.DataRequest;
import br.com.teste.gastoportaltransparencia.domain.GerarArquivoCSVService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AplicacaoController {

	private final GerarArquivoCSVService gastoCartaoService;
	
    @GetMapping("/")
    public String getIndex(@ModelAttribute("dataRequest") DataRequest dataRequest) {
        return "index";
    }

    @PostMapping("/gastos-cartoes")
    public String getData(@Validated @ModelAttribute("dataRequest") DataRequest dataRequest,  HttpServletResponse response) throws Exception {
    	gastoCartaoService.getArquivoCSVRetorno(dataRequest.getMesInicio(), dataRequest.getMesFim());
    	return "index";
    }
}
