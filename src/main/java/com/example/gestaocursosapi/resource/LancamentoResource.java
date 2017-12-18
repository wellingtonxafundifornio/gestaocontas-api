package com.example.gestaocursosapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestaocursosapi.event.RecursoCriadoEvent;
import com.example.gestaocursosapi.model.Lancamento;
import com.example.gestaocursosapi.repository.filter.LancamentoFilter;
import com.example.gestaocursosapi.service.LancamentoService;

@RestController 
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	LancamentoService lancamentoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Lancamento> criar(final @Valid @RequestBody Lancamento lancamento, final HttpServletResponse response){
		Lancamento lancamentoSalvo = lancamentoService.criar(lancamento);		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	// Filtrar lancamento por data
	@PostMapping("/filtro")
	public List<Lancamento> filtrar(final @RequestBody LancamentoFilter lancamentoFilter){
		return lancamentoService.filtrar(lancamentoFilter);
	}
	
	

	@GetMapping("/{codigo}")
	public ResponseEntity<List<Lancamento>> buscarPeloCodigoConta(final @PathVariable Long codigo){
		List<Lancamento> lancamentos = lancamentoService.buscarPorConta(codigo);
		return lancamentos  != null? ResponseEntity.ok(lancamentos ) : ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<List<Lancamento>> listar(){
		List<Lancamento> lancamentos =  lancamentoService.listarTodos();
		return lancamentos  != null? ResponseEntity.ok(lancamentos ) : ResponseEntity.notFound().build();
	}

//	@PostMapping("/filtro")
//	public ResponseEntity<List<Lancamento>> listarPorFiltro(final @RequestBody FiltroLancamento filtro, final HttpServletResponse response){
//		//List<Lancamento> lancamentos = lancamentoService.findByContaCodigoOrValor(filtro);
//		List<Lancamento> lancamentos = lancamentoService.findByContaCodigoOrValor(filtro);
//		return !lancamentos.isEmpty() ? ResponseEntity.ok(lancamentos) : ResponseEntity.noContent().build();
//	}

}

