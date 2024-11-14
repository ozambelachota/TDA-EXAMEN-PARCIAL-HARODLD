package com.examenparcial.examenparcial.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenparcial.examenparcial.model.Alumno;
import com.examenparcial.examenparcial.repository.AlumnoRepository;

@Repository
public interface AlumnoRepositoryJpa extends AlumnoRepository,JpaRepository<Alumno, Integer> {

}
