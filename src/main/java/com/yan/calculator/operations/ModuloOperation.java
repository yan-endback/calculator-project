package com.yan.calculator.operations;

public class ModuloOperation implements Operation{

    private static final String ERROR_DIVISION_BY_ZERO = "Ошибка: деление на ноль";

    @Override
    public double execute(double a, double b){
        if (b == 0){
            throw new ArithmeticException(ERROR_DIVISION_BY_ZERO);
        }
        return a % b;
    }
}
