package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.dto.PrijavaDTO;
import com.ftninformatika.jwd.modul3.test.model.Prijava;
import com.ftninformatika.jwd.modul3.test.model.Takmicar;

@Component
public class PrijavaToPrijavaDto implements Converter<Prijava, PrijavaDTO>{
	
	@Autowired
	private TakmicarToTakmicarDto toTakmicarDto;
	
public PrijavaDTO convert(Prijava prijava) {
		
		PrijavaDTO dto = new PrijavaDTO();
		dto.setId(prijava.getId());
		dto.setDisciplina(prijava.getDisciplina());;
		dto.setDatumPrijave(prijava.getDatumPrijave().toString());
		dto.setTakmicar(toTakmicarDto.convert(prijava.getTakmicar()));
		return dto;
	}
	
	public List<PrijavaDTO> convert(List<Prijava> prijave) {
		List<PrijavaDTO> prijaveDto = new ArrayList<>();
		for(Prijava prijava: prijave) {
			prijaveDto.add(convert(prijava));
		}
		return prijaveDto;
	}

}
