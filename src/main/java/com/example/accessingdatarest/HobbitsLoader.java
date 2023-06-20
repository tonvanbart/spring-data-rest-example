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
        Person frodo = new Person("Frodo","Baggins");
        Person bilbo = new Person("Bilbo","Baggins");
        Person pippin = new Person("Peregrin","Took");
        Person merry = new Person("Meriadoc","Brandybuck");
        frodo.getFavoriteSnacks().add(new Snack("bread"));
        frodo.getFavoriteSnacks().add(new Snack("beer"));
        bilbo.getFavoriteSnacks().add(new Snack("bread"));
        bilbo.getFavoriteSnacks().add(new Snack("beer"));
        bilbo.getFavoriteSnacks().add(new Snack("chicken"));
        pippin.getFavoriteSnacks().add(new Snack("bread"));
        merry.getFavoriteSnacks().add(new Snack("bread"));
        merry.getFavoriteSnacks().add(new Snack("wine"));

        personRepository.save(frodo);
        personRepository.save(bilbo);
        personRepository.save(merry);
        personRepository.save(pippin);
    }
}
