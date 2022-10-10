package org.spring.boot.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.spring.boot.util.AuditorFieldsEntity;

@Entity
@Table(name = "sgi_user_r_profile")
public class UserProfileEntity extends AuditorFieldsEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_profile", updatable = false, nullable = false, unique = true)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_profile", nullable = false)
	private ProfileEntity idProfile;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_user", nullable = false)
	private UserEntity idUser;	
}
