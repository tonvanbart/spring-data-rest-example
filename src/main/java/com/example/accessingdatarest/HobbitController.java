package com.example.accessingdatarest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.rest.core.event.AfterCreateEvent;
import org.springframework.data.rest.core.event.BeforeCreateEvent;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RepositoryRestController
@Slf4j
public class HobbitController implements ApplicationEventPublisherAware {

    private final PersonRepository personRepository;

    private ApplicationEventPublisher publisher;

    HobbitController(PersonRepository personRepository) {
        log.info("===>> Creating HobbitController");
        this.personRepository = personRepository;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping(path = "/people")
    ResponseEntity<Void> save(@RequestBody Person person) {
        log.info("===>> Saving: {}", person);
        publisher.publishEvent(new BeforeCreateEvent(person));
        this.personRepository.save(person);
        publisher.publishEvent(new AfterCreateEvent(person));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "frodo")
    ResponseEntity<Person> readOne() {
        log.info("readOne()");
        final List<Person> frodo = this.personRepository.findByFirstName("Frodo");
        if (frodo.size() > 0) {
            return ResponseEntity.ok(frodo.get(0));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
