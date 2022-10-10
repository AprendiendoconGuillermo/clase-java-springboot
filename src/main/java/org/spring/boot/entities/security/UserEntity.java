package org.spring.boot.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.boot.util.AuditorFieldsEntity;

@Entity
@Table(name = "sgi_user")
public class UserEntity extends AuditorFieldsEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", updatable = false, nullable = false, unique = true)
	private Integer id;

	@Column(name ="username", nullable = false, length = 255, unique = true)
	private String usuario;

	@Column(name ="password", nullable = false, length = 255)
	private String clave;	

}