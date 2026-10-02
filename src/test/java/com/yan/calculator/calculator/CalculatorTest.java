package com.yan.calculator.calculator;

import com.yan.calculator.model.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void additionReturnsCorrectResult() {
        Expression expression = new Expression(5,3,'+');
        assertEquals(8.0, Calculator.calculate(expression),0.001);
    }
    @Test
    void divisionByZeroThrowsException(){
        Expression expression = new Expression(10,0,'/');
        assertThrows(ArithmeticException.class, () ->
                Calculator.calculate(expression));
    }
    @Test
    void subtractionReturnsCorrectResults(){
        Expression expression = new Expression(8,5,'-');
        assertEquals(3.0,Calculator.calculate(expression),0.001);
    }
    @Test
    void multiplicationReturnsCorrectResults(){
        Expression expression = new Expression(5,2,'*');
        assertEquals(10.0,Calculator.calculate(expression), 0.001);
    }
    @Test
    void divisionReturnsCorrectResults(){
        Expression expression = new Expression(10,2,'/');
        assertEquals(5.0,Calculator.calculate(expression),0.001);
    }
    @Test
    void negativeValuesCorrectResults(){
        Expression expression = new Expression(5,8,'-');
        assertEquals(-3.0,Calculator.calculate(expression),0.001);

    }
}
