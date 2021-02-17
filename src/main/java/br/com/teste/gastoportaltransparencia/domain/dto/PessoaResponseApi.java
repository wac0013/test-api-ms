package br.com.teste.gastoportaltransparencia.domain.dto;

import lombok.Data;

@Data
public class PessoaResponseApi {
	private CnaeResponseApi cnae;
	private String codigoFormatado;
	private String complementoEndereco;
	private String dataAbertura;
	private String descricaoLogradouro;
	private String enderecoEletronico;
	private String localidadePessoa;
	private MunicipioResponseApi municipio;
	private NaturezaJuridicaResponseApi naturezaJuridica;
	private String nome;
	private String nomeBairro;
	private String nomeFantasiaReceita;
	private String numeroCEP;
	private String numeroEndereco;
	private String numeroInscricaoSocial;
	private String numeroTelefone;
	private String razaoSocialReceita;
	private String tipoCodigo;
	private String tipoPessoa;
}
