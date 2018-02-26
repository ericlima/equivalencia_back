package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.Disciplina;
import br.edu.cse.entity.DisciplinaPadrao;

public interface DisciplinaPadraoRepository extends JpaRepository<DisciplinaPadrao, Long> {
	
	public List<DisciplinaPadrao> findByNome(String nome);
	
	public Page<DisciplinaPadrao> findByNomeContaining(String nome, Pageable pageReguest);

}
