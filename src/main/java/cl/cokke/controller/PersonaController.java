package cl.cokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import cl.cokke.model.Persona;
import cl.cokke.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("personas", personaService.buscarTotdos());
		return "index";
	}
	
	@PostMapping("/create")
	public RedirectView crearPersona(@ModelAttribute Persona p) {
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombres(p.getNombres());
		nuevaPersona.setApellidoPaterno(p.getApellidoPaterno());
		nuevaPersona.setApellidoMaterno(p.getApellidoMaterno());
		nuevaPersona.setDireccionCalle(p.getDireccionCalle());
		
		personaService.agregarPersona(nuevaPersona);
		
		return new RedirectView("/");
	}
}
