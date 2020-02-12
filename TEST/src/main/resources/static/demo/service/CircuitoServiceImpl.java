package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CircuitoRepository;
import com.demo.entities.CircuitoEntidad;

@Service("circuitoService")
public class CircuitoServiceImpl implements CircuitoService{

	@Autowired
	private CircuitoRepository circuitoRepository;
	
	@Override
	public List<CircuitoEntidad> findByDistrito(Long id) {
		return circuitoRepository.findByDistrito(id);
	}

	

}
