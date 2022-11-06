package org.spring.boot.entities.security;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.spring.boot.entities.security.request.ModuleEntityRequest;
import org.spring.boot.util.AuditorFieldsEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sgi_module")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleEntity extends AuditorFieldsEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_module", nullable = false, unique = true, updatable = false)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 255, unique = true)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false, length = 255, unique = true)
	private String descripcion;		
	
	public ModuleEntity(ModuleEntityRequest e) {
		this.nombre = e.getNombre();
		this.descripcion = e.getDescripcion();		
		this.setEstado("A");
		this.setDateCreated(LocalDateTime.now());
		this.setIdUserCreated(e.getIdUser());
	}
}
