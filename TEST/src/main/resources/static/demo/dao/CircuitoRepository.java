package com.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Circuito;
import com.demo.entities.CircuitoEntidad;

@Repository("circuitoRepository")
public interface CircuitoRepository extends CrudRepository<Circuito, Long> {

	@Query("select new com.example.demo.entities.CircuitoEntidad(id,codigo,nombre) from Circuito where distrito.id = :id")
	public List<CircuitoEntidad> findByDistrito(@Param("id")Long id);

}