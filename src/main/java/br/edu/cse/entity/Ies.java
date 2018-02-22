package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IES")
public class Ies {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID_IES")
	private Long id;
	@Column(name="NOME", nullable=false)
	private String nome;
	@Column(name="IES_EXTERNA")
	private Boolean externa;
	
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
	public Boolean getExterna() {
		return externa;
	}
	public void setExterna(Boolean externa) {
		this.externa = externa;
	}
	
	
}
