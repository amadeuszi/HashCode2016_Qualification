package com.kosior.hash;

import com.kosior.hash.model.Dron;
import com.kosior.hash.model.GameSettings;

import com.kosior.hash.model.Order;
import com.kosior.hash.model.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static GameSettings gameSettings;

    private static int currentTurn = 0;

    private static List<String> output = new ArrayList<>();

    private void run() {
        gameSettings = InputReaderAndParser.readAndParseInput();
        // HeatMapGenerator.generateHeatMap(gameSettings);

        // gameSettings.orders.sort((o1, o2) -> Integer.compare(distance(gameSettings.warehouses.get(0), o1), distance(gameSettings.warehouses.get(0), o2)));
        gameSettings.orders.sort(Main::compareOrders);

        while (currentTurn < gameSettings.maxTurnsNumber) {

            for (Dron dron : gameSettings.drones) {
                if (dron.isFinishUnloading(currentTurn)) {
                    dron.currentOrder = null;
                }

                if (dron.isAvailable(currentTurn)) {
                    Order order = this.findOrder();

                    if (order == null) {
                        break;
                    }

                    dron.currentOrder = order;

                    handleOrder(dron, gameSettings.warehouses.get(0));

                    gameSettings.orders.sort(Main::compareOrders);
                }
            }

            currentTurn++;
        }

        System.out.println(output.size());
        for (String s : output) {
            System.out.println(s);
        }
    }

    private void handleOrder(Dron dron, Warehouse warehouse) {
        int totalWeight = 0;
        dron.finishTime = currentTurn + this.distance(dron, warehouse);

        for (Integer productId : dron.currentOrder.productsNeeded.keySet()) {
            int amountToTake = dron.currentOrder.productsNeeded.get(productId);
            int ordered = amountToTake;

            while (amountToTake * gameSettings.productTypesWeight.get(productId) > (gameSettings.maxDronePayload - totalWeight)) {
                amountToTake--;
            }

            if (amountToTake > 0) {
                output.add(dron.id + " L " + warehouse.id + " " + productId + " " + amountToTake);
                totalWeight += amountToTake * gameSettings.productTypesWeight.get(productId);

                int remain = ordered - amountToTake;

                dron.currentOrder.productsNeeded.replace(productId, remain);

                dron.products.put(productId, amountToTake);
                dron.finishTime++;
            }
        }

        dron.currentOrder.productsNeeded.values().removeIf(v -> v == 0);

        dron.row = warehouse.row;
        dron.column = warehouse.column;
        dron.finishTime += distance(dron, dron.currentOrder);

        for (Integer productId : dron.products.keySet()) {
            dron.finishTime++;
            output.add(dron.id + " D " + dron.currentOrder.id + " " + productId + " " + dron.products.get(productId));
        }

        dron.row = dron.currentOrder.row;
        dron.column = dron.currentOrder.column;

        recalculate(dron.currentOrder);
    }

    private int distance(Dron dron, Warehouse warehouse) {
        int diffRow = dron.row - warehouse.row;
        int diffColumn = dron.column - warehouse.column;

        return (int) Math.round(Math.ceil(Math.sqrt(diffColumn * diffColumn + diffRow * diffRow)));
    }

    private int distance(Dron dron, Order order) {
        int diffRow = dron.row - order.row;
        int diffColumn = dron.column - order.column;

        return (int) Math.round(Math.ceil(Math.sqrt(diffColumn * diffColumn + diffRow * diffRow)));
    }

    private static int distance(Warehouse warehouse, Order order) {
        int diffRow = warehouse.row - order.row;
        int diffColumn = warehouse.column - order.column;

        return (int) Math.round(Math.ceil(Math.sqrt(diffColumn * diffColumn + diffRow * diffRow)));
    }

    private Order findOrder() {
        for (Order order : gameSettings.orders) {
            if (order.isDone()) {
                continue;
            }

            return order;
        }

        return null;
    }

    public static int compareOrders(Order o1, Order o2) {
        return Double.compare(orderPriority(o1), orderPriority(o2));
    }

    public static double orderPriority(Order order) {
        return (order.totalWeights / ((double) gameSettings.maxDronePayload)) * distance(gameSettings.warehouses.get(0), order);
    }

    public static void recalculate(Order order) {
        order.totalWeights = 0;
        for (var productId : order.productsNeeded.keySet()) {
            order.totalWeights += gameSettings.productTypesWeight.get(productId) * order.productsNeeded.get(productId);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
