package com.blue.crud_fullstack_angular.service;

import com.blue.crud_fullstack_angular.entity.Pelicula;
import com.blue.crud_fullstack_angular.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Pelicula findById(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        peliculaRepository.deleteById(id);
    }

    public Pelicula update(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
}