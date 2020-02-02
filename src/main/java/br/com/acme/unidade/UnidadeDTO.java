/**
 * 
 */
package br.com.acme.unidade;

import java.util.List;

import br.com.acme.multas.MultaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadeDTO {
	
	private Long id;
	
	private String numeroUnidade;
	
	private String blocoUnidade;
	
	private boolean possuiMulta;
	
	private boolean possuiAviso;
	
}