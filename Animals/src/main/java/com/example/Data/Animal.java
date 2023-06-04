package com.example.Data;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Animal {
    private String name;
    private String type;
    private String classAnimal;
    private LinkedList<String> comand;
    private LocalDate birthday;

    public Animal(String classAnimal, String type, String name, LocalDate birthday, String baseComand) {
        this.classAnimal = classAnimal;
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.comand = new LinkedList<String>();
        this.comand.add(baseComand);
    }

    public void addComand(String comand) {
        this.comand.add(comand);
    }

    public String getClassAnimal() {
        return classAnimal;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getComand() {
        return comand;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Класс: ");
        builder.append(type);
        builder.append("Вид: ");
        builder.append(type);
        builder.append("\n");
        builder.append("Кличка: ");
        builder.append(name);
        builder.append("\n");
        builder.append("Дата рождения: ");
        builder.append(birthday);
        builder.append("\n");
        builder.append("Знает команды: ");
        for (String string : comand) {
            builder.append(string);
            builder.append(", ");
        }
        builder.setLength(builder.length() - 2); // Удаляем лишнюю запятую и пробел
        return builder.toString();
    }
}
