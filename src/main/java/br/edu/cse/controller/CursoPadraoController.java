package br.edu.cse.controller;

import java.util.Collection;
import java.util.List;

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

import br.edu.cse.entity.CursoPadrao;
import br.edu.cse.service.CursoPadraoService;

@RestController
@CrossOrigin
@RequestMapping("/cursopadrao")
public class CursoPadraoController {

	@Autowired
	private CursoPadraoService service;

	@GetMapping("/list/{pagina}")
	public Collection<CursoPadrao> todos(@PathVariable Long pagina) {
		Page<CursoPadrao> retorno = service.todos(pagina.intValue(), 20, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/buscapornome/{nome}/pagina/{pagina}")
	public List<CursoPadrao> buscaPorNome(@PathVariable String nome,@PathVariable Integer pagina) {
		return service.buscaPorNome(nome, pagina.intValue(), 10, "nome").getContent();
	}
	
	@GetMapping("/{id}")
	public CursoPadrao obtemCursoPadrao(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping
	public CursoPadrao salva(@RequestBody CursoPadrao entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathVariable Long id) {
		service.exclui(id);
	}

}
