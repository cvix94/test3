package com.ftninformatika.jwd.modul3.test.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Takmicar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String imePrezime;
	
	@Column
	private Integer brojMedalja;
	
	@Column(nullable = false)
	private LocalDateTime datumRodjenja;
	
	@ManyToOne
	private Drzava drzava;
	
	@OneToMany(mappedBy = "takmicar", cascade = CascadeType.ALL)
	private List<Prijava> prijave = new ArrayList<>();

	public Takmicar() {
		super();
	}

	public Takmicar(Long id, String imePrezime, Integer brojMedalja, LocalDateTime datumRodjenja, Drzava drzava,
			List<Prijava> prijave) {
		super();
		this.id = id;
		this.imePrezime = imePrezime;
		this.brojMedalja = brojMedalja;
		this.datumRodjenja = datumRodjenja;
		this.drzava = drzava;
		this.prijave = prijave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public Integer getBrojMedalja() {
		return brojMedalja;
	}

	public void setBrojMedalja(Integer brojMedalja) {
		this.brojMedalja = brojMedalja;
	}

	public LocalDateTime getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDateTime datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	public List<Prijava> getPrijave() {
		return prijave;
	}

	public void setPrijave(List<Prijava> prijave) {
		this.prijave = prijave;
	}

	@Override
	public String toString() {
		return "Takmicar [id=" + id + ", imePrezime=" + imePrezime + ", brojMedalja=" + brojMedalja + ", datumRodjenja="
				+ datumRodjenja + ", drzava=" + drzava + ", prijave=" + prijave + "]";
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
		Takmicar other = (Takmicar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
