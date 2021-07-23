package com.ftninformatika.jwd.modul3.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.dto.DrzavaDTO;
import com.ftninformatika.jwd.modul3.test.model.Drzava;
import com.ftninformatika.jwd.modul3.test.service.DrzavaService;
import com.ftninformatika.jwd.modul3.test.support.DrzavaToDrzavaDto;

@RestController
@RequestMapping(value="/api/drzave", produces = MediaType.APPLICATION_JSON_VALUE)
public class DrzavaController {

	@Autowired
	private DrzavaService drzavaService;
	
	@Autowired
	private DrzavaToDrzavaDto toDrzavaDto;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<DrzavaDTO>> getAll() {
		List<Drzava> drzave = drzavaService.findAll();
		
		return new ResponseEntity<>(toDrzavaDto.convert(drzave), HttpStatus.OK);
	}
	
}
