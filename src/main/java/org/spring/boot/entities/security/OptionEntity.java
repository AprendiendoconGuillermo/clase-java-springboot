package org.spring.boot.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.boot.util.AuditorFieldsEntity;

@Entity
@Table(name = "sgi_option")
public class OptionEntity extends AuditorFieldsEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_option", nullable = false, unique = true, updatable = false)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 255, unique = true)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false, length = 255, unique = true)
	private String descripcion;
}
