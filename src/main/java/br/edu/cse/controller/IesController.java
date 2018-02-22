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

import br.edu.cse.entity.Ies;
import br.edu.cse.service.IesService;

@RestController
@CrossOrigin
public class IesController {

	@Autowired
	private IesService service;

	@GetMapping("/ies/{pagina}")
	public Collection<Ies> todos(@PathVariable Long pagina) {
		Page<Ies> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/ies/{id}")
	public Ies obtemIes(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@GetMapping("/ies/buscapornome/{nome}")
	public List<Ies> procuraPorNome(@PathVariable String nome) {
		return service.procuraPorNome(nome);
	}
	
	@PostMapping("/ies")
	public Ies salva(Ies entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/ies/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}

	
}
