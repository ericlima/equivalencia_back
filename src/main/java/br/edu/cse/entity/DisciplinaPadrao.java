package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISCIPLINA_PADRAO")
public class DisciplinaPadrao {

	@Id
	@Column(name="ID_DISCIPLINA_PADRAO")
	private Long id;
	
	@Column(name="NOME")
	private String nome;

	@Column(name="CARGA_HORARIA")
	private Integer cargaHoraria;

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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
}
