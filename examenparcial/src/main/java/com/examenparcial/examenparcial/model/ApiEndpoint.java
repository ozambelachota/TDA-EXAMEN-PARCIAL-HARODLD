package com.examenparcial.examenparcial.model;

public class ApiEndpoint {

  public static final String BASE_URL_ALUMNO = "api/v1/alumnos";

  public static final String GET_ALUMNOS_ALL = "/all";
  public static final String GET_ALUMNO_BY_ID = "/{id}";
  public static final String CREATE_ALUMNO = "/create";
  public static final String UPDATE_ALUMNO = "/update/{id}";
  public static final String DELETE_ALUMNO = "/delete/{id}";

  public static String buildPath(String base, String subPath) {
    return base + subPath;
  }
}
