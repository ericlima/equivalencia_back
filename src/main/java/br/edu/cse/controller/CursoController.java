package br.edu.cse.controller;

import java.util.Collection;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Curso;
import br.edu.cse.service.CursoService;

@RestController
@CrossOrigin
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/list/{pagina}")
	public Collection<Curso> todos(@PathVariable Long pagina) {
		Page<Curso> retorno = service.todos(pagina.intValue(), 10, "nome");
		return retorno.getContent();
	}

	@GetMapping("/curso/buscapornome/{nome}")
	public List<Curso> procuraPorNome(@PathVariable String nome) {
		return service.procuraPorNome(nome);
	}
	
	@GetMapping("/{id}")
	public Curso obtemCurso(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	
	public Curso salva(@RequestBody Curso entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}
	
	@GetMapping("/contapaginas")
	public Long obtemPaginas() {
		return (service.registros()/10);
	}

}
