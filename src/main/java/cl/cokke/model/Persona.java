package cl.cokke.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_persona" )
	private Long id;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name= "calle")
	private String direccionCalle;
	
	//@Enumerated(EnumType.ORDINAL)
	//private Comuna direccionComuna;
	
	@Enumerated(EnumType.ORDINAL)
	private Region direccionRegion;
	/*
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;
	*/
	@Column(name= "email")
	private String email;
	
	@Column(name="telefono")
	private String telefono;
	
}
