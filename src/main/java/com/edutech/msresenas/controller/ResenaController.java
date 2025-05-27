package com.edutech.msresenas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        Resena buscarResena = resenaService.findById(resena.getIdResena());
        if(buscarResena == null) {
            Resena nuevaResena = resenaService.save(resena);
            return new ResponseEntity<>(nuevaResena, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{idResena}")
    public ResponseEntity<Resena> readResena(@PathVariable int idResena) {
        Resena buscResena = resenaService.findById(idResena);
        if(buscResena != null) {
            return new ResponseEntity<>(buscResena, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idResena}")
    public ResponseEntity<Resena> updateResena(@PathVariable int idResena, @RequestBody Resena resena) {
        if(resenaService.update(idResena, resena)) {
            return new ResponseEntity<>(resena, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idResena}")
    public  ResponseEntity<?> deleteResena(@PathVariable int idResena) {
        Resena buscResena = resenaService.findById(idResena);
        if(buscResena != null) {
            resenaService.deleteById(idResena);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idResena}/modificar/visible")
    public ResponseEntity<?> cambiarVisibilidad(@PathVariable int idResena) {
        if(resenaService.cambiarVisibilidad(idResena)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idResena}/modificar/resena")
    public ResponseEntity<?> modificarResena(@PathVariable int idResena, @RequestBody Map<String, String> body) {
        String nuevaResena = body.get("mensaje");
        if(resenaService.modificarResena(idResena, nuevaResena)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{idResena}/modificar/calificacion")
    public ResponseEntity<?> modificarCalificacion(@PathVariable int idResena, @RequestBody Map<String, Integer> body) {
        int nuevaCalificacion = body.get("calificacion");
        if(resenaService.modificarCalificacion(idResena, nuevaCalificacion)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
