package com.ftninformatika.jwd.modul3.test.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prijava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime datumPrijave;
	
	@Column
	private String disciplina;
	
	@ManyToOne
	private Takmicar takmicar;

	public Prijava() {
		super();
	}

	public Prijava(Long id, LocalDateTime datumPrijave, String disciplina, Takmicar takmicar) {
		super();
		this.id = id;
		this.datumPrijave = datumPrijave;
		this.disciplina = disciplina;
		this.takmicar = takmicar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(LocalDateTime datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Takmicar getTakmicar() {
		return takmicar;
	}

	public void setTakmicar(Takmicar takmicar) {
		this.takmicar = takmicar;
	}

	@Override
	public String toString() {
		return "Prijava [id=" + id + ", datumPrijave=" + datumPrijave + ", disciplina=" + disciplina + ", takmicar="
				+ takmicar + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Prijava other = (Prijava) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
