package com.edutech.msresenas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.msresenas.model.Resena;
import com.edutech.msresenas.service.ResenaService;

@RestController
@RequestMapping("/api/v1/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public ResponseEntity<List<Resena>> listarResenas() {
        List<Resena> resenas = resenaService.findAll();
        if(resenas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(resenas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Resena> createResena(@RequestBody Resena resena) {
        Resena nuevaResena = resenaService.save(resena);
        return new ResponseEntity<>(nuevaResena, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idResena}")
    public ResponseEntity<Resena> readResena(@PathVariable int idResena) {
        try {
            Resena resena = resenaService.findById(idResena);
            return new ResponseEntity<>(resena, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idResena}")
    public ResponseEntity<Resena> updateResena(@PathVariable int idResena, @RequestBody Resena resena) {
        try {
            Resena res = resenaService.findById(idResena);
            res.setIdResena(idResena);
            res.setMensaje(resena.getMensaje());
            res.setIdCurso(resena.getIdCurso());
            res.setIdUsuario(resena.getIdUsuario());
            res.setCalificacion(resena.getCalificacion());
            res.setVisible(resena.getVisible());
            res.setFechaPublicacion(resena.getFechaPublicacion());

            resenaService.save(res);
            return new ResponseEntity<>(resena, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idResena}")
    public  ResponseEntity<?> deleteResena(@PathVariable int idResena) {
        try {
            resenaService.deleteById(idResena);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
