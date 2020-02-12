package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.SubcircuitoRepository;
import com.demo.entities.SubCircuitoEntidad;

@Service("subcircuitoService")
public class SubcircuitoServiceImpl implements SubcircuitoService{

	@Autowired
	private SubcircuitoRepository subcircuitoRepository;
	@Override
	public List<SubCircuitoEntidad> findByCircuto(Long id) {
		return subcircuitoRepository.findByCircuito(id);
	}


}
