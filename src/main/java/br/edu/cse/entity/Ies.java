package br.edu.cse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IES")
public class Ies {

	@Id
	@GeneratedValue
	@Column(name = "ID_IES")
	private Long id;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "IES_EXTERNA")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((externa == null) ? 0 : externa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ies other = (Ies) obj;
		if (externa == null) {
			if (other.externa != null)
				return false;
		} else if (!externa.equals(other.externa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
