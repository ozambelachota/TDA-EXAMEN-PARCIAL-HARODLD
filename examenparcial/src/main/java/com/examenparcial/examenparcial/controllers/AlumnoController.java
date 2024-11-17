package com.examenparcial.examenparcial.controllers;

import com.examenparcial.examenparcial.model.Alumno;
import com.examenparcial.examenparcial.model.ApiEndpoint;
import com.examenparcial.examenparcial.service.AlumnoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping(ApiEndpoint.BASE_URL_ALUMNO)
public class AlumnoController {

  private static final Logger logger = LoggerFactory.getLogger(
    AlumnoController.class
  );

  @Autowired
  private AlumnoService alumnoService;

  @GetMapping(ApiEndpoint.GET_ALUMNOS_ALL)
  public ResponseEntity<?> findAll() {
    try {
      List<Alumno> alumnos = alumnoService.getAlumnos();
      if (alumnos.isEmpty()) {
        return new ResponseEntity<>("No hay alumnos", HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(alumnos, HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error al obtener los alumnos ", e.getMessage(), e);
      return new ResponseEntity<>(
        "Error interno del servidor: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  @GetMapping(ApiEndpoint.GET_ALUMNO_BY_ID)
  public ResponseEntity<?> find(@PathVariable Integer id) {
    try {
      Alumno alumno = alumnoService.getAlumnoById(id);
      if (alumno == null) {
        logger.error("Alumno no encontrado");
        return new ResponseEntity<>(
          "usuario no encontrado",
          HttpStatus.NOT_FOUND
        );
      }
      logger.info("Alumno encontrado");
      return new ResponseEntity<>(alumno, HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error al obtener el alumno ", e.getMessage(), e);
      return new ResponseEntity<>(
        "Error interno del servidor: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  // Crear un nuevo alumno
  @PostMapping(ApiEndpoint.CREATE_ALUMNO)
  public ResponseEntity<?> create(@RequestBody Alumno alumno) {
    if (alumno.getNombre() == null || alumno.getNota() == null) {
      logger.error("Error al crear el alumno faltan datos");
      return new ResponseEntity<>(
        "Error al crear el alumno faltan datos",
        HttpStatus.BAD_REQUEST
      );
    }

    try {
      Alumno alumnoCreado = alumnoService.saveAlumno(alumno);
      if (alumnoCreado == null) {
        logger.error("Error al crear el alumno");
        return new ResponseEntity<>(
          "Error al crear el alumno",
          HttpStatus.BAD_REQUEST
        );
      }
      logger.info("Alumno creado");
      return new ResponseEntity<>(alumnoCreado, HttpStatus.CREATED);
    } catch (Exception e) {
      logger.error("Error al crear el alumno ", e.getMessage(), e);
      return new ResponseEntity<>(
        "Error interno del servidor: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  // Actualizar un alumno
  @PutMapping(ApiEndpoint.UPDATE_ALUMNO)
  public ResponseEntity<?> update(
    @PathVariable Integer id,
    @RequestBody Alumno alumno
  ) {
    if (id == null) {
      logger.error("Error al actualizar el alumno faltan datos");
      return new ResponseEntity<>(
        "Error al actualizar el alumno faltan datos",
        HttpStatus.BAD_REQUEST
      );
    }
    if (alumno == null) {
      logger.error("Error al actualizar el alumno faltan datos");
      return new ResponseEntity<>(
        "Error al actualizar el alumno faltan datos",
        HttpStatus.BAD_REQUEST
      );
    }
    if (alumno.getNombre() == null || alumno.getNota() == null) {
      logger.error("Error al actualizar el alumno faltan datos");
      return new ResponseEntity<>(
        "Error al actualizar el alumno faltan datos",
        HttpStatus.BAD_REQUEST
      );
    }
    try {
      Alumno alumnoUpdate = new Alumno(
        id,
        alumno.getNombre(),
        alumno.getNota()
      );
      Alumno alumnoActualizado = alumnoService.updateAlumno(alumnoUpdate);
      if (alumnoActualizado == null) {
        logger.error("Alumno no encontrado");
        return new ResponseEntity<>(
          "Alumno no encontrado",
          HttpStatus.NOT_FOUND
        );
      }
      return new ResponseEntity<>(alumnoActualizado, HttpStatus.OK);
    } catch (Exception e) {
      logger.error("Error al actualizar el alumno ", e.getMessage(), e);
      return new ResponseEntity<>(
        "Error interno del servidor: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  // Eliminar un alumno
  @DeleteMapping(ApiEndpoint.DELETE_ALUMNO)
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    try {
      boolean eliminado = alumnoService.deleteAlumno(id);
      if (!eliminado) {
        logger.error("Alumno no encontrado");
        return new ResponseEntity<>(
          "Alumno no encontrado",
          HttpStatus.NOT_FOUND
        );
      }
      return new ResponseEntity<>("alumno eliminado", HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      logger.error("Error al eliminar el alumno ", e.getMessage(), e);
      return new ResponseEntity<>(
        "Error interno del servidor: " + e.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
