package com.account;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Account a = new Account();
        while (true) {
            System.out.println("Меню програми");
            System.out.println("1-Добавити рахунок");
            System.out.println("2-Виведення інформації про рахунок");
            System.out.println("3-Змінити власника рахунку");
            System.out.println("4-Зняти деяку суму грошей з рахунку");
            System.out.println("5-Покласти гроші на рахунок");
            System.out.println("6-Нарахувати відсотки");
            System.out.println("7-Перевести суму в долари");
            System.out.println("8-Отримати суму прописом");
            System.out.println("9-Закриття програми");
            String input = scan.nextLine();
            switch (input)
            {
                case "1":
                    a.Read();
                    System.out.println();
                    break;
                case "2":
                    a.Display();
                    System.out.println();
                    break;
                case "3":
                    a.Chegvl();
                    System.out.println();
                    break;
                case "4":
                    a.minussum();
                    System.out.println();
                    break;
                case "5":
                    a.plussum();
                    System.out.println();
                    break;
                case "6":
                    a.addvid();
                    System.out.println();
                    break;
                case "7":
                    a.sumcondol();
                    System.out.println();
                    break;
                case "8":
                    a.sumtost();
                    System.out.println();
                    break;
                case "9":
                    System.out.println("Дякуємо за користування програмою");
                    return;
                default:
                    System.out.println("Невiрний вибiр, спробуйте ще раз");
                    System.out.println();
                    break;
            }
        }
    }
}