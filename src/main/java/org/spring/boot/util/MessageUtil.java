package org.spring.boot.util;

import lombok.Getter;

@Getter
public enum MessageUtil {

	OK("Proceso exitoso.", 200),
	CREATED("Creación exitosa.", 201), 
	UPDATED("Actualización exitosa.", 200), 
	DELETED("Eliminación exitosa.", 200), 
	BADREQUEST("Hubo un error en su petición.", 400),
	NOTFOUND("No existen registros.", 404),
	INTERNALERROR("Error en el servidor.", 500),
	
	CONFLICT("Hubo un conflicto en su petición.", 409),
	MODULOEXIST("Ya existe un registro con estos datos.", 409),
	
	INGRESENOMBRE("Por favor ingrese su nombre.", 400),
	;
	
	private String key;
	private int code;
	
	private MessageUtil(String key, int code) {
		this.key = key;
		this.code = code;
	}
}
