/**
 * 
 */
package br.com.acme.heateoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.multas.Multa;
import br.com.acme.unidade.Unidade;

/**
 * @author lucas
 *
 */
public interface MultaRepository extends JpaRepository<Multa, Long> {

	List<Multa> findByUnidade(Unidade u);

}
