package com.kosior.hash.model;

import java.util.Map;

public class Order {
    public int row;
    public int columns;

    // product id, quantity
    public Map<Integer, Integer> productsNeeded;
}
