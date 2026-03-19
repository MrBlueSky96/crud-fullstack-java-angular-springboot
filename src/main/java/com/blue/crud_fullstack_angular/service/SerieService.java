package com.blue.crud_fullstack_angular.service;

import com.blue.crud_fullstack_angular.entity.Serie;
import com.blue.crud_fullstack_angular.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Serie findById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        serieRepository.deleteById(id);
    }

    public Serie update(Serie serie) {
        return serieRepository.save(serie);
    }
}