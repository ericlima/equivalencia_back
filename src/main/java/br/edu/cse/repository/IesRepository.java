package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Ies;

public interface IesRepository extends JpaRepository<Ies, Long> {

	public List<Ies> findByNome(String nome);
	
	public Page<Ies> findByNomeContaining(String nome, Pageable pageReguest);
	
}
