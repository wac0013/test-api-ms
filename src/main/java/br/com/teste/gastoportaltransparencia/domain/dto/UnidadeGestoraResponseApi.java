package br.com.teste.gastoportaltransparencia.domain.dto;

import lombok.Data;

@Data
public class UnidadeGestoraResponseApi {
	private String codigo;
	private String nome;
	private OrgaoResponseApi orgaoVinculado;
}
