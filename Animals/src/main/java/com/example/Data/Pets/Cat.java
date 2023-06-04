package com.example.Data.Pets;

import java.time.LocalDate;


import com.example.Data.Pet;


public class Cat extends Pet {

    public Cat(String name, LocalDate birthday, String baseComand) {
        super("Домашняя кошка", name, birthday, baseComand);
    }

}
