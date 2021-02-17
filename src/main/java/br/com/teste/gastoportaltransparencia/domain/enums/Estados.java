package br.com.teste.gastoportaltransparencia.domain.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Estados {
    ACRE("Acre", "AC"),
    ALAGOAS("Alagoas", "AL"),
    AMAPA("Amapá", "AP"),
    AMAZONAS("Amazonas", "AM"),
    BAHIA("Bahia", "BA"),
    CEARA("Ceará", "CE"),
    DISTRITOFEDERAL("Distrito Federal", "DF"),
    ESPIRITOSANTO("Espírito Santo", "ES"),
    GOIAS("Goiás", "GO"),
    MARANHAO("Maranhão", "MA"),
    MATOGROSSO("Mato Grosso", "MT"),
    MATOGROSSODOSUL("Mato Grosso do Sul", "MS"),
    MINASGERAIS("Minas Gerais", "MG"),
    PARA("Pará", "PA"),
    PARAIBA("Paraíba", "PB"),
    PARANA("Paraná", "PR"),
    PERNAMBUCO("Pernambuco", "PE"),
    PIAUI("Piauí", "PI"),
    RIODEJANEIRO("Rio de Janeiro", "RJ"),
    RIOGRANDEDONORTE("Rio Grande do Norte", "RN"),
    RIOGRANDEDOSUL("Rio Grande do Sul", "RS"),
    RONDONIA("Rondônia", "RO"),
    RORAIMA("Roraima", "RR"),
    SANTACATARINA("Santa Catarina", "SC"),
    SAOPAULO("São Paulo", "SP"),
    SERGIPE("Sergipe", "SE"),
    TOCANTINS("Tocantins", "TO");

    @Getter
    private String nome;
    @Getter
    private String uf;
    
    public static Estados valueOfUf(String uf) {
    	return Arrays.asList(Estados.values()).parallelStream().filter(estado -> estado.uf.equals(uf)).findAny().orElse(null);
    }
}
