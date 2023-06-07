package com.example.accessingdatarest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HobbitsLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Autowired
    public HobbitsLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading hobbits...");
        personRepository.save(new Person("Frodo", "Baggins"));
        personRepository.save(new Person("Bilbo", "Baggins"));
        personRepository.save(new Person("Peregrin", "Took"));
        personRepository.save(new Person("Meriadoc", "Brandybuck"));
    }
}
