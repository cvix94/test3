package com.ftninformatika.jwd.modul3.test.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.dto.TakmicarDTO;
import com.ftninformatika.jwd.modul3.test.model.Takmicar;
import com.ftninformatika.jwd.modul3.test.service.DrzavaService;
import com.ftninformatika.jwd.modul3.test.service.TakmicarService;

@Component
public class TakmicarDtoToTakmicar implements Converter<TakmicarDTO, Takmicar>{

	@Autowired
	private TakmicarService takmicarService;
	
	@Autowired
	private DrzavaService drzavaService;
	
    @Override
    public Takmicar convert(TakmicarDTO dto) {
        Takmicar takmicar;

        if(dto.getId() == null){
            takmicar = new Takmicar();
        }else{
            takmicar = takmicarService.findOne(dto.getId());
        }

        if(takmicar != null){
            takmicar.setImePrezime(dto.getImePrezime());;
            takmicar.setBrojMedalja(dto.getBrojMedalja());
            takmicar.setDatumRodjenja(getLocalDateTime(dto.getDatumRodjenja()));
            takmicar.setDrzava(drzavaService.findOne(dto.getDrzava().getId()));
        }
        return takmicar;
    }

    private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }
	
}
