package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subcircuito")
public class SubCircuito implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String codigo;
	private String nombre;
	private int mediosLogistica;
	private Circuito circuito;
	
	public SubCircuito() {	
	}
	
	public SubCircuito(String codigo,String nombre, int mediosLogistica, Circuito circuito) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.mediosLogistica=mediosLogistica;
		this.circuito=circuito;
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

	@Column(name = "medios_logistica", nullable = false, length = 5)
	public int getMediosLogistica() {
		return mediosLogistica;
	}

	public void setMediosLogistica(int mediosLogistica) {
		this.mediosLogistica = mediosLogistica;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "circuito", nullable = false)
	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}
	
}
