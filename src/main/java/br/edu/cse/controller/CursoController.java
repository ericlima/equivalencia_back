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

import br.edu.cse.entity.Curso;
import br.edu.cse.entity.CursoPadrao;
import br.edu.cse.service.CursoPadraoService;
import br.edu.cse.service.CursoService;

@RestController
@CrossOrigin
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@Autowired
	private CursoPadraoService servicePadrao;

	@GetMapping("/list/{pagina}")
	public Collection<Curso> todos(@PathVariable Long pagina) {
		Page<Curso> retorno = service.todos(pagina.intValue(), 10, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/ies/{ies}/list/{pagina}")
	public Collection<Curso> todosPorIes(@PathVariable Long ies, @PathVariable Long pagina) {
		Page<Curso> retorno = service.todosPorIes(ies,pagina.intValue(), 10, "nome");
		for(Curso curso : retorno) {
			if (curso.getIdCursoPadrao() != null && curso.getIdCursoPadrao() > 0) {
				CursoPadrao padrao = servicePadrao.obtem(curso.getIdCursoPadrao());
				if (padrao != null) {
					curso.setNomeCursoPadrao(padrao.getNome());					
				}
			}
		}
		return retorno.getContent();
	}

	@GetMapping("/nome/{nome}")
	public List<Curso> procuraPorNome(@PathVariable String nome) {
		return service.procuraPorNome(nome);
	}
	
	@GetMapping("/nome/{nome}/pagina/{pagina}")
	public List<Curso> procuraPorNomePaginado(@PathVariable String nome, @PathVariable Long pagina) {
		List<Curso> retorno = service.buscaPorNome(nome, pagina.intValue(), 10, "nome").getContent();
		for(Curso curso : retorno) {
			if (curso.getIdCursoPadrao() !=null && curso.getIdCursoPadrao() > 0) {
				CursoPadrao padrao = servicePadrao.obtem(curso.getIdCursoPadrao());
				curso.setNomeCursoPadrao(padrao.getNome());				
			}
		}
		return retorno; 
	}
	
	@GetMapping("/{id}")
	public Curso obtemCurso(@PathVariable Long id) {
		return service.obtem(id);
	}
	
	@PostMapping
	public Curso salva(@RequestBody Curso entidade) {
		return service.salva(entidade);
	}
	
	@DeleteMapping("/{id}")
	public void exclui(@PathVariable Long id) {
		service.exclui(id);
	}
	
	@GetMapping("/contapaginas")
	public Long contaPaginas() {
		return service.contaPaginas()/20;
	}
	
	@GetMapping("/autoassociacao/{id}")
	public void autoAssociacao(@PathVariable Long id) {
		service.associa(id);
	}
	
	@GetMapping("/desassocia/{id}")
	public void desassocia(@PathVariable Long id) {
		service.desassocia(id);
	}
}
