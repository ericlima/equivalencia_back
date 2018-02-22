package br.edu.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Curso;
import br.edu.cse.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;
	
	public Page<Curso> todos(int pagina, int registrosPorPagina, String ordenadoPor) {
		
		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));
		
		Pageable pageable = new PageRequest(pagina,registrosPorPagina, sort);
		
		return repository.findAll(pageable);
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


}
