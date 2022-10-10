package org.spring.boot.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.boot.util.AuditorFieldsEntity;

@Entity
@Table(name = "sgi_profile")
public class ProfileEntity extends AuditorFieldsEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile", updatable = false, nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 255, unique = true)
	private String nombre;
	
	@Column(name = "description", nullable = false, length = 255)
	private String descripcion;
}
