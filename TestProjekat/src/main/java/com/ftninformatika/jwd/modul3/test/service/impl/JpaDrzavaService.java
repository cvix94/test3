package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Drzava;
import com.ftninformatika.jwd.modul3.test.repository.DrzavaRepository;
import com.ftninformatika.jwd.modul3.test.service.DrzavaService;
import com.ftninformatika.jwd.modul3.test.service.TakmicarService;

@Service
public class JpaDrzavaService implements DrzavaService{

	@Autowired
	private DrzavaRepository drzavaRepository;
	
	@Autowired
	private TakmicarService takmicarService;
	
	@Override
	public List<Drzava> findAll() {
		// TODO Auto-generated method stub
		return drzavaRepository.findAll();
	}

	@Override
	public Drzava findOne(Long id) {
		// TODO Auto-generated method stub
		return drzavaRepository.findOneById(id);
	}

	@Override
	public List<Drzava> izracunajMedalje(Long takmicarId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Drzava> izracunajMedalje() {
//		int sumaMedalja = 0;
//		List<Drzava> drzave = drzavaRepository.findAll();
//		for(Drzava d: drzave) {
//		}
//		return null;
//	}

}
