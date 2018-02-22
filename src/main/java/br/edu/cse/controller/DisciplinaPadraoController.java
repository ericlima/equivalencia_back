package br.edu.cse.controller;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.DisciplinaPadrao;
import br.edu.cse.service.DisciplinaPadraoService;

@RestController
@CrossOrigin
public class DisciplinaPadraoController {

	@Autowired
	private DisciplinaPadraoService service;

	@GetMapping("/disciplinapadrao/{pagina}")
	public Collection<DisciplinaPadrao> todos(@PathVariable Long pagina) {
		Page<DisciplinaPadrao> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/disciplinapadrao/{id}")
	public DisciplinaPadrao obtemCidade(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping("/disciplinapadrao")
	public DisciplinaPadrao salva(DisciplinaPadrao entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/disciplinapadrao/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}


}
