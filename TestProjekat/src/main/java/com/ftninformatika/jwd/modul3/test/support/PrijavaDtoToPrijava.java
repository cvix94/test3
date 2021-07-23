package com.ftninformatika.jwd.modul3.test.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.dto.PrijavaDTO;
import com.ftninformatika.jwd.modul3.test.model.Prijava;
import com.ftninformatika.jwd.modul3.test.service.PrijavaService;
import com.ftninformatika.jwd.modul3.test.service.TakmicarService;

@Component
public class PrijavaDtoToPrijava implements Converter<PrijavaDTO, Prijava>{

	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private TakmicarService takmicarService;
	
    @Override
    public Prijava convert(PrijavaDTO dto) {
        Prijava prijava;

        if(dto.getId() == null){
            prijava = new Prijava();
        }else{
            prijava = prijavaService.findOne(dto.getId());
        }

        if(prijava != null){
            prijava.setId(dto.getId());
            prijava.setDisciplina(dto.getDisciplina());
            prijava.setDatumPrijave(getLocalDateTime(dto.getDatumPrijave()));
            prijava.setTakmicar(takmicarService.findOne(dto.getTakmicar().getId()));
        }
        return prijava;
    }
    
    private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }
}
