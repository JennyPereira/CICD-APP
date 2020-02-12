package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.SubCircuito;
import com.demo.entities.SubCircuitoEntidad;

@Repository("subcircuitoRepository")
public interface SubcircuitoRepository extends CrudRepository<SubCircuito, Long>{
	
	@Query("select new com.example.demo.entities.SubCircuitoEntidad(id, codigo, nombre, mediosLogistica) from SubCircuito where circuito.id = :id")
	public List<SubCircuitoEntidad> findByCircuito(@Param("id")Long id);
}
