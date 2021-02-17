package br.com.teste.gastoportaltransparencia.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.teste.gastoportaltransparencia.domain.enums.Meses;
import br.com.teste.gastoportaltransparencia.persistence.converter.MesesConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "gastos_periodo")
public class GastoPeriodo implements Serializable {
	
	private static final long serialVersionUID = -48415271488788381L;

	@Builder
    public GastoPeriodo(Meses mesInicio, Short anoInicio, Meses mesFim, Short anoFim, BigDecimal totalGasto,
			Municipio municipio) {
		super();
		this.mesInicio = mesInicio;
		this.anoInicio = anoInicio;
		this.mesFim = mesFim;
		this.anoFim = anoFim;
		this.totalGasto = totalGasto;
		this.municipio = municipio;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Convert(converter = MesesConverter.class)
    @Getter
    @Setter
    private Meses mesInicio;

    @Column
    @Getter
    @Setter
    private Short anoInicio;
    
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Meses mesFim;

    @Column
    @Getter
    @Setter
    private Short anoFim;
    
    @Column(scale = 4)
    @Getter
    @Setter
    private BigDecimal totalGasto;
    
    @ManyToOne
    @JoinColumn(name = "codigoIBGE")
    @Getter
    @Setter
    private Municipio municipio;
}
