/**
 * 
 */
package br.com.acme.heateoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.condominio.Condominio;
import br.com.acme.unidade.Unidade;

/**
 * @author lucas
 *
 */
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

	List<Unidade> findByCondominio(Condominio c);
}
