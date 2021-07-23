package com.ftninformatika.jwd.modul3.test.service;

import com.ftninformatika.jwd.modul3.test.model.Prijava;

public interface PrijavaService {

	
	Prijava findOne(Long id);

	Prijava prijavi(Prijava prijava);
}
