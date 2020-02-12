package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DistritoRepository;
import com.demo.entities.Distrito;

@Service("distritoService")
public class DistritoServiceImpl implements DistritoService{

	@Autowired
	private DistritoRepository distritoRepository;
	
	@Override
	public Iterable<Distrito> findAll() {
		return distritoRepository.findAll();
	}

	@Override
	public Distrito find(Long id) {
		return distritoRepository.findById(id).get();
	}

}
