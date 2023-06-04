package com.example.Data.Pets;

import java.time.LocalDate;

import com.example.Data.PackAnimal;


public class Dog extends PackAnimal {

    public Dog(String name, LocalDate birthday, String baseComand) {
        super("Собака", name, birthday, baseComand);
    }

}
