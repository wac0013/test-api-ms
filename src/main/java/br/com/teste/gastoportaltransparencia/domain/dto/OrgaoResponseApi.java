package br.com.teste.gastoportaltransparencia.domain.dto;

import lombok.Data;

@Data
public class OrgaoResponseApi {
	private String cnpj;
	private String codigoSIAFI;
	private String descricaoPoder;
	private String nome;
	private OrgaoMaximoResponseApi orgaoMaximo;
	private String sigla;
}
