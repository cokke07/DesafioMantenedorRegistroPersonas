package cl.cokke.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import cl.cokke.model.Persona;

public interface PersonaService {

	public List<Persona> buscarTotdos();
	public Persona agregarPersona(Persona p);
	public HttpStatus eliminarPersonas();
}
