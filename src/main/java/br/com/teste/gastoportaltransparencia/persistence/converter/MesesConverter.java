package br.com.teste.gastoportaltransparencia.persistence.converter;

import java.util.Arrays;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.teste.gastoportaltransparencia.domain.enums.Meses;


@Converter(autoApply = true)
public class MesesConverter implements AttributeConverter<Meses, String> {

    @Override
    public String convertToDatabaseColumn(Meses e) {
        return String.format("%02d", Arrays.asList(Meses.values()).indexOf(e)); 
    }

    @Override
    public Meses convertToEntityAttribute(String s) {
    	try {
        	return Meses.values()[Integer.parseInt(s) - 1];
		} catch (Exception e) {
	        return null;
		}
    }

}
