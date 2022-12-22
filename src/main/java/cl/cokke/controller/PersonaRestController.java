package cl.cokke.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> buscarPersonaPorId(@PathVariable("id") Long id){
		
		Optional<Persona> personaEncontrada = ps.buscarPorId(id);
		
		if(personaEncontrada.isPresent()) {
			return new ResponseEntity<>(personaEncontrada.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable("id") Long id, @RequestBody Persona p){
		Optional<Persona> personaEncontrada = ps.buscarPorId(id);
		
		if(personaEncontrada.isPresent()) {
			
			personaEncontrada.get().setNombres(p.getNombres());
			personaEncontrada.get().setApellidoPaterno(p.getApellidoPaterno());
			personaEncontrada.get().setApellidoMaterno(p.getApellidoMaterno());
			personaEncontrada.get().setFechaNacimiento(p.getFechaNacimiento());
			personaEncontrada.get().setEmail(p.getEmail());
			personaEncontrada.get().setDireccionCalle(p.getDireccionCalle());
			personaEncontrada.get().setDireccionRegion(p.getDireccionRegion());
			personaEncontrada.get().setFechaNacimiento(p.getFechaNacimiento());
						
			return new ResponseEntity<>(ps.actualizarPersona(personaEncontrada.get()),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
}
