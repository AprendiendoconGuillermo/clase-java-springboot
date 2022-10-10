package org.spring.boot.util;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AuditorFieldsEntity {

	@Column(name = "id_user_created", nullable = false, length = 11)
	private Integer idUserCreated;
	
	@Column(name = "date_created", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "id_user_update", nullable = true, length = 11)
	private Integer idUserUpdate;
	
	@Column(name = "date_update", nullable = true)
	private LocalDateTime dateUpdate;
	
	@Column(name = "id_user_delete", nullable = true, length = 11)
	private Integer idUserDelete;
	
	@Column(name = "date_delete", nullable = true)
	private LocalDateTime dateDelete;
	
	@Column(name = "status", nullable = true, length = 2)
	private String estado;//A: activo, I: inactivo, E: eliminado
}
