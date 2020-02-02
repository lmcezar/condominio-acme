/**
 * 
 */
package br.com.acme.heateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.responsavel.Responsavel;

/**
 * @author lucas
 *
 */
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

}
