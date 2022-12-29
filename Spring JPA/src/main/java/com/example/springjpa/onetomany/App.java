package com.example.springjpa.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class App {

    private final ZooRepo zooRepo;
    private final AnimalRepo animalRepo;

    @Autowired
    public App(ZooRepo zooRepo, AnimalRepo animalRepo) {
        this.zooRepo = zooRepo;
        this.animalRepo = animalRepo;

            Zoo zoo = new Zoo();
            zooRepo.save(zoo);
            Animal animal1= new Animal();
            Animal animal2 = new Animal();
            animal1.setZoo(zoo);
            animal2.setZoo(zoo);
            animalRepo.save(animal1);
            animalRepo.save(animal2);
        }
    }

