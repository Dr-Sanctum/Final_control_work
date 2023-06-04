package com.example.Data.Pets;

import java.time.LocalDate;

import com.example.Data.PackAnimal;


public class Hamster extends PackAnimal {

    public Hamster(String name, LocalDate birthday, String baseComand) {
        super("Хомяк", name, birthday, baseComand);
    }

}
