package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	public List<Curso> findByNome(String nome);
	
public Page<Curso> findByIdIes(Long idIes, Pageable pageReguest);
	
	public Page<Curso> findByNomeContaining(String nome, Pageable pageReguest);
	
}
