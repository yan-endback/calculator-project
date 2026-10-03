package com.yan.calculator.calculator;

import com.yan.calculator.model.Expression;
import com.yan.calculator.operations.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationsTest {
    @Test
    void addOperationsWorks(){
        Operation operation = new AddOperation();
        assertEquals(8.0,operation.execute(5.0,3.0), 0.001);
    }

    @Test
    void divideOperationsWorks(){
        Operation operation = new DivideOperation();
        assertEquals(5.0, operation.execute(10.0,2.0), 0.001);
    }

    @Test
    void moduloOperationsWorks(){
        Operation operation = new ModuloOperation();
        assertEquals(1.0,operation.execute(10.0,3.0),0.001);
    }

    @Test
    void multiplyOperationsWorks(){
        Operation operation = new MultiplyOperation();
        assertEquals(10.0,operation.execute(5.0,2.0),0.001);
    }

    @Test
    void subtractOperationsWorks(){
        Operation operation = new SubtractOperation();
        assertEquals(3.0,operation.execute(10.0,7.0),0.001);
    }

    @Test
    void divisionByZeroThrowsException(){
        Operation operation = new DivideOperation();
        assertThrows(ArithmeticException.class, () -> operation.execute(10.0,0));
    }

    @Test
    void unknownOperatorThrowsException(){

        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(new Expression(5.5,3.5,'&')));
    }
}
