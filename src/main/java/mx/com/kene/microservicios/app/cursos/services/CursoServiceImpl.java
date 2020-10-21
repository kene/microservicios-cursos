package mx.com.kene.microservicios.app.cursos.services;

import org.springframework.stereotype.Service;

import mx.com.kene.microservicios.app.cursos.models.entity.Curso;
import mx.com.kene.microservicios.app.cursos.models.repository.CursoRepository;
import mx.com.kene.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {



}
