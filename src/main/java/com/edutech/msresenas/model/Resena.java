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

    @Column(length = 1000, nullable = true)
    private String mensaje;

    @Column(nullable = false)
    private int idCurso;

    @Column(nullable = false)
    private int idUsuario;

    @Column(nullable = true)
    private int calificacion;

    @Column(nullable = false)
    private Boolean visible;

    @Column(nullable = false)
    private LocalDate fechaPublicacion;
}
