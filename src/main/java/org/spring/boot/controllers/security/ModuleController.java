package org.spring.boot.controllers.security;

import static org.spring.boot.util.MessageUtil.OK;
import static org.spring.boot.util.MessageUtil.INGRESENOMBRE;

import org.spring.boot.entities.response.OutputEntity;
import org.spring.boot.entities.security.request.ModuleEntityRequest;
import org.spring.boot.exception.MyException;
import org.spring.boot.services.security.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@GetMapping("/holaMundo/{nombre}")
	public ResponseEntity<OutputEntity<String>> holaMundo(@PathVariable String nombre) {
		OutputEntity<String> out = new OutputEntity<>();
		try {
			if (nombre.equals("Guuillermo"))
				throw new MyException(INGRESENOMBRE.getKey(), INGRESENOMBRE.getCode());

			out.done(OK.getCode(), OK.getKey(), nombre);

			return new ResponseEntity<OutputEntity<String>>(out, out.getCode());
		} catch (MyException e) {
			out.failed(e.getCode(), e.getMessages(), null);
			return new ResponseEntity<OutputEntity<String>>(out, out.getCode());
		} catch (Exception e) {
			out.error();
			return new ResponseEntity<OutputEntity<String>>(out, out.getCode());
		}
	}

	@PostMapping("/insertModule")
	public ResponseEntity<OutputEntity<String>> insertModule(@RequestBody ModuleEntityRequest entityRequest) {
		OutputEntity<String> out = null;
		try {

			out = this.moduleService.insertModule(entityRequest);

			return new ResponseEntity<OutputEntity<String>>(out, out.getCode());

		} catch (Exception e) {
			out.error();
			return new ResponseEntity<OutputEntity<String>>(out, out.getCode());
		}
	}
}
//  http://localhost:9000/api-curso/module/holaMundo