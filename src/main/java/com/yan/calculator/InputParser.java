package com.yan.calculator;

import com.yan.calculator.model.Expression;

public class InputParser {
    private static final int PARTS_COUNT = 3;
    private static final String ERROR_UNKNOWN_FORMAT = "Ошибка: неверный формат. Используйте: число оператор число";
    public Expression parse(String input){
        double firstNumber;
        double secondNumber;
        char operator;
        String[] parts = input.trim().split("\\s+");
        if (parts.length != PARTS_COUNT){
            throw new IllegalArgumentException(ERROR_UNKNOWN_FORMAT);
        }
        try {
            firstNumber = Double.parseDouble(parts[0]);
            secondNumber = Double.parseDouble(parts[2]);
            operator = parts[1].charAt(0);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_UNKNOWN_FORMAT);
        }
        return new Expression(firstNumber,secondNumber,operator);
        }
    }