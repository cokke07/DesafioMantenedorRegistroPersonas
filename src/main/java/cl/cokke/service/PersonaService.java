package cl.cokke.service;

import java.util.List;

import cl.cokke.model.Persona;

public interface PersonaService {

	public List<Persona> buscarTotdos();
	public Persona agregarPersona(Persona p);
}
