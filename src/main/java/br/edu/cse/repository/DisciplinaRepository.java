package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	public List<Disciplina> findByNome(String nome);

	public Page<Disciplina> findByIdIes(Long idIes, Pageable pageReguest);
	
}
