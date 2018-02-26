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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cse.entity.DisciplinaPadrao;
import br.edu.cse.service.DisciplinaPadraoService;

@RestController
@CrossOrigin
@RequestMapping("/disciplinapadrao")
public class DisciplinaPadraoController {

	@Autowired
	private DisciplinaPadraoService service;

	@GetMapping("/list/{pagina}")
	public Collection<DisciplinaPadrao> todos(@PathVariable Long pagina) {
		Page<DisciplinaPadrao> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/buscapornome/{nome}/pagina/{pagina}")
	public List<DisciplinaPadrao> buscaPorNome(@PathVariable String nome,@PathVariable Integer pagina) {
		return service.buscaPorNome(nome, pagina.intValue(), 10, "nome").getContent();
	}
	
	@GetMapping("/{id}")
	public DisciplinaPadrao obtemDisciplinaPadrao(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping
	public DisciplinaPadrao salva(@RequestBody DisciplinaPadrao entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}


}
