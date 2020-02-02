/**
 * 
 */
package br.com.acme.condominio;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.acme.unidade.Unidade;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author carlosfilho
 *
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "tb_condominio")
public class Condominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominoMulta")
	private Set<Multa> multasAplicadas;*/
	
	/*@OneToMany
	private Set<Aviso> avisos;*/
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "condominio")
	private Set<Unidade> unidades;*/
	
}
