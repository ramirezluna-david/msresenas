package com.edutech.msresenas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data

public class CursoDTO {
    private int idCurso;
    private String titulo;
    private String descripcion;
    private String categoria;
    private double precio;
    private int idProfesor;
    private LocalDate fechaCreacion;
    private Boolean publicado;
}
