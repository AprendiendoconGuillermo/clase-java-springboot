package org.spring.boot.entities.security.response;

import org.spring.boot.entities.security.ModuleEntity;

import lombok.Data;

@Data
public class ModuleEntityResponse {

	
	private String nombre;
	private String descripcion;
	
	public ModuleEntityResponse(ModuleEntity m) {
		this.nombre = m.getNombre();
		this.descripcion = m.getDescripcion();
	}
}
