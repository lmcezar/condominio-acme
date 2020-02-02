/**
 * 
 */
package br.com.acme.heateoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.responsavel.Responsavel;
import br.com.acme.heateoas.repository.ResponsavelRepository;

/**
 * @author lucas
 *
 */

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository repository;
	
	@Transactional(readOnly=true)
	public List<Responsavel> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Responsavel responsavel) {
		this.repository.save(responsavel);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Responsavel> getById(Long id) {
		return this.repository.findById(id);
	}

}
