/**
 * 
 */
package br.com.acme.heateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.condominio.Condominio;

/**
 * @author lucas
 *
 */
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

}
