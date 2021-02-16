package br.com.teste.gastoportaltransparencia.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.teste.gastoportaltransparencia.domain.enums.Meses;
import br.com.teste.gastoportaltransparencia.persistence.converter.MesesConverter;

@Entity
@Table(name = "gastos_mes_ano")
public class GastoMesAno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Convert(converter = MesesConverter.class)
    private Meses mes;

    @Column
    private Short ano;
}
