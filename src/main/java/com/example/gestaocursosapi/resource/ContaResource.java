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
import com.example.gestaocursosapi.model.Conta;
import com.example.gestaocursosapi.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource {
	
	@Autowired
	ContaService contaService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping 
	public ResponseEntity<?> listar(){
		List<Conta> contas = contaService.findAll();
		return !contas.isEmpty() ? ResponseEntity.ok(contas) : ResponseEntity.noContent().build();
	}
	

	@PostMapping
	public ResponseEntity<Conta> criar(final @Valid @RequestBody Conta conta, final HttpServletResponse response){
		Conta contaSalva = contaService.save(conta);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, contaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Conta> buscarPeloCodigo(final @PathVariable Long codigo){
		Conta conta = contaService.findOne(codigo);
		return conta != null? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
	}

	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(final @PathVariable Long codigo){
		contaService.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Conta> atualizar(final @PathVariable Long codigo, final @Valid @RequestBody Conta conta){
		Conta contaSalva = contaService.atualizar(codigo, conta);
		return ResponseEntity.ok(contaSalva);
	}
	
	
}
