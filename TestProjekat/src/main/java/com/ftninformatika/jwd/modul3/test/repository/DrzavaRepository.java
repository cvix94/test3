package com.ftninformatika.jwd.modul3.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Drzava;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Long>{

	Drzava findOneById(Long id);

}
