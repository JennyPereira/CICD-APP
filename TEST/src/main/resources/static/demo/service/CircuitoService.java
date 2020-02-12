package com.demo.service;

import java.util.List;

import com.demo.entities.CircuitoEntidad;

public interface CircuitoService {

	public List<CircuitoEntidad> findByDistrito(Long id);
}
