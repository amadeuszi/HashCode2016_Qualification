package com.kosior.hash.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    public int row;
    public int column;
    public int numberOfItems;

    // product id, quantity
    public Map<Integer, Integer> productsNeeded = new HashMap<>();
}
