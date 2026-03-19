package com.blue.crud_fullstack_angular.controller;

import com.blue.crud_fullstack_angular.entity.Video;
import com.blue.crud_fullstack_angular.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // GET ALL
    @GetMapping("/get")
    public List<Video> getAllVideos() {
        return videoService.findAll();
    }

    // GET BY ID
    @GetMapping("/get/{id}")
    public Video getVideo(@PathVariable Long id) {
        return videoService.findById(id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteById(id);
    }
}