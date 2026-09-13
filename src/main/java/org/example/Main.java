package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Сложение: " + (calculate(5, 3, "+") == 8));
        System.out.println("Вычетание: " + (calculate(8,5,"-") == 3));
        System.out.println("Умножение: " + (calculate(2,5,"*") == 10));
        System.out.println("Деление: " + (calculate(10,2,"/") == 5));


        try {
            calculate(10,0,"/");
            System.out.println("Деление на ноль: false");
        } catch (IllegalArgumentException e){
            System.out.println("Деление на ноль: true");
        }

        try {
            calculate(10,2,"%");
            System.out.println("Неизвестный оператор: false");
        } catch (IllegalArgumentException e){
            System.out.println("Неизвестный оператор: true");
        }


        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            if (input.equals("exit")){
                break;
            }
            try {
                String[] parts = input.split(" ");
                if (parts.length != 3){
                    throw new IllegalArgumentException("Ошибка: неверный формат.");
                }
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[2]);
                int result = calculate(a,b,parts[1]);
                System.out.println(a + " " + parts[1] + " " + b + " = " + result);
            } catch (NumberFormatException e){
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }


    }
    private static int calculate(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        if (operator.equals("/") && b == 0) {
            throw new IllegalArgumentException("Ошибка: деление на 0 невозможно");
        } else if (operator.equals("/")) {
            return a / b;
        }
        throw new IllegalArgumentException("Ошибка: неизвестная операция");


        }

}
