package com.example.Data;

import java.util.ArrayList;


public class ListAnimal {
    
    private ArrayList<Animal> listAnimal = new ArrayList<Animal>();



    public void addAnimal(Animal animal) {
        this.listAnimal.add(animal);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (Animal item : listAnimal) {
            builder.append("№");
            builder.append(counter);
            builder.append("\n");
            builder.append(item.toString());
            builder.append("\n");
            counter++;
        }
        return builder.toString();
    }

    public int getSize() {
        return listAnimal.size();
    }

    public Animal get(int number) {
        return listAnimal.get(number - 1);
    }
}
