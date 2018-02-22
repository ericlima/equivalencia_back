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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.Disciplina;
import br.edu.cse.service.DisciplinaService;

@RestController
@CrossOrigin
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;

	@GetMapping("/disciplina/{pagina}")
	public Collection<Disciplina> todos(@PathVariable Long pagina) {
		Page<Disciplina> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/disciplina/buscapornome/{nome}")
	public List<Disciplina> procuraPorNome(@PathVariable String nome) {
		return service.procuraPorNome(nome);
	}
	
	@GetMapping("/disciplina/{id}")
	public Disciplina obtemCidade(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping("/disciplina")
	public Disciplina salva(Disciplina entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/disciplina/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}

}
