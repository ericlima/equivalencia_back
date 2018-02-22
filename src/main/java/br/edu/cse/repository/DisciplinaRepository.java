package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	public List<Disciplina> findByNome(String nome);
	
}
