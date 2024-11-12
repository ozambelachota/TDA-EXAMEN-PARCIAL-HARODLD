package com.examenparcial.examenparcial.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenparcial.examenparcial.domain.Alumno;
import com.examenparcial.examenparcial.infrastructure.repository.AlumnoRepository;

@Service
public class AlumnoService {
  @Autowired
  private  AlumnoRepository alumnoRepository;

  public AlumnoService() {
    
  }

  public List<Alumno> getAllAlumnos() {
    return alumnoRepository.findAll();
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
    return alumnoRepository.deleteById(id);
  }
}