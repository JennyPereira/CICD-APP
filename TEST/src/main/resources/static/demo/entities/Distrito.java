package com.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String nombre;
	private Set<Circuito> circuitos = new HashSet<Circuito>(0);
	
	public Distrito() {
		
	}
	
	public Distrito(String codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
	}
	
	public Distrito(String codigo, String nombre, Set<Circuito> circuitos) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.circuitos=circuitos;
	}
	

	@Id //Columna primaria de la base de datos
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Generar ID's de objetos automaticamente para objetos de entidad sin campos de clave primaria definidos
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "codigo", nullable = false, length = 20)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distrito")
	public Set<Circuito> getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(Set<Circuito> circuitos) {
		this.circuitos = circuitos;
	}
	
}
