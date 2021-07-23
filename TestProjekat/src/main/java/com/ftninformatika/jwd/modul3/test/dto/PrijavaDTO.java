package com.ftninformatika.jwd.modul3.test.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.ftninformatika.jwd.modul3.test.model.Takmicar;

public class PrijavaDTO {

	
	private Long id;
	

	private String datumPrijave;
	
	private String disciplina;
	
	private TakmicarDTO takmicar;

	public PrijavaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(String datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public TakmicarDTO getTakmicar() {
		return takmicar;
	}

	public void setTakmicar(TakmicarDTO takmicarDTO) {
		this.takmicar = takmicarDTO;
	}
	
	
}
