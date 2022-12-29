package com.example.springjpa.onetoone;

import com.example.springjpa.onetoone.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepo extends CrudRepository<Computer, Long> {
}
