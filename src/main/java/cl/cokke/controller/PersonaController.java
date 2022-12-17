package cl.cokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}
