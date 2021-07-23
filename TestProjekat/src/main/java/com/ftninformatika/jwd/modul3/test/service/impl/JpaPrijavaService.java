package com.ftninformatika.jwd.modul3.test.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Prijava;
import com.ftninformatika.jwd.modul3.test.repository.PrijavaRepository;
import com.ftninformatika.jwd.modul3.test.service.PrijavaService;

@Service
public class JpaPrijavaService implements PrijavaService {

	@Autowired
	private PrijavaRepository prijavaRepository;
	
	@Override
	public Prijava findOne(Long id) {
		// TODO Auto-generated method stub
		return prijavaRepository.findOneById(id);
	}

	@Override
	public Prijava prijavi(Prijava prijava) {
		prijava.setDatumPrijave(LocalDateTime.now());
		return prijavaRepository.save(prijava);
	}

}
