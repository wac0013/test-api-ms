package br.com.teste.gastoportaltransparencia.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DataRequest {
    @NotNull(message = "Campo obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM")
    private String mesInicio;

    @NotBlank(message = "Campo obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM")
    private String mesFim;
}
