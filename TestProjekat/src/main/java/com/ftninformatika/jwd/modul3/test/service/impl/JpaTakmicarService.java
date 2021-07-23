package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Takmicar;
import com.ftninformatika.jwd.modul3.test.repository.TakmicarRepository;
import com.ftninformatika.jwd.modul3.test.service.TakmicarService;

@Service
public class JpaTakmicarService implements TakmicarService{

	@Autowired
	private TakmicarRepository takmicarRepository;
	
	@Override
	public Page<Takmicar> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return takmicarRepository.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Takmicar findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicarRepository.findOneById(id);
	}

	@Override
	public Takmicar save(Takmicar takmicar) {
		// TODO Auto-generated method stub
		return takmicarRepository.save(takmicar);
	}

	@Override
	public Takmicar update(Takmicar takmicar) {
		// TODO Auto-generated method stub
		return takmicarRepository.save(takmicar);
	}

	@Override
	public Takmicar delete(Long id) {
		Optional<Takmicar> takmicar = takmicarRepository.findById(id);
		if(takmicar.isPresent()) {
			takmicarRepository.deleteById(id);
			return takmicar.get();
		}
		return null;
	}

	@Override
	public Page<Takmicar> find(Long drzavaId, Integer brojMedaljaOd, Integer brojMedaljaDo, int pageNo) {
		if(brojMedaljaOd == null) {
			brojMedaljaOd = 0;
		}
		if(brojMedaljaDo == null) {
			brojMedaljaDo = Integer.MAX_VALUE;
		}
		if(drzavaId == null) {
			return takmicarRepository.findByBrojMedaljaBetween(brojMedaljaOd, brojMedaljaDo, PageRequest.of(pageNo,5));
		}
		return takmicarRepository.findByBrojMedaljaBetweenAndDrzavaId(brojMedaljaOd, brojMedaljaDo, drzavaId, PageRequest.of(pageNo,5));
	}

}
