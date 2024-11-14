package com.examenparcial.examenparcial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.examenparcial.model.Alumno;
import com.examenparcial.examenparcial.repository.AlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{
  @Autowired
  private  AlumnoRepository alumnoRepository;

  public AlumnoService() {
    
  }

  public List<Alumno> getAlumnos() {
    return alumnoRepository.findAll();
  }

  public Alumno getAlumnoById(int id) {
    return alumnoRepository.findById(id).orElse(null);
  }

  public Alumno saveAlumno(Alumno alumno) {
    return alumnoRepository.save(alumno);
  }

  public Alumno updateAlumno(Alumno alumno) {
    if (alumnoRepository.findById(alumno.getId()) != null) {
        return alumnoRepository.save(alumno);
    } else {
        return null;
    }
}

// Eliminar un alumno por ID
public boolean deleteAlumno(int id) {
  Optional<Alumno> alumno = alumnoRepository.findById(id);
  if (alumno.isPresent()) {
      alumnoRepository.deleteById(id);  // Elimina el alumno si existe
      return true;  // Indica que fue eliminado
  }
  return false;  // Indica que no se encontró el alumno
}

}