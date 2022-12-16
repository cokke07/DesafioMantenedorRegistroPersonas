package cl.cokke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cokke.model.Persona;
import cl.cokke.repository.PersonaRepository;
import cl.cokke.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public List<Persona> listarPersonas() {
		return personaService.buscarTotdos();
	}
	
}
