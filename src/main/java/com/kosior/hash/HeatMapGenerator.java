package com.kosior.hash;

import com.kosior.hash.model.GameSettings;
import com.kosior.hash.model.Order;
import com.kosior.hash.model.Warehouse;
import org.tc33.jheatchart.HeatChart;

import java.io.File;
import java.io.IOException;

public class HeatMapGenerator {
    public static void generateHeatMap(GameSettings gameSettings) {

        double[][] data = new double[gameSettings.columns][gameSettings.rows];


        for (Order order: gameSettings.orders) {
            data[order.column][order.row] = Math.round((order.totalWeights + 0.0)/gameSettings.maxDronePayload);
            System.out.println(order.totalWeights);
        }

        for (Warehouse warehouse : gameSettings.warehouses) {
            data[warehouse.column][warehouse.row] = 10;
            data[warehouse.column-1][warehouse.row] = 10;
        //    data[warehouse.column+1][warehouse.row] = 1000;
        //    data[warehouse.column+1][warehouse.row+1] = 1000;
        //    data[warehouse.column+1][warehouse.row+1] = 1000;
            data[warehouse.column-1][warehouse.row-1] = 10;
            data[warehouse.column][warehouse.row-1] = 10;
        }

        HeatChart map = new HeatChart(data);

        map.setTitle("This is my heat chart title");
        map.setXAxisLabel("X Axis");
        map.setYAxisLabel("Y Axis");

        try {
            map.saveToFile(new File("java-heat-chart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    };
}
