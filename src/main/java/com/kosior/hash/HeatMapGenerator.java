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
            data[order.column][order.row] = 1;
        }

        for (Warehouse warehouse : gameSettings.warehouses) {
            data[warehouse.column][warehouse.row] = 6;
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
