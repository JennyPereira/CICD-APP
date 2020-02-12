package com.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="circuito")
public class Circuito implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String nombre;
	private Distrito distrito;
	private Set<SubCircuito> subcircuitos = new HashSet<SubCircuito>(0);
	
	public Circuito() {
	}
	
	public Circuito(String nombre, Distrito distrito) {
		this.nombre=nombre;
		this.distrito=distrito;
	}
	
	public Circuito(String codigo, String nombre, Distrito distrito, Set<SubCircuito> subcircuitos){
		this.codigo=codigo;
		this.nombre=nombre;
		this.distrito=distrito;
		this.subcircuitos=subcircuitos;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distrito", nullable = false)
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "circuito")
	public Set<SubCircuito> getSubcircuitos() {
		return subcircuitos;
	}

	public void setSubcircuitos(Set<SubCircuito> subcircuitos) {
		this.subcircuitos = subcircuitos;
	}
	
}
