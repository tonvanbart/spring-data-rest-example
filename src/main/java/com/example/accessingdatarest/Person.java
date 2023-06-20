package com.example.accessingdatarest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    @ElementCollection(targetClass = Snack.class, fetch = FetchType.EAGER)
    @CollectionTable(name="person_snacks", joinColumns=@JoinColumn(name="person_id"))
    private List<Snack> favoriteSnacks = new ArrayList<>();

    public Person() {}

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteSnacks = new ArrayList<>();
    }

}