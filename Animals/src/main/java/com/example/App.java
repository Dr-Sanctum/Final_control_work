package com.example;

import java.time.LocalDate;

import com.example.Data.Animal;
import com.example.Data.ListAnimal;
import com.example.Data.PackAnimals.Camel;
import com.example.Data.PackAnimals.Horse;
import com.example.Data.Pets.Dog;
import com.example.Data.Pets.Hamster;

public class App {
    public static void main(String[] args) {
        Animal a = new Horse("Гром", LocalDate.of(2002, 5, 12), "Ко мне");
        Animal b = new Dog("Шарик", LocalDate.of(2001, 12, 2), "Голос");
        Animal c = new Hamster("Мох", LocalDate.of(2022, 8, 23), "Не трогай");
        Animal d = new Camel("Махмед", LocalDate.of(2010, 1, 21), "Ко мне");
        ListAnimal newListAnimal = new ListAnimal();
        newListAnimal.addAnimal(a);
        newListAnimal.addAnimal(b);
        newListAnimal.addAnimal(c);
        newListAnimal.addAnimal(d);
        Viever newViever = new Viever();
        Presenter newPresenter = new Presenter(newListAnimal, newViever);
        newPresenter.Run();
    }
}
