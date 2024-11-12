package com.examenparcial.examenparcial.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import com.examenparcial.examenparcial.domain.Alumno;

public interface AlumnoRepository {

  List<Alumno> findAll();
  Optional<Alumno> findById(int id);
  Alumno save(Alumno alumno);
  Alumno update(Alumno alumno);
  boolean deleteById(int id);
}
