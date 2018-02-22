package br.edu.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.cse.entity.CursoPadrao;
import br.edu.cse.repository.CursoPadraoRepository;

@Service
public class CursoPadraoService {

	@Autowired
	private CursoPadraoRepository repository;
	
	public Page<CursoPadrao> todos(int pagina, int registrosPorPagina, String ordenadoPor) {
		
		Sort sort = new Sort(new Sort.Order(Direction.ASC, ordenadoPor));
		
		Pageable pageable = new PageRequest(pagina,registrosPorPagina, sort);
		
		return repository.findAll(pageable);
	}
	
	public CursoPadrao obtem(Long id) {
		return repository.findOne(id);
	}
	
	public CursoPadrao salva(CursoPadrao entidade) {
		return repository.save(entidade);
	}
	
	public void exclui(Long id) {
		repository.delete(id);
	}	
	
	public Long registros() {
		return repository.count();
	}
	
	public List<CursoPadrao> procuraPorNome(String nome) {
		return repository.findByNome(nome);
	}


}
