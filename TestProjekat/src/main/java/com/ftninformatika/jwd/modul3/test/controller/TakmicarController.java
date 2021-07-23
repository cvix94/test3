package com.ftninformatika.jwd.modul3.test.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.dto.TakmicarDTO;
import com.ftninformatika.jwd.modul3.test.model.Takmicar;
import com.ftninformatika.jwd.modul3.test.service.TakmicarService;
import com.ftninformatika.jwd.modul3.test.support.TakmicarDtoToTakmicar;
import com.ftninformatika.jwd.modul3.test.support.TakmicarToTakmicarDto;

@RestController
@RequestMapping(value="/api/takmicari", produces = MediaType.APPLICATION_JSON_VALUE)
public class TakmicarController {

	
	@Autowired
	private TakmicarService takmicarService;
	
	@Autowired
	private TakmicarToTakmicarDto toTakmicarDto;
	
	@Autowired
	private TakmicarDtoToTakmicar toTakmicar;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<TakmicarDTO>> getAll(@RequestParam(required = false) Long drzavaId,
			@RequestParam(required = false) Integer brojMedaljaOd, @RequestParam(required = false) Integer brojMedaljaDo,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Takmicar> page = null;
		
		if(drzavaId != null || brojMedaljaOd !=null || brojMedaljaDo != null) {
			page = takmicarService.find(drzavaId, brojMedaljaOd, brojMedaljaDo, pageNo);
		} else {
			page = takmicarService.findAll(pageNo);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toTakmicarDto.convert(page.getContent()), headers, HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicarDTO> create(@Valid @RequestBody TakmicarDTO takmicarDto) {
		
		Takmicar takmicar = toTakmicar.convert(takmicarDto);
		Takmicar savedTakmicar = takmicarService.save(takmicar);
		
		return new ResponseEntity<>(toTakmicarDto.convert(savedTakmicar), HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping(value="/{id}")
	public ResponseEntity<TakmicarDTO> getOne(@PathVariable Long id) {
		
		Takmicar takmicar = takmicarService.findOne(id);
		
		if(takmicar != null) {
			return new ResponseEntity<>(toTakmicarDto.convert(takmicar), HttpStatus.OK);	
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TakmicarDTO> update(@PathVariable Long id, @Valid @RequestBody TakmicarDTO takmicarDto) {
		
		
		if(!id.equals(takmicarDto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Takmicar takmicar = toTakmicar.convert(takmicarDto);
		Takmicar sacuvanaTakmicar = takmicarService.update(takmicar);
		
		return new ResponseEntity<>(toTakmicarDto.convert(sacuvanaTakmicar), HttpStatus.OK);
		
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Takmicar obrisanaTakmicar = takmicarService.delete(id);
		
		if(obrisanaTakmicar != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
