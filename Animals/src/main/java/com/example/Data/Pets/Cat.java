package com.example.Data.Pets;

import java.time.LocalDate;

import com.example.Data.PackAnimal;


public class Cat extends PackAnimal {

    public Cat(String name, LocalDate birthday, String baseComand) {
        super("Домашняя кошка", name, birthday, baseComand);
    }

}
