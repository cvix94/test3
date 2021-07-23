package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.dto.TakmicarDTO;
import com.ftninformatika.jwd.modul3.test.model.Takmicar;

@Component
public class TakmicarToTakmicarDto implements Converter<Takmicar, TakmicarDTO>{

	@Autowired
	private DrzavaToDrzavaDto toDrzavaDto;
	
public TakmicarDTO convert(Takmicar takmicar) {
		
		TakmicarDTO dto = new TakmicarDTO();
		dto.setId(takmicar.getId());
		dto.setImePrezime(takmicar.getImePrezime());
		dto.setBrojMedalja(takmicar.getBrojMedalja());
		dto.setDatumRodjenja(takmicar.getDatumRodjenja().toString());
		dto.setDrzava(toDrzavaDto.convert(takmicar.getDrzava()));
		return dto;
	}
	
	public List<TakmicarDTO> convert(List<Takmicar> takmicari) {
		List<TakmicarDTO> takmicariDto = new ArrayList<>();
		for(Takmicar takmicar: takmicari) {
			takmicariDto.add(convert(takmicar));
		}
		return takmicariDto;
	}
}
