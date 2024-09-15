package com.example.calculator;

import java.util.ArrayList;

public interface IDB {
    void save(int data);
    ArrayList<String> loadData() ;
    void update(String data);
    void delete(String data);
}
