package br.com.teste.gastoportaltransparencia.domain.dto;

import lombok.Data;

@Data
public class TransacaoResponseApi {
	private String dataTransacao;
	private PessoaResponseApi estabelecimento;
	private Integer id;
	private String mesExtrato;
	private PortadorResponseApi portador;
	private IdCodigoDescricaoResponseApi tipoCartao;
	private UnidadeGestoraResponseApi unidadeGestora;
	private String valorTransacao;
}
