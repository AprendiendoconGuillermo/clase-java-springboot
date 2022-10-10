package org.spring.boot.repositories.security;

import org.spring.boot.entities.security.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleEntity, Integer>{

	@Procedure("existe_modulo")
	Integer existeModulo(String nom, String des);
}
