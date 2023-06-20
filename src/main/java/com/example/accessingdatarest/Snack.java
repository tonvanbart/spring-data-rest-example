package com.example.accessingdatarest;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
//@Entity
public class Snack {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    @Nonnull
    private String name;

}
