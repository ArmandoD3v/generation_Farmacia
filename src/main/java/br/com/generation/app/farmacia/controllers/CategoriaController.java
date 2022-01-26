package br.com.generation.app.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.generation.app.farmacia.repositories.CategoriaRepository;
import br.com.generation.app.farmacia.models.Categoria;



@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins="*",allowedHeaders="*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity <List <Categoria>>  findAllCategoria(){
		return ResponseEntity.ok(categoriaRepository.findAll());	
		
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Categoria> findByIDCategoria(@PathVariable Long id){
		return categoriaRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> findAllByCategoria (@PathVariable String categoria){
		return ResponseEntity.ok(categoriaRepository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria) {
		
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	
	@DeleteMapping("/apagar/{id}")

	public void delete(@PathVariable long id)  {

		categoriaRepository.deleteById (id);

	}
}
