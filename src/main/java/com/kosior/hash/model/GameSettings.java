package com.kosior.hash.model;

import java.util.ArrayList;
import java.util.List;

public class GameSettings {
    public int rows;
    public int columns;
    public int dronesNumber;
    public int maxTurnsNumber;
    public int maxDronePayload;
    public int numberOfProductTypes;
    public int numberOfWarehouse;
    public int numberOfOrders;

    public List<Integer> productTypesWeight = new ArrayList<>();
    public List<Warehouse> warehouses = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
}
