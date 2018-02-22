package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {

	@Id
	@GeneratedValue
	@Column(name = "ID_DISCIPLINA")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "ID_IES")
	private Long idIes;

	@Column(name = "ID_DISCIPLINA_PADRAO")
	private Long idDisciplinaPadrao;

	@Column(name = "CARGA_HORARIA", nullable = false)
	private Integer cargaHoraria;

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargaHoraria == null) ? 0 : cargaHoraria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDisciplinaPadrao == null) ? 0 : idDisciplinaPadrao.hashCode());
		result = prime * result + ((idIes == null) ? 0 : idIes.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (cargaHoraria == null) {
			if (other.cargaHoraria != null)
				return false;
		} else if (!cargaHoraria.equals(other.cargaHoraria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDisciplinaPadrao == null) {
			if (other.idDisciplinaPadrao != null)
				return false;
		} else if (!idDisciplinaPadrao.equals(other.idDisciplinaPadrao))
			return false;
		if (idIes == null) {
			if (other.idIes != null)
				return false;
		} else if (!idIes.equals(other.idIes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
