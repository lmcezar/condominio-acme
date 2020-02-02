/**
 * 
 */
package br.com.acme.heateoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.aviso.Aviso;
import br.com.acme.heateoas.repository.AvisoRepository;
import br.com.acme.multas.Multa;

/**
 * @author lucas
 *
 */

@Service
public class AvisoService {
	
	@Autowired
	private AvisoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Aviso> list(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void save(Aviso aviso) {
		this.repository.save(aviso);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Aviso> getById(Long id) {
		return this.repository.findById(id);
	}

}
