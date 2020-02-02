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

import br.com.acme.heateoas.service.UnidadeService;
import br.com.acme.unidade.Unidade;
import br.com.acme.unidade.UnidadeDTO;


/**
 * @author lucas
 *
 */
@RestController
@RequestMapping("/api")
public class UnidadeResource {
	
	private UnidadeService service;
	
	public UnidadeResource(UnidadeService service) {
		this.service = service;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/unidades")
	public ResponseEntity<Unidade> save(@RequestBody Unidade unidade) {
		this.service.save(unidade);
		
		return new ResponseEntity<Unidade>(unidade, HttpStatus.CREATED);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidades")
	public ResponseEntity<List<UnidadeDTO>> list() {
		List<UnidadeDTO> unidades = this.service.list();
	
		return ResponseEntity.ok(unidades);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidades/commulta")
	public ResponseEntity<List<UnidadeDTO>> listComMultas() {
		List<UnidadeDTO> unidades = this.service.listComMulta();
	
		return ResponseEntity.ok(unidades);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidades/semmulta")
	public ResponseEntity<List<UnidadeDTO>> listSemMultas() {
		List<UnidadeDTO> unidades = this.service.listSemMulta();
	
		return ResponseEntity.ok(unidades);
		
	}
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidades/comaviso")
	public ResponseEntity<List<UnidadeDTO>> listComAviso() {
		List<UnidadeDTO> unidades = this.service.listComAviso();
	
		return ResponseEntity.ok(unidades);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/unidades/semaviso")
	public ResponseEntity<List<UnidadeDTO>> listSemAviso() {
		List<UnidadeDTO> unidades = this.service.listSemAviso();
	
		return ResponseEntity.ok(unidades);
		
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/unidades/{id}")
	public ResponseEntity<Unidade> delete(@PathVariable Long id) {
		Optional<Unidade> unidade = this.service.getById(id);
		if (unidade.isPresent()) {
			this.service.remove(unidade.get().getId());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/unidades/{id}")
	public ResponseEntity<Unidade> edit(@PathVariable Long id){
		Optional<Unidade> unidadeOptional = this.service.getById(id);
		Unidade unidade = unidadeOptional.get();
		if(unidadeOptional.isPresent()) {
			this.service.save(unidade);		
			
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	

}
