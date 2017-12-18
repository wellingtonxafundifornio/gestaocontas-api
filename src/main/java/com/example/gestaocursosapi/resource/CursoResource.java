package com.example.gestaocursosapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.example.gestaocursosapi.event.RecursoCriadoEvent;
import com.example.gestaocursosapi.model.Curso;
import com.example.gestaocursosapi.repository.CursoRepository;
import com.example.gestaocursosapi.service.CursoService;

@RestController 
@RequestMapping("/cursos")
public class CursoResource {

	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Curso> criar(final @Valid @RequestBody Curso curso, final HttpServletResponse response){
		Curso cursoSalvo = cursoRepository.save(curso);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cursoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Curso> buscarPeloCodigo(final @PathVariable Long codigo){
		Curso curso = cursoRepository.findOne(codigo);
		return curso != null? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
	}
	
	@GetMapping 
	public ResponseEntity<?> listar(){
		List<Curso> curso = cursoRepository.findAll();
		return !curso.isEmpty() ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(final @PathVariable Long codigo){
		cursoRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Curso> atualizar(final @PathVariable Long codigo, final @Valid @RequestBody Curso curso){
		Curso cursoSalvo = cursoService.atualizar(codigo, curso);
		return ResponseEntity.ok(cursoSalvo);
	}
}
