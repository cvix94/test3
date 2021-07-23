package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.dto.DrzavaDTO;
import com.ftninformatika.jwd.modul3.test.model.Drzava;

@Component
public class DrzavaToDrzavaDto implements Converter<Drzava, DrzavaDTO>{
	
public DrzavaDTO convert(Drzava drzava) {
		
		DrzavaDTO dto = new DrzavaDTO();
		dto.setId(drzava.getId());
		dto.setNaziv(drzava.getNaziv());
		dto.setOznaka(drzava.getOznaka());
		
		return dto;
	}
	
	public List<DrzavaDTO> convert(List<Drzava> drzave) {
		List<DrzavaDTO> drzaveDto = new ArrayList<>();
		for(Drzava drzava: drzave) {
			drzaveDto.add(convert(drzava));
		}
		return drzaveDto;
	}

}
