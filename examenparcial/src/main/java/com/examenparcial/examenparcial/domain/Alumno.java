package com.examenparcial.examenparcial.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(length = 100)
  private String nombre;
  
  @Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
  private BigDecimal nota;
}
