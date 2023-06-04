package com.example;

import java.time.LocalDate;
import java.util.Scanner;

import com.example.Data.ListAnimal;

public class Viever {
    Scanner scanner = new Scanner(System.in, "cp866");

    public void print(String text) {
        System.out.println(text);
    }

    public int printMenu(ListAnimal listAnimal) {
        System.out.println(listAnimal);

        int number;
        while (true) {
            System.out.println("Выберите пункт Меню:\n 1.Завести новое животное.\n " +
                    "2.Добавить команду животному\n " +
                    "0.Выход");
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= 0 && number <= 2) {
                    if (number == 0) {
                        scanner.close();
                    }
                    return number;
                } else {
                    System.out.println("Неверный номер меню");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный номер меню");
                continue;
            }
        }
    }

    public int printMenuType() {
        int number;
        while (true) {
            System.out.println("Выберите животное:\n 1.Верблюд\n " +
                    "2.Осёл\n " +
                    "3.Лошадь\n " +
                    "4.Кошка\n " +
                    "5.Собака\n " +
                    "6.Хомяк\n " +
                    "0.Выход");
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= 0 && number <= 6) {
                    if (number == 0) {
                        scanner.close();
                    }
                    return number;
                } else {
                    System.out.println("Неверный номер меню");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный номер меню");
                continue;
            }
        }
    }

    public String setName() {
        System.out.println("Введите кличку");
        String name = scanner.nextLine();
        return name;
    }

    public LocalDate setBirthday() {
        LocalDate birthdayLD;
        while (true) {
            try {
                System.out.println("Введите дату рождения в формате YYYY-MM-DD");
                String birthday = scanner.nextLine();
                String[] birthdayArray = birthday.split("-");
                birthdayLD = LocalDate.of(Integer.parseInt(birthdayArray[0]),
                        Integer.parseInt(birthdayArray[1]),
                        Integer.parseInt(birthdayArray[2]));
                break;
            } catch (Exception e) {
                System.out.println("неверный формат ввода");
            }
        }
        return birthdayLD;
    }

    public String setComand() {
        System.out.println("Введите команду");
        String comand = scanner.nextLine();
        return comand;
    }

    public int numberAnimal(ListAnimal listAnimal) {
        while (true) {
            System.out.println("Выберите номер животного");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0 && number <= listAnimal.getSize()) {
                    return number;
                }
                System.out.println("Неверный номер");
            } catch (NumberFormatException e) {
                System.out.println("Неверный номер");
            }
        }
    }

    public String addComand() {
        System.out.println("Введите команду");
        String comand = scanner.nextLine();
        return comand;
    }
}
