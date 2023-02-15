package com.example.springjpa.unitTest;

import org.springframework.stereotype.Repository;

@Repository
public class VideoRepository {

    public String getJavaCourses() {
        return "http://bykowski.pl/yt";
    }

}
