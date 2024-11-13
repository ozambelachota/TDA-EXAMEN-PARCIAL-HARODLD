package com.examenparcial.examenparcial.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenparcial.examenparcial.application.AlumnoService;
import com.examenparcial.examenparcial.domain.Alumno;

@RestController
@RequestMapping("alumno")
public class AlumnoController {

  @Autowired
  private AlumnoService alumnoService;

  @GetMapping("/all")
  public ResponseEntity<?> findAll() {
      try {
          List<Alumno> alumnos = alumnoService.getAlumnos();
          if (alumnos.isEmpty()) { 
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<>(alumnos, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  @GetMapping("/find/{id}")
  public ResponseEntity<?> find(@PathVariable Integer id) {
      try {
          Alumno alumno = alumnoService.getAlumnoById(id);
          if (alumno == null) {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(alumno, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  // Crear un nuevo alumno
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody Alumno alumno) {
      try {
          Alumno alumnoCreado = alumnoService.saveAlumno(alumno);
          return new ResponseEntity<>(alumnoCreado, HttpStatus.CREATED);
      } catch (Exception e) {
          return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  // Actualizar un alumno
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Alumno alumno) {
      try {
          Alumno alumnoUpdate = new Alumno(id, alumno.getNombre(), alumno.getNota());
          Alumno alumnoActualizado = alumnoService.updateAlumno(alumnoUpdate);
          if (alumnoActualizado == null) {
              return new ResponseEntity<>("Alumno no encontrado",HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  // Eliminar un alumno
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
      try {
          boolean eliminado = alumnoService.deleteAlumno(id);
          if (!eliminado) {
              return new ResponseEntity<>("Alumno no encontrado",HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>("alumno eliminado",HttpStatus.NO_CONTENT); 
      } catch (Exception e) {
          return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }
  
}
