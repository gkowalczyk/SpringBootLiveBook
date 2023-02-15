package com.example.springjpa.unitTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    @Autowired
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    public String getJavaCourses() {

        return videoRepository.getJavaCourses().toUpperCase();
    }
}
