package com.blue.crud_fullstack_angular.controller;

import com.blue.crud_fullstack_angular.entity.Serie;
import com.blue.crud_fullstack_angular.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "http://localhost:4200")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping("/create")
    public Serie saveSerie(@RequestBody Serie serie) {
        return serieService.save(serie);
    }

    @GetMapping("/get")
    public List<Serie> getAllSeries() {
        return serieService.findAll();
    }

    @GetMapping("/get/{id}")
    public Serie getSerie(@PathVariable Long id) {
        return serieService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSerie(@PathVariable Long id) {
        serieService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateSerie(@PathVariable Long id, @RequestBody Serie serie) {
        Serie serieDB = serieService.findById(id);

        if (serieDB == null) {
            return ResponseEntity.notFound().build();
        }

        serieDB.setTitulo(serie.getTitulo());
        serieDB.setDescripcion(serie.getDescripcion());
        serieDB.setAnio(serie.getAnio());
        serieDB.setNumeroTemporadas(serie.getNumeroTemporadas());

        Serie updated = serieService.update(serieDB);

        return ResponseEntity.ok(updated);
    }
}