package com.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Distrito;

@Repository("distritoRepository")
public interface DistritoRepository extends CrudRepository<Distrito, Long> {
	
}