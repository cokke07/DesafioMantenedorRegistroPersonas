package cl.cokke.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cokke.model.Persona;
import cl.cokke.service.PersonaService;

@RestController
@RequestMapping("/api")
public class PersonaRestController {

	@Autowired
	PersonaService ps;
	
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> AllPersonas(){
		
		return new ResponseEntity<>(ps.buscarTotdos(),HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona p) {
		
		return new ResponseEntity<>(ps.agregarPersona(p),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<HttpStatus> eliminarTotalRegistros(){
		
		return new ResponseEntity<>(ps.eliminarPersonas(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> eliminarPersonaPorId(@PathVariable("id") Long id){
		return new ResponseEntity<>(ps.eliminarPersona(id),HttpStatus.OK);
	}
}
