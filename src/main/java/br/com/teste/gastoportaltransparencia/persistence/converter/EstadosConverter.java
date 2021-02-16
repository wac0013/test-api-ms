package br.com.teste.gastoportaltransparencia.persistence.converter;

import java.util.Arrays;

import javax.persistence.AttributeConverter;

import br.com.teste.gastoportaltransparencia.domain.enums.Estados;

public class EstadosConverter implements AttributeConverter<Estados, String> {

    @Override
    public String convertToDatabaseColumn(Estados e) {
        return e.getUf(); 
    }

    @Override
    public Estados convertToEntityAttribute(String s) {
    	return Arrays.asList(Estados.values()).stream()
            .filter(estado -> estado.getUf().equalsIgnoreCase(s))
            .findFirst()
            .orElse(null) ;
    }

}
