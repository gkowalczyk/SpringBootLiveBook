package com.example.springjpa.onetomany;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity

public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "zoo")
    private Set<Animal> animalList;

    public Long getId() {
        return id;
    }

    public Set<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Set<Animal> animalList) {
        this.animalList = animalList;
    }

    public void setId(Long id) {
        this.id = id;
        }
}
