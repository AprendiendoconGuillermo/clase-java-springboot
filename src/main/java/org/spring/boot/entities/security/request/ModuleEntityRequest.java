package org.spring.boot.entities.security.request;

import lombok.Data;

@Data
public class ModuleEntityRequest {

	private Integer idUser;
	private String nombre;
	private String descripcion;
}
