package com.example.springjpa.unitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class VideoServiceTest {

    //  @Autowired
    // private VideoService videoService;

    // @Mock
    // private VideoRepository videoRepository2;


    private VideoRepository videoRepository = mock(VideoRepository.class);

    private VideoService videoService = new VideoService(videoRepository);

    //@InjectMocks
    //private VideoService helloService = new VideoService(videoRepository);

    // @BeforeEach
    //void setMock() {
    //  when(videoRepository2.getJavaCourses()).thenReturn("http://bykowski.pl/yt");
    // }
    @BeforeEach
    void setMock() {
        when(videoRepository.getJavaCourses()).thenReturn("http://bykowski.pl/yt");
    }


    @DisplayName("Get information about courses")
    @Test
    void getJavaCourses() {
        assertEquals("HTTP://BYKOWSKI.PL/YT", videoService.getJavaCourses());
    }

    @DisplayName("Get information about courses 2 ")
    @Test
    void getJavaCourses2() {
        assertEquals("HTTP://BYKOWSKI.PL/YT", videoService.getJavaCourses());
    }
}