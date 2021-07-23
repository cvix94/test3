package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.test.model.Drzava;

public interface DrzavaService {

	List<Drzava> findAll();
	
	Drzava findOne(Long id);
	
	List<Drzava> izracunajMedalje(Long takmicarId);
	
}
