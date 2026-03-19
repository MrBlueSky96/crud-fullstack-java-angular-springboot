package com.blue.crud_fullstack_angular.repository;

import com.blue.crud_fullstack_angular.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}