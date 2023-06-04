package com.example.Data;

import java.time.LocalDate;

public class Pet extends Animal {

    public Pet(String type, String name, LocalDate birthday, String baseComand) {
        super("Домашнее животное", type, name, birthday, baseComand);
    }

}
