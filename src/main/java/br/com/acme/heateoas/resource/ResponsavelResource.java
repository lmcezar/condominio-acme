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

import br.com.acme.responsavel.Responsavel;
import br.com.acme.heateoas.service.ResponsavelService;


/**
 * @author lucas
 *
 */
@RestController
@RequestMapping("/api")
public class ResponsavelResource {
	
	private ResponsavelService service;
	
	public ResponsavelResource(ResponsavelService service) {
		this.service = service;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/responsavel")
	public ResponseEntity<Responsavel> save(@RequestBody Responsavel responsavel) {
		this.service.save(responsavel);
		
		return new ResponseEntity<Responsavel>(responsavel, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/responsavel")
	public ResponseEntity<List<Responsavel>> list() {
		List<Responsavel> responsavel = this.service.list();
	
		return ResponseEntity.ok(responsavel);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/responsavel/{id}")
	public ResponseEntity<Responsavel> delete(@PathVariable Long id) {
		Optional<Responsavel> responsavel = this.service.getById(id);
		if (responsavel.isPresent()) {
			this.service.remove(responsavel.get().getId());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/responsavel/{id}")
	public ResponseEntity<Responsavel> edit(@PathVariable Long id){
		Optional<Responsavel> responsavelOptional = this.service.getById(id);
		Responsavel responsavel = responsavelOptional.get();
		if(responsavelOptional.isPresent()) {
			this.service.save(responsavel);		
			
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
