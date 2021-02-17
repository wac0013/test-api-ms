package br.com.teste.gastoportaltransparencia.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.teste.gastoportaltransparencia.domain.dto.MunicipioResponseApi;
import br.com.teste.gastoportaltransparencia.domain.enums.Estados;
import br.com.teste.gastoportaltransparencia.domain.enums.Meses;
import br.com.teste.gastoportaltransparencia.persistence.entity.GastoPeriodo;
import br.com.teste.gastoportaltransparencia.persistence.entity.Municipio;
import br.com.teste.gastoportaltransparencia.persistence.repository.GastoPeriodoRespository;
import br.com.teste.gastoportaltransparencia.persistence.repository.MunicipioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GastoPorMunicipioService {
	
	private final MunicipioRepository municipioRepo;
	private final GastoPeriodoRespository gastoPeriodoRepo;
	
	@Transactional
	public List<GastoPeriodo> salvarRespostaApi(Map<MunicipioResponseApi, BigDecimal> respostaApi, String mesInicio, String mesFim) {
		final List<Municipio> muncipios = new ArrayList<>();
		final List<GastoPeriodo> gastosPorPeriod = new ArrayList<>();
		
		respostaApi.forEach((key, value) -> muncipios.add(Municipio.builder()
					.codigoIBGE(Integer.valueOf(key.getCodigoIBGE()))
					.nomeIBGE(key.getNomeIBGE())
					.estado(Estados.valueOfUf(key.getUf().getSigla()))
					.pais(key.getPais())
					.build()
				));

		municipioRepo.saveAll(muncipios);
		
		respostaApi.forEach((key, value) -> gastosPorPeriod.add(GastoPeriodo.builder()
				.mesInicio(Meses.valueOfNumerMes(mesInicio.split("/")[0]))
				.anoInicio(Short.valueOf(mesInicio.split("/")[1]))
				.mesFim(Meses.valueOfNumerMes(mesFim.split("/")[0]))
				.anoFim(Short.valueOf(mesFim.split("/")[1]))
				.totalGasto(value)
				.municipio(muncipios.stream().filter(m -> m.getCodigoIBGE().equals(Integer.valueOf(key.getCodigoIBGE()))).findFirst().orElse(null))
				.build()
			));
		
		return gastoPeriodoRepo.saveAll(gastosPorPeriod);		
	}

}
