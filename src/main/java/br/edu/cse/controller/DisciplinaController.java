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

import br.edu.cse.entity.Disciplina;
import br.edu.cse.entity.DisciplinaPadrao;
import br.edu.cse.service.DisciplinaPadraoService;
import br.edu.cse.service.DisciplinaService;

@RestController
@CrossOrigin
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;

	@Autowired
	private DisciplinaPadraoService servicePadrao;

	@GetMapping("/list/{pagina}")
	public Collection<Disciplina> todos(@PathVariable Long pagina) {
		Page<Disciplina> retorno = service.todos(pagina.intValue(), 10, "nome");
		return retorno.getContent();
	}
	
	@GetMapping("/ies/{ies}/list/{pagina}")
	public Collection<Disciplina> todosPorIes(@PathVariable Long ies, @PathVariable Long pagina) {
		Page<Disciplina> retorno = service.todosPorIes(ies,pagina.intValue(), 10, "nome");
		for(Disciplina disciplina : retorno) {
			if (disciplina.getIdDisciplinaPadrao() != null && disciplina.getIdDisciplinaPadrao() > 0) {
				DisciplinaPadrao padrao = servicePadrao.obtem(disciplina.getIdDisciplinaPadrao());
				disciplina.setNomeDisciplinaPadrao(padrao.getNome());
				disciplina.setCargaHorariaDisciplinaPadrao(padrao.getCargaHoraria());
			}
		}
		return retorno.getContent();
	}

	@GetMapping("/nome/{nome}")
	public List<Disciplina> procuraPorNome(@PathVariable String nome) {
		return service.procuraPorNome(nome);
	}

	@GetMapping("/nome/{nome}/pagina/{pagina}")
	public List<Disciplina> procuraPorNomePaginado(@PathVariable String nome, @PathVariable Long pagina) {
		List<Disciplina> retorno = service.buscaPorNome(nome, pagina.intValue(), 10, "nome").getContent();
		for(Disciplina disciplina : retorno) {
			if (disciplina.getIdDisciplinaPadrao() !=null && disciplina.getIdDisciplinaPadrao() > 0) {
				DisciplinaPadrao padrao = servicePadrao.obtem(disciplina.getIdDisciplinaPadrao());
				disciplina.setNomeDisciplinaPadrao(padrao.getNome());
				disciplina.setCargaHorariaDisciplinaPadrao(padrao.getCargaHoraria());
			}
		}
		return retorno; 
	}

	@GetMapping("/{id}")
	public Disciplina obtemDisciplina(@PathVariable Long id) {
		return service.obtem(id);
	}

	@PostMapping
	public Disciplina salva(@RequestBody Disciplina entidade) {
		return service.salva(entidade);
	}

	@DeleteMapping("/{id}")
	public void exclui(@PathParam(value = "id") Long id) {
		service.exclui(id);
	}
	
	@GetMapping("/contapaginas")
	public Long contaPaginas() {
		return service.contaPaginas()/20;
	}

}
