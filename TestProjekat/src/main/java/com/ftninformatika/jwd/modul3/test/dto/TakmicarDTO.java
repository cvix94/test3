package com.ftninformatika.jwd.modul3.test.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

public class TakmicarDTO {

	
	private Long id;
	
	@Length(max=60)
	private String imePrezime;
	
	@Positive
	private Integer brojMedalja;
	
	
	private String datumRodjenja;
	
	private DrzavaDTO drzava;

	public TakmicarDTO() {
		super();
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

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public DrzavaDTO getDrzava() {
		return drzava;
	}

	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}
	
	
}
