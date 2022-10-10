package org.spring.boot.services.security;

import static org.spring.boot.util.MessageUtil.CREATED;
import static org.spring.boot.util.MessageUtil.BADREQUEST;
import static org.spring.boot.util.MessageUtil.MODULOEXIST;

import org.spring.boot.entities.response.OutputEntity;
import org.spring.boot.entities.security.ModuleEntity;
import org.spring.boot.entities.security.request.ModuleEntityRequest;
import org.spring.boot.exception.MyException;
import org.spring.boot.repositories.security.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public OutputEntity<String> insertModule(ModuleEntityRequest en) {
		OutputEntity<String> out = new OutputEntity<>();
		try {
			Integer x = this.moduleRepository.existeModulo(en.getNombre(), en.getDescripcion());//1-0
			
			if(x==1)
				throw new MyException(MODULOEXIST.getKey(), MODULOEXIST.getCode());
			
			ModuleEntity e = new ModuleEntity(en);

			this.moduleRepository.save(e);

			return out.done(CREATED.getCode(), CREATED.getKey(), null);
		} catch (DataIntegrityViolationException e) {			
			return out.failed(BADREQUEST.getCode(), e.getMessage(), null);
		} catch (MyException e) {
			return out.failed(e.getCode(), e.getMessages(), null);
		}catch (Exception e) {
			return out.error();
		}
	}
}
