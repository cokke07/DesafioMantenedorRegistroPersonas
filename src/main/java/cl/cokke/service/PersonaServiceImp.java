package cl.cokke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@Override
	public HttpStatus eliminarPersonas() {
		pr.deleteAll();
		return HttpStatus.OK;
	}

	@Override
	public HttpStatus eliminarPersona(Long id) {
		
		if(pr.findById(id).isPresent()) {
			pr.deleteById(id);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public Optional<Persona> buscarPorId(Long id) {
		
		return pr.findById(id);
	}

}
