/**
 * 
 */
package br.com.acme.heateoas.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.condominio.Condominio;
import br.com.acme.condominio.CondominioDTO;
import br.com.acme.heateoas.service.CondominioService;


/**
 * @author lucas
 *
 */
@RestController
@RequestMapping("/api")
public class CondominioResource {
	
	private CondominioService service;
	
	public CondominioResource(CondominioService service) {
		this.service = service;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/condominios")
	public ResponseEntity<Condominio> save(@RequestBody Condominio condominio) {
		this.service.save(condominio);
		
		return new ResponseEntity<Condominio>(condominio, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/condominios")
	public ResponseEntity<List<CondominioDTO>> list() {
		List<CondominioDTO> condominios = this.service.list();
	
		return ResponseEntity.ok(condominios);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/condominios/{id}")
	public ResponseEntity<Condominio> delete(@PathVariable Long id) {
		Optional<Condominio> condominio = this.service.getById(id);
		if (condominio.isPresent()) {
			this.service.remove(condominio.get().getId());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/condominios/{id}")
	public ResponseEntity<Condominio> edit(@PathVariable Long id){
		Optional<Condominio> condominioOptional = this.service.getById(id);
		Condominio condominio = condominioOptional.get();
		if(condominioOptional.isPresent()) {
			this.service.save(condominio);		
			
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
