/**
 * 
 */
package br.com.acme.heateoas.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.acme.aviso.Aviso;
import br.com.acme.heateoas.service.AvisoService;


/**
 * @author lucas
 *
 */
@RestController
@RequestMapping("/api")
public class AvisoResource {
	
	@Autowired
	private AvisoService service;
	
	public AvisoResource(AvisoService service) {
		this.service = service;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/avisos")
	public ResponseEntity<Aviso> save(@RequestBody Aviso aviso) {
		
		this.service.save(aviso);
		
		return new ResponseEntity<Aviso>(aviso, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/avisos")
	public ResponseEntity<List<Aviso>> list() {
		List<Aviso> avisos = this.service.list();
	
		return ResponseEntity.ok(avisos);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/avisos/{id}")
	public ResponseEntity<Aviso> delete(@PathVariable Long id) {
		Optional<Aviso> aviso = this.service.getById(id);
		if (aviso.isPresent()) {
			this.service.remove(aviso.get().getId());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/avisos/{id}")
	public ResponseEntity<Aviso> edit(@PathVariable Long id){
		Optional<Aviso> avisoOptional = this.service.getById(id);
		Aviso aviso = avisoOptional.get();
		if(avisoOptional.isPresent()) {
			this.service.save(aviso);		
			
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
