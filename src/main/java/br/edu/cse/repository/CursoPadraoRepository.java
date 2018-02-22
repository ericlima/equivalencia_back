package br.edu.cse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cse.entity.CursoPadrao;

public interface CursoPadraoRepository extends JpaRepository<CursoPadrao, Long> {

	public List<CursoPadrao> findByNome(String nome);
	
}
