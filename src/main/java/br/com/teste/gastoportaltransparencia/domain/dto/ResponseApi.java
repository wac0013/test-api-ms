package br.com.teste.gastoportaltransparencia.domain.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseApi {
	private List<TransacaoResponseApi> transacoes;
}
