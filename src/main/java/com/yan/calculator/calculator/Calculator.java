package com.yan.calculator.calculator;

import com.yan.calculator.model.Expression;

public class Calculator {
    private static final String ERROR_DIVISION_BY_ZERO = "Ошибка: деление на ноль";
    private static final String ERROR_UNKNOWN_OPERATOR = "Ошибка: неизвестный оператор";

    public static double calculate(Expression expression) {


        double firstNumber = expression.getFirstNumber();
        double secondNumber = expression.getSecondNumber();
        char operator = expression.getOperator();

        if (operator == '+'){ return firstNumber + secondNumber; }
        if (operator == '-'){ return firstNumber - secondNumber; }
        if (operator == '*'){ return firstNumber * secondNumber; }
        if (operator == '/'){
            if (secondNumber == 0){ throw new ArithmeticException(ERROR_DIVISION_BY_ZERO);}
            else {
            return firstNumber / secondNumber;
        }
    }
        throw new IllegalArgumentException(ERROR_UNKNOWN_OPERATOR);

    }
}



