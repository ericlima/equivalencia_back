package br.edu.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.Disciplina;
import br.edu.cse.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	public Page<Disciplina> todos(int pagina, int registrosPorPagina, String ordenadoPor) {
		
		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));
		
		Pageable pageable = new PageRequest(pagina,registrosPorPagina, sort);
		
		return repository.findAll(pageable);
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

}
