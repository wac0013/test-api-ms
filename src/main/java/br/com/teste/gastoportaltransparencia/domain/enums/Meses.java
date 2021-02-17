package br.com.teste.gastoportaltransparencia.domain.enums;

import java.util.Arrays;

public enum Meses {
    JANEIRO, FEVEREIRO, MARCO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO;
    
    public static Meses valueOfNumerMes(String numeroMes) {
    	try {
    		var poisiton = Integer.valueOf(numeroMes);
        	return Meses.values()[poisiton - 1];
		} catch (Exception e) {
			return null;
		}
    	
    }
    
    public String getNumMes() {
    	return String.format("%02d", Arrays.asList(Meses.values()).indexOf(this) + 1);
    }
}
