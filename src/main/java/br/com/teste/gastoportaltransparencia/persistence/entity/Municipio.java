package br.com.teste.gastoportaltransparencia.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.teste.gastoportaltransparencia.domain.enums.Estados;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "municipios")
public class Municipio implements Serializable{

	private static final long serialVersionUID = -7835059585368113708L;

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
    //@Convert(converter = EstadosConverter.class)
    private Estados estado;

}
