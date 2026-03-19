package com.blue.crud_fullstack_angular.controller;

import com.blue.crud_fullstack_angular.entity.Pelicula;
import com.blue.crud_fullstack_angular.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:4200")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping("/create")
    public Pelicula savePelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.save(pelicula);
    }

    @GetMapping("/get")
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.findAll();
    }

    @GetMapping("/get/{id}")
    public Pelicula getPelicula(@PathVariable Long id) {
        return peliculaService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePelicula(@PathVariable Long id) {
        peliculaService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaDB = peliculaService.findById(id);

        if (peliculaDB == null) {
            return ResponseEntity.notFound().build();
        }

        peliculaDB.setTitulo(pelicula.getTitulo());
        peliculaDB.setDescripcion(pelicula.getDescripcion());
        peliculaDB.setAnio(pelicula.getAnio());
        peliculaDB.setDuracion(pelicula.getDuracion());

        Pelicula updated = peliculaService.update(peliculaDB);

        return ResponseEntity.ok(updated);
    }
}