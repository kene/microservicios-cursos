package mx.com.kene.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.kene.microservicios.app.cursos.models.entity.Curso;
import mx.com.kene.microservicios.app.cursos.services.CursoService;
import mx.com.kene.microservicios.commons.alumnos.model.entity.Alumno;
import mx.com.kene.microservicios.commons.controllers.CommonController;

@RestController
public class CursoController extends CommonController<Curso, CursoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
		
		Optional<Curso> o = this.service.findById(id);
		
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = o.get();
		cursoDb.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos,@PathVariable Long id){
		
		
		Optional<Curso> o = this.service.findById(id);
		
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = o.get();
		
		alumnos.forEach(a -> {
			cursoDb.addAlumno(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
		
	}
	
	
	@PutMapping("/{id}/eliminar-alumnos")
	public ResponseEntity<?> eliminarAlumnos(@RequestBody Alumno alumno,@PathVariable Long id){
		
		
		Optional<Curso> o = this.service.findById(id);
		
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoDb = o.get();
		
		cursoDb.removeAlumno(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDb));
		
	}
	
	
	
	
}
