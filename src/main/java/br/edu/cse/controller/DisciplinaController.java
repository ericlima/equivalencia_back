package br.edu.cse.controller;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

	private MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
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
				if (padrao != null) {
					disciplina.setNomeDisciplinaPadrao(padrao.getNome());
					disciplina.setCargaHorariaDisciplinaPadrao(padrao.getCargaHoraria());
				}
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
	
	@GetMapping("/message")
	public String pegaMessage() {
		String retorno;
		try {
			retorno = messageSource.getMessage("hello.header",null,Locale.US);
		} catch (Exception e) {
			retorno = e.getMessage();
		}
		return retorno;
	}


}
