package com.example.Data.Pets;

import java.time.LocalDate;


import com.example.Data.Pet;


public class Dog extends Pet {

    public Dog(String name, LocalDate birthday, String baseComand) {
        super("Собака", name, birthday, baseComand);
    }

}
