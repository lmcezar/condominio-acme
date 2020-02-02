/**
 * 
 */
package br.com.acme.multas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.acme.condominio.Condominio;
import br.com.acme.unidade.Unidade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MultaDTO {
	
	private Long id;
	
	private String descricaoMulta;
	
	private LocalDate dataMulta;
	
	private BigDecimal valorMulta;
}
