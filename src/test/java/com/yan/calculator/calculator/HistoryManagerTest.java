package com.yan.calculator.calculator;

import com.yan.calculator.history.HistoryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HistoryManagerTest {
    @Test
    void historyStoresOperations(){
        HistoryManager historyManager = new HistoryManager();
        historyManager.add("5.0 + 3.0 = 8.0");
        assertEquals(1, historyManager.size());
    }

    @Test
    void clearWorksCurrently(){
        HistoryManager historyManager = new HistoryManager();
        historyManager.add("5.0 + 3.0 = 8.0");
        historyManager.add("6.0 + 4.0 = 10.0");
        historyManager.clear();
        assertEquals(0,historyManager.size());
    }

    @Test
    void returnLastValue(){
        HistoryManager historyManager = new HistoryManager();
        historyManager.add("5.0 + 3.0 = 8.0");
        historyManager.add("6.0 + 4.0 = 10.0");
        assertEquals("6.0 + 4.0 = 10.0",historyManager.getLast());
    }

    @Test
    void correctWorksLimit(){
        HistoryManager historyManager = new HistoryManager();
        for (int i = 1; i <= 11; i++) {
            historyManager.add(i + ".0 + 1.0");
        }
        assertEquals(10,historyManager.size());
    }
    @Test
    void getLastOnEmptyHistoryThrowsException(){
        HistoryManager historyManager = new HistoryManager();
        assertThrows(IllegalArgumentException.class, () -> historyManager.getLast());
    }
}
