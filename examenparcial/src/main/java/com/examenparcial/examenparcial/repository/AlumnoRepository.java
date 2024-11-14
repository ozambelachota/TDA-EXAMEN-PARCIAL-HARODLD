package com.examenparcial.examenparcial.repository;

import java.util.List;
import java.util.Optional;

import com.examenparcial.examenparcial.model.Alumno;

public interface AlumnoRepository {

  List<Alumno> findAll();
  Optional<Alumno> findById(int id);
  Alumno save(Alumno alumno);
  boolean deleteById(int id);
}
