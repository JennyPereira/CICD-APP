package com.demo.service;

import java.util.List;

import com.demo.entities.SubCircuitoEntidad;

public interface SubcircuitoService {
	
	public List<SubCircuitoEntidad> findByCircuto(Long id);

}
