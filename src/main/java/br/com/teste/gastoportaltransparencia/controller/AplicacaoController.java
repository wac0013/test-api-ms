package br.com.teste.gastoportaltransparencia.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.teste.gastoportaltransparencia.controller.request.DataRequest;
import br.com.teste.gastoportaltransparencia.domain.GerarArquivoCSVService;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

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
        InputStreamResource file =
                new InputStreamResource(gastoCartaoService.getArquivoCSVRetorno(dataRequest.getMesInicio(), dataRequest.getMesFim()));

    	response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=retorno_gastos.csv");

        InputStream is = file.getInputStream();

        try {
            int c;
            while ((c = is.read()) != -1) {
                response.getWriter().write(c);
            }

            is.close();
            response.getWriter().close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    	return "index";
    }
}
