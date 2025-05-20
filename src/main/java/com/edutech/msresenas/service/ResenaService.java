package com.edutech.msresenas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.msresenas.model.Resena;
import com.edutech.msresenas.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public Resena save(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Resena findById(int idResena) {
        return resenaRepository.findById(idResena);
    }

    public List<Resena> findAll() {
        return resenaRepository.findAll();
    }

    public void deleteById(int idResena) {
        resenaRepository.deleteById(idResena);
    }
}
