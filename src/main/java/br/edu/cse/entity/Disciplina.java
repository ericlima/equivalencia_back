package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISCIPLINA")
public class Disciplina {

	@Id
	@Column(name="ID_DISCIPLINA")
	private Long id;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="ID_IES")
	private Long idIes;

	@Column(name="ID_DISCIPLINA_PADRAO")
	private Long idDisciplinaPadrao;

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

	public Long getIdIes() {
		return idIes;
	}

	public void setIdIes(Long idIes) {
		this.idIes = idIes;
	}

	public Long getIdDisciplinaPadrao() {
		return idDisciplinaPadrao;
	}

	public void setIdDisciplinaPadrao(Long idDisciplinaPadrao) {
		this.idDisciplinaPadrao = idDisciplinaPadrao;
	}
	
}
