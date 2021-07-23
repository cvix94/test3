package com.ftninformatika.jwd.modul3.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drzava {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@Column(unique = true)
	private String oznaka;
	
	@OneToMany(mappedBy = "drzava", cascade = CascadeType.ALL)
	private List<Takmicar> takmicari = new ArrayList<>();

	public Drzava() {
		super();
	}

	public Drzava(Long id, String naziv, String oznaka, List<Takmicar> takmicari) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.oznaka = oznaka;
		this.takmicari = takmicari;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public List<Takmicar> getTakmicari() {
		return takmicari;
	}

	public void setTakmicari(List<Takmicar> takmicari) {
		this.takmicari = takmicari;
	}

	@Override
	public String toString() {
		return "Drzava [id=" + id + ", naziv=" + naziv + ", oznaka=" + oznaka + ", takmicari=" + takmicari + "]";
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
		Drzava other = (Drzava) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
