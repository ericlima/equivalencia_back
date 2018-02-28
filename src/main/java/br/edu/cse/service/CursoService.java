package br.edu.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Curso;
import br.edu.cse.entity.CursoPadrao;
import br.edu.cse.repository.CursoPadraoRepository;
import br.edu.cse.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	@Autowired
	private CursoPadraoRepository repositoryPadrao;

	public Page<Curso> todos(int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findAll(pageable);
	}

	public Page<Curso> todosPorIes(Long idIes, int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findByIdIes(idIes, pageable);
	}

	public Page<Curso> buscaPorNome(String nome, int pagina, int registrosPorPagina, String ordenadoPor) {

		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));

		Pageable pageable = new PageRequest(pagina, registrosPorPagina, sort);

		return repository.findByNomeContaining(nome, pageable);
	}

	public Curso obtem(Long id) {
		return repository.findOne(id);
	}

	public Curso salva(Curso entidade) {
		return repository.save(entidade);
	}

	public void exclui(Long id) {
		repository.delete(id);
	}

	public Long registros() {
		return repository.count();
	}

	public List<Curso> procuraPorNome(String nome) {
		return repository.findByNome(nome);
	}

	public Long contaPaginas() {
		return repository.count();
	}
	
	public void associa(Long id) {
		try {
		Curso disc = repository.findOne(id);
		CursoPadrao curP = new CursoPadrao();
		curP.setNome(disc.getNome());		
		curP = repositoryPadrao.save(curP);
		disc.setIdCursoPadrao(curP.getId());
		repository.save(disc);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void desassocia(Long id) {
		try {
		Curso cur = repository.findOne(id);
		cur.setIdCursoPadrao(null);
		repository.save(cur);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
	}

}
