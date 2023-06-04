package com.example.Data;

import java.time.LocalDate;
import java.util.LinkedList;

public class Pet extends Animal {

    public Pet(String type, String name, LocalDate birthday, String baseComand) {
        super("Домашнее животное", type, name, birthday, baseComand);
    }

}
