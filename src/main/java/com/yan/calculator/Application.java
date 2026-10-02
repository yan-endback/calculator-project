package com.yan.calculator;

import com.yan.calculator.calculator.Calculator;
import com.yan.calculator.history.HistoryManager;
import com.yan.calculator.model.Expression;

import java.util.Scanner;

public class Application {
    private static final String STOP_WORD = "exit";
    private static final String CLEAR_HISTORY = "clear";
    private static final String ERROR_INVALID_FORMAT = "Ошибка: неверный формат. Используйте: число оператор число";
    private static final String HISTORY_COMMAND = "history";
    private static final String LAST_COMMAND = "last";
    private static final String NO_OPERATIONS_TO_REPEAT = "Нет операций для повтора";
    private static final String HISTORY_IS_EMPTY = "История пуста";
    private static final String HISTORY_CLEARED = "История очищена";
    private static final String RESULT = "Результат: ";
    private static final String HELP_COMMAND = "help";
    private static final String HELP_TEXT = """
            Доступные команды:
            
            <число> <оператор> <число>
            
            Операторы:
            +  сложение
            -  вычитание
            *  умножение
            /  деление
            
            Дополнительные команды:
            history  — показать историю
            last     — повторить последнюю операцию
            clear    — очистить историю
            exit     — выход""";

    HistoryManager historyManager = new HistoryManager();
    InputParser parser = new InputParser();
    Scanner scanner = new Scanner(System.in);
    public void run(){

    while (true){
    String input = scanner.nextLine();
    if (input.equals(STOP_WORD)){
        break;
    }

    if (input.equals(CLEAR_HISTORY)){
        historyManager.clear();
        System.out.println(HISTORY_CLEARED);
        continue;
    }

    if (input.equals(HISTORY_COMMAND)){
        if (historyManager.size() == 0){
            System.out.println(HISTORY_IS_EMPTY);
        } else {
            for (int i = 0; i < historyManager.size(); i++){
                System.out.println((i + 1) + ") " + historyManager.getHistory().get(i));
            }
        }
        continue;
    }

    if (input.equals(LAST_COMMAND)){
        if (historyManager.size() == 0){
            System.out.println(NO_OPERATIONS_TO_REPEAT);
            continue;
        }
        System.out.println(RESULT + historyManager.getLast());
        continue;
    }

    if (input.equals(HELP_COMMAND)){
        System.out.println(HELP_TEXT);
        continue;
    }

    try {
        Expression expression = parser.parse(input);
        double result =  Calculator.calculate(expression);
        String operation = expression.getFirstNumber() + " " +
                expression.getOperator() + " " + expression.getSecondNumber() + " = " + result;
        historyManager.add(operation);
        System.out.println(operation);
    } catch (NumberFormatException e){
        System.out.println(ERROR_INVALID_FORMAT);
    } catch (IllegalArgumentException | ArithmeticException e){
        System.out.println(e.getMessage());
    }
}

    }
}