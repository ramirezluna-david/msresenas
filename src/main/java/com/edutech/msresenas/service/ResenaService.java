package com.edutech.msresenas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edutech.msresenas.model.CursoDTO;
import com.edutech.msresenas.model.Resena;
import com.edutech.msresenas.model.UserDTO;
import com.edutech.msresenas.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Resena save(Resena resena) {
        // return resenaRepository.save(resena);
        String urlUser = "http://localhost:8081/api/v1/usuarios/" + resena.getIdUsuario();
        UserDTO user = restTemplate.getForObject(urlUser, UserDTO.class);
        String urlCurso = "http://localhost:8081/api/v1/cursos/" + resena.getIdCurso();
        CursoDTO curso = restTemplate.getForObject(urlCurso, CursoDTO.class);
        if(user != null && curso != null) {
            resena.setUsername(user.getUsername());
            resena.setTituloCurso(curso.getTitulo());
        }

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

    public Boolean update(int idResena, Resena resena) {
        Resena res = resenaRepository.findById(idResena);
        if(res != null) {
            res.setIdResena(idResena);
            res.setMensaje(resena.getMensaje());
            res.setIdCurso(resena.getIdCurso());
            res.setIdUsuario(resena.getIdUsuario());
            res.setCalificacion(resena.getCalificacion());
            res.setVisible(resena.getVisible());
            res.setFechaPublicacion(resena.getFechaPublicacion());

            resenaRepository.save(res);
            return true;
        } else {
            return false;
        }
    }

    public Boolean cambiarVisibilidad(int idResena) {
        Resena buscarResena = resenaRepository.findById(idResena);
        if(buscarResena != null) {
            buscarResena.setVisible((!buscarResena.getVisible()));
            resenaRepository.save(buscarResena);
            return true;
        }

        return false;
    }

    public Boolean modificarResena(int idResena, String nuevaResena) {
        Resena buscarResena = resenaRepository.findById(idResena);
        if(buscarResena != null) {
            buscarResena.setMensaje(nuevaResena);
            resenaRepository.save(buscarResena);
            return true;
        }

        return false;
    }

    public Boolean modificarCalificacion(int idResena, int nuevaCalificacion) {
        Resena buscarResena = resenaRepository.findById(idResena);
        if(buscarResena != null) {
            buscarResena.setCalificacion(nuevaCalificacion);
            resenaRepository.save(buscarResena);
            return true;
        }

        return false;
    }
}
