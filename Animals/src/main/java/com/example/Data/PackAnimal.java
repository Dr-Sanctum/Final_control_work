package com.example.Data;

import java.time.LocalDate;
import java.util.LinkedList;

public class PackAnimal extends Animal {

    public PackAnimal(String type, String name, LocalDate birthday, String baseComand) {
        super("Вьючное животное", type, name, birthday, baseComand);
    }

}
