package com.examenparcial.examenparcial.service;

import com.examenparcial.examenparcial.model.Alumno;
import com.examenparcial.examenparcial.repository.IAlumnoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService implements IAlumnoService {

  @Autowired
  private IAlumnoRepository alumnoRepository;

  public AlumnoService() {}

  public List<Alumno> getAlumnos() {
    return (List<Alumno>) alumnoRepository.findAll();
  }

  public Alumno getAlumnoById(int id) {
    return alumnoRepository.findById(id).orElse(null);
  }

  public Alumno saveAlumno(Alumno alumno) {
    return alumnoRepository.save(alumno);
  }

  public Alumno updateAlumno(Alumno alumno) {
    return alumnoRepository.save(alumno);
  }

  public boolean deleteAlumno(int id) {
    Optional<Alumno> alumno = alumnoRepository.findById(id);
    if (alumno.isPresent()) {
      alumnoRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
