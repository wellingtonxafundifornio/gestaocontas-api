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
import com.example.gestaocursosapi.model.Turma;
import com.example.gestaocursosapi.repository.TurmaRepository;
import com.example.gestaocursosapi.service.TurmaService;

@RestController 
@RequestMapping("/turmas")
public class TurmaResource {

	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	//publisher.publishEvent(new RecursoCriadoEvent(this, response, cursoSalvo.getCodigo()));
	
	@PostMapping
	public ResponseEntity<Turma> criar(final @Valid @RequestBody Turma turma, final HttpServletResponse response){
		Turma turmaSalva = turmaRepository.save(turma);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, turmaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Turma> buscarPeloCodigo(final @PathVariable Long codigo){
		Turma turma = turmaRepository.findOne(codigo);
		return turma != null? ResponseEntity.ok(turma) : ResponseEntity.notFound().build();
	}
	
	@GetMapping 
	public ResponseEntity<?> listar(){
		List<Turma> turma = turmaRepository.findAll();
		return !turma.isEmpty() ? ResponseEntity.ok(turma) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(final @PathVariable Long codigo){
		turmaRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Turma> atualizar(final @PathVariable Long codigo, final @Valid @RequestBody Turma turma){
		Turma turmaSalva = turmaService.atualizar(codigo, turma);
		return ResponseEntity.ok(turmaSalva);
	}
	
}
