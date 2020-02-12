package com.demo.service;

import com.demo.entities.Distrito;

public interface DistritoService {

	public Iterable<Distrito> findAll();
	
	public Distrito find(Long id);

}
