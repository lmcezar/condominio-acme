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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.heateoas.service.MultaService;
import br.com.acme.multas.Multa;


/**
 * @author lucas
 *
 */
@RestController
@RequestMapping("/api")
public class MultaResource {
	
	@Autowired
	private MultaService service;
	
	public MultaResource(MultaService service) {
		this.service = service;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/multas")
	public ResponseEntity<Multa> save(@RequestBody Multa multa) {
		
		this.service.save(multa);
		
		return new ResponseEntity<Multa>(multa, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/multas")
	public ResponseEntity<List<Multa>> list() {
		List<Multa> multas = this.service.list();
	
		return ResponseEntity.ok(multas);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/multas/{id}")
	public ResponseEntity<Multa> delete(@PathVariable Long id) {
		Optional<Multa> multa = this.service.getById(id);
		if (multa.isPresent()) {
			this.service.remove(multa.get().getId());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/multas/{id}")
	public ResponseEntity<Multa> edit(@PathVariable Long id){
		Optional<Multa> multaOptional = this.service.getById(id);
		Multa multa = multaOptional.get();
		if(multaOptional.isPresent()) {
			this.service.save(multa);		
			
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
