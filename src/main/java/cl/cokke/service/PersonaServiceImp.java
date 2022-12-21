package cl.cokke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.cokke.model.Persona;
import cl.cokke.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService {

	@Autowired
	PersonaRepository pr;
	
	@Override
	public List<Persona> buscarTotdos() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Persona agregarPersona(Persona p) {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

}
