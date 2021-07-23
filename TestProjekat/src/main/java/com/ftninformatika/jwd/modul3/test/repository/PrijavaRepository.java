package com.ftninformatika.jwd.modul3.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {

	Prijava findOneById(Long id);

}
