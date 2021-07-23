package com.ftninformatika.jwd.modul3.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.dto.PrijavaDTO;
import com.ftninformatika.jwd.modul3.test.model.Prijava;
import com.ftninformatika.jwd.modul3.test.service.PrijavaService;
import com.ftninformatika.jwd.modul3.test.support.PrijavaDtoToPrijava;
import com.ftninformatika.jwd.modul3.test.support.PrijavaToPrijavaDto;

@RestController
@RequestMapping(value="api/prijave", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrijavaController {
	
	@Autowired
	private PrijavaToPrijavaDto toPrijavaDto;
	
	@Autowired
	private PrijavaDtoToPrijava toPrijava;
	
	@Autowired
	private PrijavaService prijavaService;

	
	  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity <PrijavaDTO> create(@Valid @RequestBody PrijavaDTO prijavaDto) {
	    	Prijava prijava = toPrijava.convert(prijavaDto);
	    	Prijava sacuvanaRezervacija = prijavaService.prijavi(prijava);
	    	
	    	if(sacuvanaRezervacija == null) {
	    		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    	}
	    	
	    	return new ResponseEntity<>(toPrijavaDto.convert(sacuvanaRezervacija), HttpStatus.CREATED);
	    }
}
