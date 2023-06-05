package com.example;

import com.example.Data.ListAnimal;
import com.example.Data.PackAnimals.Camel;
import com.example.Data.PackAnimals.Donkey;
import com.example.Data.PackAnimals.Horse;
import com.example.Data.Pets.Cat;
import com.example.Data.Pets.Dog;
import com.example.Data.Pets.Hamster;

public class Presenter {
    private ListAnimal listAnimal;
    private Viever viever;

    public Presenter(ListAnimal listAnimal, Viever viever) {
        this.listAnimal = listAnimal;
        this.viever = viever;
    }

    public void Run() {
        try(Counter counter = new Counter(listAnimal.getSize())){
        int number;
        Boolean run = true;
        while (run) {
            number = viever.printMenu(listAnimal);
            switch (number) {
                // Добавить животное
                case 1:
                    number = viever.printMenuType();
                    switch (number) {
                        // Добавить Верблюда
                        case 1:
                            listAnimal.addAnimal(new Camel(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Добавить Осла
                        case 2:
                            listAnimal.addAnimal(new Donkey(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Добавить Лошадь
                        case 3:
                            listAnimal.addAnimal(new Horse(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Добавить Кошку
                        case 4:
                            listAnimal.addAnimal(new Cat(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Добавить Собаку
                        case 5:
                            listAnimal.addAnimal(new Dog(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Добавить Хомяка
                        case 6:
                            listAnimal.addAnimal(new Hamster(viever.setName(),
                                    viever.setBirthday(),
                                    viever.setComand()));
                                    counter.increment();
                            break;

                        // Выход
                        case 0:
                            run = false;
                            break;
                    }
                    break;

                // Добавить команду животному
                case 2:
                    int numberAnimal = viever.numberAnimal(listAnimal);
                    listAnimal.get(numberAnimal).addComand(viever.addComand());
                    break;
                // Выход
                case 0:
                    run = false;
                    break;
                }
            }
        }
    }
}
