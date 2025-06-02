package com.edutech.msresenas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resena")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    @Column(length = 1000, nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private int idCurso;

    @Column(length = 50, nullable = false)
    private String tituloCurso;

    @Column(nullable = false)
    private int idUsuario;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private int calificacion;

    @Column(nullable = false)
    private Boolean visible;

    @Column(nullable = false)
    private LocalDate fechaPublicacion;
}
