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

import br.edu.cse.entity.Curso;
import br.edu.cse.service.CursoService;

@RestController
@CrossOrigin
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/curso/{pagina}")
	public Collection<Curso> todos(@PathVariable Long pagina) {
		Page<Curso> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/curso/{id}")
	public Curso obtemCidade(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping("/curso")
	public Curso salva(Curso entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/curso/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}

}