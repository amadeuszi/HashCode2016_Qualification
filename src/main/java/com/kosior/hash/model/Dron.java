package com.kosior.hash.model;

import java.util.HashMap;
import java.util.Map;

public class Dron {
    public int id;
    public int row;
    public int column;
    public int finishTime = -1;
    public Order currentOrder = null;

    public boolean isWithOrder() {
        return currentOrder != null;
    }

    public boolean isFinishUnloading(int currentTurn) {
        return finishTime == currentTurn;
    }

    public boolean isReadyToFlyToOrder(int currentTurn) {
        return (finishTime < currentTurn) && (currentOrder != null);
    }

    public boolean isAvailable(int currentTurn) {
        return (finishTime < currentTurn) && (currentOrder == null);
    }

    // product id, quantity
    public Map<Integer, Integer> products = new HashMap<>();
}
