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

import br.edu.cse.entity.CursoPadrao;
import br.edu.cse.service.CursoPadraoService;

@RestController
@CrossOrigin
public class CursoPadraoController {

	@Autowired
	private CursoPadraoService service;

	@GetMapping("/cursopadrao/{pagina}")
	public Collection<CursoPadrao> todos(@PathVariable Long pagina) {
		Page<CursoPadrao> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/cursopadrao/{id}")
	public CursoPadrao obtemCidade(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping("/cursopadrao")
	public CursoPadrao salva(CursoPadrao entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/cursopadrao/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}

}
