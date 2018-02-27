package br.edu.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Disciplina;
import br.edu.cse.entity.DisciplinaPadrao;
import br.edu.cse.repository.DisciplinaPadraoRepository;
import br.edu.cse.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;

	@Autowired
	private DisciplinaPadraoRepository repositoryPadrao;

	public Page<Disciplina> todos(int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findAll(pageable);
	}

	public Page<Disciplina> todosPorIes(Long idIes, int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findByIdIes(idIes, pageable);
	}

	public Page<Disciplina> buscaPorNome(String nome, int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findByNomeContaining(nome, pageable);
	}

	public Disciplina obtem(Long id) {
		return repository.findOne(id);
	}

	public Disciplina salva(Disciplina entidade) {
		return repository.save(entidade);
	}

	public void exclui(Long id) {
		repository.delete(id);
	}

	public Long registros() {
		return repository.count();
	}

	public List<Disciplina> procuraPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public Long contaPaginas() {
		return repository.count();
	}
	
	public void associa(Long id) {
		Disciplina disc = repository.findOne(id);
		DisciplinaPadrao discP = new DisciplinaPadrao();
		discP.setNome(disc.getNome());
		discP.setCargaHoraria(disc.getCargaHoraria());
		discP = repositoryPadrao.save(discP);
		disc.setIdDisciplinaPadrao(discP.getId());
		repository.save(disc);
	}

	public void desassocia(Long id) {
		Disciplina disc = repository.findOne(id);
		disc.setIdDisciplinaPadrao(null);
		repository.save(disc);
	}
	
}
