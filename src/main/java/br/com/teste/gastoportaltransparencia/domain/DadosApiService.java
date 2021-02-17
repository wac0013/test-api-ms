package br.com.teste.gastoportaltransparencia.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.teste.gastoportaltransparencia.domain.dto.MunicipioResponseApi;
import br.com.teste.gastoportaltransparencia.domain.dto.TransacaoResponseApi;
import br.com.teste.gastoportaltransparencia.persistence.entity.GastoPeriodo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DadosApiService {
	
	@Value("${api.url}")
	private String urlApi;
	
	@Value("${api.chave}")
	private String chaveApi;
	
	private final GastoPorMunicipioService gastoPorMunicipioService;
	
	private TransacaoResponseApi[] consultaApiGastosPorCartoesDePagamento(String mesInicio, String mesFim) throws Exception {
		var restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("chave-api-dados", chaveApi);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(urlApi)
		        .queryParam("mesExtratoInicio", mesInicio)
		        .queryParam("mesExtratoFim", mesFim);
		
		ResponseEntity<TransacaoResponseApi[]> response = restTemplate.exchange(urlBuilder.toUriString(), HttpMethod.GET, entity, TransacaoResponseApi[].class);
		
		switch (response.getStatusCode()) {
		case OK:
			return response.getBody();
		case UNAUTHORIZED:
			throw new Exception("Não autorizado! Verifique a chave da api fornecida");
		default:
			throw new Exception("Não foi possível obter resposta da API");
		}
	}
	
	private Map<MunicipioResponseApi, BigDecimal> getTotalGastoPorMunicipio(String mesInicio, String mesFim) throws Exception {
		var respostaApi = consultaApiGastosPorCartoesDePagamento(mesInicio, mesFim);
		final Map<MunicipioResponseApi, BigDecimal> mapGastosMunicipio = new HashMap<>();
		
		Arrays.stream(respostaApi)
			.forEach(transacao -> {
				var municipio = transacao.getEstabelecimento().getMunicipio();
				var valorTransacao = new BigDecimal(transacao.getValorTransacao().replace(".", "").replace(",", "."));
				
				if (Integer.parseInt(municipio.getCodigoIBGE()) < 0) return;
				
				mapGastosMunicipio.put(municipio, 
						mapGastosMunicipio.getOrDefault(municipio, BigDecimal.ZERO).add(valorTransacao));
			});
		
		return mapGastosMunicipio;
	}
	
	public List<GastoPeriodo> gastosPorPeriodo(String mesInicio, String mesFim) throws Exception {
		var map = getTotalGastoPorMunicipio(mesInicio, mesFim);
		
		return gastoPorMunicipioService.salvarRespostaApi(map, mesInicio, mesFim);
	}

}
