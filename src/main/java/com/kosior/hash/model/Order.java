package com.kosior.hash.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    public int id;
    public int row;
    public int column;
    public int numberOfItems;
    public int totalWeights;

    // product id, quantity
    public Map<Integer, Integer> productsNeeded = new HashMap<>();


    public boolean isDone() {
        return productsNeeded.size() == 0;
    }

}
