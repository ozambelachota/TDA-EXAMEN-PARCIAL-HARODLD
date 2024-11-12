package com.examenparcial.examenparcial.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenparcial.examenparcial.domain.Alumno;
import com.examenparcial.examenparcial.infrastructure.repository.AlumnoRepository;

@Repository
public interface AlumnoRepositoryJpa extends AlumnoRepository,JpaRepository<Alumno, Integer> {

}
