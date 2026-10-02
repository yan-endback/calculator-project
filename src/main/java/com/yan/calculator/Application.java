package com.yan.calculator;

import com.yan.calculator.calculator.Calculator;
import com.yan.calculator.model.Expression;

import java.util.Scanner;

public class Application {
    private static final String STOP_WORD = "exit";
    private static final String ERROR_INVALID_FORMAT = "Ошибка: неверный формат. Используйте: число оператор число";
    public void run(){
    InputParser parser = new InputParser();
    Scanner scanner = new Scanner(System.in);

    while (true){
    String input = scanner.nextLine();
    if (input.equals(STOP_WORD)){
        break;
    }
    try {
        Expression expression = parser.parse(input);
        double result =  Calculator.calculate(expression);
        System.out.println(expression.getFirstNumber() + " " +
                expression.getOperator() + " " + expression.getSecondNumber() + " = " + result);
    } catch (NumberFormatException e){
        System.out.println(ERROR_INVALID_FORMAT);
    } catch (IllegalArgumentException | ArithmeticException e){
        System.out.println(e.getMessage());
    }
}

    }
}