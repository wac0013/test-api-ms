package br.com.teste.gastoportaltransparencia.domain.dto;

import lombok.Data;

@Data
public class MunicipioResponseApi {
	private String codigoIBGE;
	private String nomeIBGE;
	private String pais;
	private UfResponseApi uf;
}
