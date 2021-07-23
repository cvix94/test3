package com.ftninformatika.jwd.modul3.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Takmicar;

@Repository
public interface TakmicarRepository extends JpaRepository<Takmicar, Long> {

	Takmicar findOneById(Long id);

	Page<Takmicar> findByBrojMedaljaBetween(Integer brojMedaljaOd, Integer brojMedaljaDo, Pageable pageable);

	Page<Takmicar> findByBrojMedaljaBetweenAndDrzavaId(Integer brojMedaljaOd, Integer brojMedaljaDo, Long drzavaId,
			Pageable pageable);

}
