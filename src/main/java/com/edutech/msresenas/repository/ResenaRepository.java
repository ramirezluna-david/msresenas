package com.edutech.msresenas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.msresenas.model.Resena;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Integer>{

    Resena save(Resena resena);

    Resena findById(int idResena);

    List<Resena> findAll();

    void deleteById(int idResena);
}
