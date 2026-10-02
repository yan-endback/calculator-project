package com.yan.calculator.history;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String EMPTY_HISTORY_MESSAGE = "Ошибка: история пуста";
    private static final int MAX_HISTORY_SIZE = 10;
    private List<String> history = new ArrayList<>();

    public List<String> getHistory() { return history;}

    public String getLast(){
        if (history.isEmpty()){
            throw new IllegalArgumentException(EMPTY_HISTORY_MESSAGE);
        }
        return history.get(history.size() - 1);
    }

    public void clear(){ history.clear(); }

    public int size(){ return history.size(); }

    public void add(String operation){
        if (history.size() == MAX_HISTORY_SIZE){
            history.remove(0);
        }
        history.add(operation);

    }
}
