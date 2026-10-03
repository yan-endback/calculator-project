package com.yan.calculator.calculator;

import com.yan.calculator.model.Expression;
import com.yan.calculator.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static final String ERROR_UNKNOWN_OPERATOR = "Ошибка: неизвестный оператор";

    private static final Map<Character, Operation> operations = new HashMap<>();

    static {
        operations.put('+', new AddOperation());
        operations.put('-', new SubtractOperation());
        operations.put('*', new MultiplyOperation());
        operations.put('/', new DivideOperation());
        operations.put('%', new ModuloOperation());
    }
    public static double calculate(Expression expression) {

        double firstNumber = expression.getFirstNumber();
        double secondNumber = expression.getSecondNumber();
        char operator = expression.getOperator();

        Operation operation = operations.get(operator);

        if (operation == null) {
            throw new IllegalArgumentException(ERROR_UNKNOWN_OPERATOR);
        }

        return operation.execute(firstNumber,secondNumber);
    }
}



