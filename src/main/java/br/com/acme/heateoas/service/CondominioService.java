/**
 * 
 */
package br.com.acme.heateoas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.condominio.Condominio;
import br.com.acme.condominio.CondominioDTO;
import br.com.acme.heateoas.repository.CondominioRepository;
import br.com.acme.heateoas.repository.UnidadeRepository;
import br.com.acme.unidade.Unidade;
import br.com.acme.unidade.UnidadeDTO;

/**
 * @author lucas
 *
 */

@Service
public class CondominioService {
	
	@Autowired
	private CondominioRepository repository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Transactional(readOnly=true)
	public List<CondominioDTO> list(){
		List<Condominio> condominios = this.repository.findAll();
		List<CondominioDTO> listaCondominiosDTO = new ArrayList<CondominioDTO>();
		
		for(Condominio c : condominios){
			
			ModelMapper modelMapper = new ModelMapper();
			//Carrega o DTO com as as informações da Entidade
			CondominioDTO condDTO = modelMapper.map(c,CondominioDTO.class);
			//Vai buscar as unidades
			List<Unidade> unidades =unidadeRepository.findByCondominio(c);
			
			condDTO.setUnidades(new ArrayList<UnidadeDTO>());
			
			for(Unidade u : unidades) {
				UnidadeDTO unidadeDTO = modelMapper.map(u,UnidadeDTO.class);
				condDTO.getUnidades().add(unidadeDTO);
			}
			
			listaCondominiosDTO.add(condDTO);
		}
		
		return listaCondominiosDTO;
	}
	
	@Transactional
	public void save(Condominio condominio) {
		this.repository.save(condominio);
	}
	
	@Transactional
	public void remove(Long id) {
		this.repository.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Condominio> getById(Long id) {
		Optional<Condominio> cond = this.repository.findById(id);
		return cond;
	}

}
