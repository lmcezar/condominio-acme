package br.com.acme.condominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.unidade.Unidade;
import br.com.acme.unidade.UnidadeDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondominioDTO implements Serializable{
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private List<UnidadeDTO> unidades;
	
	/*public CondominioDTO(Condominio c) {
		this.unidades = new ArrayList<UnidadeDTO>();
		this.id = c.getId();
		this.nome = c.getNome();
		this.email = c.getEmail();
		this.telefone = c.getTelefone();
		
	}*/
}
