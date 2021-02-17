package br.com.teste.gastoportaltransparencia.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.stereotype.Service;

import br.com.teste.gastoportaltransparencia.persistence.entity.GastoPeriodo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GerarArquivoCSVService {
	
	private final DadosApiService dadosApiService;

	public ByteArrayInputStream getArquivoCSVRetorno(String mesInicio, String mesFim) throws Exception {
		var dados = dadosApiService.gastosPorPeriodo(ajustarFormatoData(mesInicio), ajustarFormatoData(mesFim));
		return toCSV(dados);
	}
	
	private String ajustarFormatoData(String data) throws IllegalArgumentException {
		var stringSplit = data.split("-");
		if (stringSplit.length != 2) throw new IllegalArgumentException("Data no formato errado!");
		
		return stringSplit[1] + "/" + stringSplit[0];
	}
	
	private ByteArrayInputStream toCSV(List<GastoPeriodo> listaGastos) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try {
	    	ByteArrayOutputStream out = new ByteArrayOutputStream();
    		CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);
			List<String> cabecalho = Arrays.asList("CodigoIBGE", "Nome Municipio", "UF", "Mes inicio", "Mes Fim", "Total Gasto");
			csvPrinter.printRecord(cabecalho);

    		for (GastoPeriodo gasto : listaGastos) {
				List<String> data = Arrays.asList(String.valueOf(gasto.getMunicipio().getCodigoIBGE()),
    					gasto.getMunicipio().getNomeIBGE(),
    					gasto.getMunicipio().getEstado().getUf(),
    					gasto.getMesInicio().getNumMes() + "/" + gasto.getAnoInicio().toString(),
    					gasto.getMesFim().getNumMes() + "/" + gasto.getAnoFim().toString(),
						NumberFormat.getCurrencyInstance().format(gasto.getTotalGasto())
    					);

    			csvPrinter.printRecord(data);
    		}

	      	csvPrinter.flush();
	      	return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	    	throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
}
