package cl.cokke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import cl.cokke.model.Persona;

public interface PersonaService {

	public List<Persona> buscarTotdos();
	public Persona agregarPersona(Persona p);
	public HttpStatus eliminarPersonas();
	public HttpStatus eliminarPersona(Long id);
	public Optional<Persona> buscarPorId(Long id);
}
