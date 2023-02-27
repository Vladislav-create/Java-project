package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int frequency = 20;
    public static int quantity = 3;
    public static int exit = 1;
    public static List<Toy> toy_bank = new ArrayList<>();
    public static List<Toy> toys_to_issue = new ArrayList<>();
    public static String[] toy_name = new String[]{"Robot", "Railway", "Car", "Iron man"};

    public static void main(String[] args) {
        filling_bank();

        while (exit != 0){
            start();
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            exit = num;
            switch (num){
                case 1 -> {
                    show_toy_bank();
                    break;
                }
//                Выбор призовой игрушки
                case 2 -> {
                    System.out.println("Введите id игрушки");
                    int num_choose_toy = scanner.nextInt();
                    for (int i = 0; i < toy_bank.size(); i++) {
                        if (toy_bank.get(i).id == num_choose_toy){
                            toys_to_issue.add(toy_bank.get(i));
                            toy_bank.get(i).quantity -= 1;
                        }

                    }
                    for (int i = 0; i < toys_to_issue.size(); i++) {
                        System.out.println("id:" + toys_to_issue.get(i).id + "   " + "Наименование игрушки: " + toys_to_issue.get(i).name);
                    }
                    break;
                }
                case 3 -> {
                    System.out.print("Введите новое значение веса (частоты вывпадения игрушки):");
                    frequency = scanner.nextInt();
                    break;
                }
                case 4 -> {
                    toys_to_issue.remove(1);
                    for (int i = 0; i < toys_to_issue.size(); i++) {
                        System.out.println("id:" + toys_to_issue.get(i).id + "   " + "Наименование игрушки: " + toys_to_issue.get(i).name);
                    }
                }
            }
        }

    }
//    Показать меню
    public static void start() {
        System.out.println("""
                Выберите пункт меню:
                1 - показать список доступных игрушек.
                2 - выбрать призовую игрушку.
                3 - изменить параметры игрушки.
                4 - забрать приз
                0 - Выход.""");
    }
//    Наполнить список игрушками
    public static void filling_bank() {
        for (int i = 0; i < 10; i++) {
            int ind = (int) (Math.random() * ((toy_name.length)));
            Toy toy = new Toy(i, toy_name[ind], quantity, frequency);
            toy_bank.add(toy);
        }

    }
//    Показать все игрушки
    public static void show_toy_bank(){
        for (int i = 0; i < toy_bank.size(); i++) {
            System.out.println("id:" + toy_bank.get(i).id + ".   " +
                    "Наименование игрушки: " + toy_bank.get(i).name + ".   " +
                    "Остаток: " + toy_bank.get(i).quantity + ".");
        }
    }
}