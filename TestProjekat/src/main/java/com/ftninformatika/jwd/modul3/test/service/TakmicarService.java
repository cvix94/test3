package com.ftninformatika.jwd.modul3.test.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Takmicar;

public interface TakmicarService {

	Page<Takmicar> findAll(int pageNo);
	
	Takmicar findOne(Long id);
	
	Takmicar save(Takmicar takmicar);
	
	Takmicar update(Takmicar takmicar);
	
	Takmicar delete(Long id);
	
	Page<Takmicar> find(Long drzavaId, Integer brojMedaljaOd, Integer brojMedaljaDo, int pageNo);
	
}
