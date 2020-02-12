package com.demo.entities;

import java.io.Serializable;

public class SubCircuitoEntidad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String nombre;
	private int mediosLogistica;

	public SubCircuitoEntidad(){
	}

	public SubCircuitoEntidad(Long id, String codigo, String nombre, int mediosLogistica) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.mediosLogistica = mediosLogistica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMediosLogistica() {
		return mediosLogistica;
	}

	public void setMediosLogistica(int mediosLogistica) {
		this.mediosLogistica = mediosLogistica;
	}

}
