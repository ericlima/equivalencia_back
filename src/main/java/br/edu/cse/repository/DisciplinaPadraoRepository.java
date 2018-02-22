package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.DisciplinaPadrao;

public interface DisciplinaPadraoRepository extends JpaRepository<DisciplinaPadrao, Long> {
	
	public List<DisciplinaPadrao> findByNome(String nome);
	
}
