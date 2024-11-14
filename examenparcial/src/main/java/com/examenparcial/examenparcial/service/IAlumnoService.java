package com.examenparcial.examenparcial.service;

import java.util.List;

import com.examenparcial.examenparcial.model.Alumno;

public interface IAlumnoService {

  public List<Alumno> getAlumnos();
  public Alumno getAlumnoById(int id);
  public Alumno saveAlumno(Alumno alumno);
  public Alumno updateAlumno(Alumno alumno);
  public boolean deleteAlumno(int id);
}
