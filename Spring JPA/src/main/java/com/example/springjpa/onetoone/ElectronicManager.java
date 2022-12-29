package com.example.springjpa.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectronicManager {

    private final ComputerRepo computerRepo;
    private final ProcessorRepo processorRepo;

    @Autowired
    public ElectronicManager(ComputerRepo computerRepo, ProcessorRepo processorRepo) {
        this.computerRepo = computerRepo;
        this.processorRepo = processorRepo;

        Processor processor = new Processor();
        processor.setName("Intel i5");
        processorRepo.save(processor);

        Computer computer = new Computer();
        computer.setProcessor(processor);
        computerRepo.save(computer);
    }
}