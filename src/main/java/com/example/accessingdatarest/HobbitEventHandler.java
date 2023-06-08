package com.example.accessingdatarest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@Component
@RepositoryEventHandler
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class HobbitEventHandler {

    public HobbitEventHandler() {
        log.info("Created instance.");
    }

    @HandleAfterSave
    public void handleAfterSave(Person person) {
        log.info("Saved: " + person.getFirstName());
    }

    @HandleBeforeSave
    public void handleBeforeSave(Person person) {
        log.info("Before Saving: " + person.getFirstName());
    }

    @HandleAfterCreate
    public void handleAfterCreate(Person person) {
        log.info("After Create: " + person.getFirstName());
        if (person.getFirstName().equalsIgnoreCase("Spock")) {
            log.warn("Rejecting a person called Spock");
            Errors errors = initErrors(person);
            errors.rejectValue("firstName", "errmsg.spock");
            throw new RepositoryConstraintViolationException(errors);
        }

    }

    @HandleBeforeCreate
    public void handleBeforeCreate(Person person) {
        log.info("Before Create: " + person.getFirstName());

    }

    @HandleBeforeDelete
    public void handleBeforeDelete(Person person) {
        log.info("Before delete: " + person.getFirstName());
    }

    @HandleAfterDelete
    public void handleAfterDelete(Person person) {
        log.info("After delete: " + person.getFirstName());
    }

    private Errors initErrors(Object entity) {
        return new BeanPropertyBindingResult(entity, entity.getClass().getSimpleName());
    }

}
