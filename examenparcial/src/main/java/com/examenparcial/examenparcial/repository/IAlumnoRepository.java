package com.examenparcial.examenparcial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examenparcial.examenparcial.model.Alumno;

@Repository
public interface IAlumnoRepository extends CrudRepository<Alumno, Integer> {

}
