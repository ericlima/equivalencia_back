package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURSO")
public class Curso {

	@Id
	@Column(name="ID_CURSO")
	private Long id;

	@Column(name="NOME")
	private String nome;

	@Column(name="ID_CURSO_PADRAO")
	private Long idCursoPadrao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdCursoPadrao() {
		return idCursoPadrao;
	}

	public void setIdCursoPadrao(Long idCursoPadrao) {
		this.idCursoPadrao = idCursoPadrao;
	}
	
	
	
}
