package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "CURSO")
public class Curso {

	@Id
	@GeneratedValue
	@Column(name = "ID_CURSO")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "ID_IES", nullable = false)
	private Long idIes;
	
	@Column(name = "ID_CURSO_PADRAO")
	private Long idCursoPadrao;

	@JsonInclude()
	@Transient
	private String nomeCursoPadrao;

	public Long getIdIes() {
		return idIes;
	}

	public void setIdIes(Long idIes) {
		this.idIes = idIes;
	}

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
	
	public String getNomeCursoPadrao() {
		return nomeCursoPadrao;
	}

	public void setNomeCursoPadrao(String nomeCursoPadrao) {
		this.nomeCursoPadrao = nomeCursoPadrao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCursoPadrao == null) ? 0 : idCursoPadrao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCursoPadrao == null) {
			if (other.idCursoPadrao != null)
				return false;
		} else if (!idCursoPadrao.equals(other.idCursoPadrao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
