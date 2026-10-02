package com.yan.calculator.model;

public class Expression {
    private double firstNumber;
    private double secondNumber;
    private char operator;

    public Expression(double firstNumber, double secondNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public char getOperator() {
        return operator;
    }
}
