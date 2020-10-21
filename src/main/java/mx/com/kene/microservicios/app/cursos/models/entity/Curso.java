package mx.com.kene.microservicios.app.cursos.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import mx.com.kene.microservicios.commons.alumnos.model.entity.Alumno;

@Entity
@Table(name = "cursos")
@Data
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	@OneToMany
	private List<Alumno> alumnos;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	

	public Curso() {
		this.alumnos = new ArrayList<>();
	}
	
	
	
	@PrePersist
	public void prePersist() {
			this.createAt = new Date();
	}
	
	
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}	
	
	public void removeAlumno(Alumno alumno) {
		this.alumnos.remove(alumno);
	}	
}
