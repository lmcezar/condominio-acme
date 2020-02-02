/**
 * 
 */
package br.com.acme.heateoas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.acme.heateoas.repository.AvisoRepository;
import br.com.acme.heateoas.repository.MultaRepository;
import br.com.acme.heateoas.repository.UnidadeRepository;
import br.com.acme.unidade.Unidade;
import br.com.acme.unidade.UnidadeDTO;

/**
 * @author lucas
 *
 */

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository repository;
	
	@Autowired
	private MultaRepository multaRepository;
	
	@Autowired
	private AvisoRepository avisoRepository;
	
	@Transactional(readOnly=true)
	public List<UnidadeDTO> list(){
		List<Unidade> unidades = this.repository.findAll();
		List<UnidadeDTO> listaUnidades = new ArrayList<UnidadeDTO>();
		ModelMapper modelMapper = new ModelMapper();
		
		for(Unidade u : unidades) {
			
			UnidadeDTO unidadeDTO = modelMapper.map(u, UnidadeDTO.class);
			boolean possuiMulta = multaRepository.findByUnidade(u).size() > 0;
			boolean possuiAviso = avisoRepository.findByUnidade(u).size() > 0;
			
			unidadeDTO.setPossuiMulta(possuiMulta);
			unidadeDTO.setPossuiAviso(possuiAviso);
			
			listaUnidades.add(unidadeDTO);
		}
		
		return listaUnidades;
	}
	
	@Transactional(readOnly=true)
	public List<UnidadeDTO> listComMulta(){
		List<UnidadeDTO> listaUnidades = this.list();
		
		List<UnidadeDTO> unidadesComMulta = new ArrayList<UnidadeDTO>();
		
		
		for(UnidadeDTO u : listaUnidades) {
			
			if(u.isPossuiMulta()) {
				unidadesComMulta.add(u);
			}
		}
		
		return unidadesComMulta;
	}

	

	
	
	@Transactional(readOnly=true)
	public List<UnidadeDTO> listSemMulta(){
		List<UnidadeDTO> listaUnidades = this.list();
		
		List<UnidadeDTO> unidadesSemMulta = new ArrayList<UnidadeDTO>();
		
		for(UnidadeDTO u : listaUnidades) {
			
			if(!u.isPossuiMulta()) {
				unidadesSemMulta.add(u);
			}
		}
		
		return unidadesSemMulta;
	}
	
	@Transactional(readOnly=true)
	public List<UnidadeDTO> listComAviso(){
		List<UnidadeDTO> listaUnidades = this.list();
		
		List<UnidadeDTO> unidadesComAviso = new ArrayList<UnidadeDTO>();
		
		
		for(UnidadeDTO u : listaUnidades) {
			
			if(u.isPossuiAviso()) {
				unidadesComAviso.add(u);
			}
		}
		
		return unidadesComAviso;
	}
	
	@Transactional(readOnly=true)
	public List<UnidadeDTO> listSemAviso(){
		List<UnidadeDTO> listaUnidades = this.list();
		
		List<UnidadeDTO> unidadesSemAviso = new ArrayList<UnidadeDTO>();
		
		for(UnidadeDTO u : listaUnidades) {
			
			if(!u.isPossuiAviso()) {
				unidadesSemAviso.add(u);
			}
		}
		
		return unidadesSemAviso;
	}
	
	
	
	@Transactional
	public void save(Unidade condominio) {
		this.repository.save(condominio);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Unidade> getById(Long id) {
		return this.repository.findById(id);
	}

}
