package com.blue.crud_fullstack_angular.service;

import com.blue.crud_fullstack_angular.entity.Video;
import com.blue.crud_fullstack_angular.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    public Video findById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        videoRepository.deleteById(id);
    }
}