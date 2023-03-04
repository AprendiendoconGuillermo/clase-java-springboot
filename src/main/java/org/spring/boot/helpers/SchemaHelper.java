package org.spring.boot.helpers;

import static org.spring.boot.util.MessageUtil.JSONSCHEMA;
import static org.spring.boot.util.MessageUtil.CHECKREQUEST;
import static org.spring.boot.util.MessageUtil.BADREQUEST;
import static org.spring.boot.util.MessageUtil.INTERNALERROR;

import java.util.ArrayList;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.spring.boot.exception.MyException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SchemaHelper {

	private ArrayList<String> errorMessage;
	
	/**
	 * Método que leer el json schema y devuelve una represnetacion de shcema
	 * validator
	 * 
	 * @param path
	 * @return
	 * @throws MyException
	 */
	private Schema readJsonSchema(String path) throws MyException {
		try {
			JSONObject object = new JSONObject(new JSONTokener(SchemaHelper.class.getResourceAsStream(path)));
			return SchemaLoader.load(object);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(JSONSCHEMA.getKey(), JSONSCHEMA.getCode());
		}

	}

	public <T> void validateJsonSchmea(String ruta, T entidad) throws MyException {
		try {
			Schema schema = this.readJsonSchema(ruta);
			String json = new ObjectMapper().writeValueAsString(entidad);
			schema.validate(new JSONObject(json));

		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			this.errorMessage.add(CHECKREQUEST.getKey());
			if (e.getCausingExceptions().size() > 0) {
				for (ValidationException ee : e.getCausingExceptions()) {
					this.errorMessage.add(ee.getMessage());
					System.out.println(ee.toString());
				}
			} else {
				System.out.println(e.toString());
				this.errorMessage.add(e.toString());
			}
			throw new MyException(errorMessage, CHECKREQUEST.getCode());
		} catch (MyException e) {
			System.out.println(e.getMessage());
			this.errorMessage.add(BADREQUEST.getKey());			
			throw new MyException(e.getMessage(), e.getCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(INTERNALERROR.getKey(), INTERNALERROR.getCode());
		}

	}
}
