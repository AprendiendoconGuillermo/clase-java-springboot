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
@Table(name = "sgi_module_t_option")
public class ModuleOptionEntity extends AuditorFieldsEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_module_option", nullable = false, unique = true, updatable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_module", nullable = false)
	private ModuleEntity idModule;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_option", nullable = false)
	private OptionEntity idOption;
}
