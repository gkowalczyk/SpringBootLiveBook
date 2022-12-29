package com.example.springjpa.onetoone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepo extends CrudRepository<Processor, Long> {
}
