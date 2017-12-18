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
import com.example.gestaocursosapi.model.Aluno;
import com.example.gestaocursosapi.repository.AlunoRepository;
import com.example.gestaocursosapi.service.AlunoService;

@RestController 
@RequestMapping("/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Aluno> criar(final @Valid @RequestBody Aluno aluno, final HttpServletResponse response){
		Aluno alunoSalvo = alunoRepository.save(aluno);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, alunoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Aluno> buscarPeloCodigo(final @PathVariable Long codigo){
		Aluno aluno = alunoRepository.findOne(codigo);
		return aluno != null? ResponseEntity.ok(aluno) : ResponseEntity.notFound().build();
	}
	
	@GetMapping 
	public ResponseEntity<?> listar(){
		List<Aluno> alunos = alunoRepository.findAll();
		return !alunos.isEmpty() ? ResponseEntity.ok(alunos) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(final @PathVariable Long codigo){
		alunoRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Aluno> atualizar(final @PathVariable Long codigo, final @Valid @RequestBody Aluno aluno){
		Aluno pessoaSalva = alunoService.atualizar(codigo, aluno);
		return ResponseEntity.ok(pessoaSalva);
	}
	
}
