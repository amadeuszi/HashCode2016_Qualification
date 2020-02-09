package com.kosior.hash.model;

import java.util.HashMap;
import java.util.Map;

public class Dron {
    public int row;
    public int column;

    // product id, quantity
    public Map<Integer, Integer> products = new HashMap<>();
}
