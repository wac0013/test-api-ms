package br.com.teste.gastoportaltransparencia.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.teste.gastoportaltransparencia.domain.enums.Estados;
import br.com.teste.gastoportaltransparencia.persistence.converter.EstadosConverter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "municipios")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
public class Municipio {

    @Id
    @Column
    @Getter
    private Integer codigoIBGE;

    @Getter
    @Setter
    private String nomeIBGE;

    @Getter
    @Builder.Default
    private String pais = "Brasil";

    @Getter
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    @Convert(converter = EstadosConverter.class)
    private Estados uf;

}
