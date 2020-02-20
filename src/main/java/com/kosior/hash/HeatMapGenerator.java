package com.kosior.hash;

import com.kosior.hash.model.Data;
import org.tc33.jheatchart.HeatChart;

import java.io.File;
import java.io.IOException;

public class HeatMapGenerator {
    public static void generateHeatMap(Data data) {

        double[][] heatMapData = new double[data.columns][data.rows];



        HeatChart map = new HeatChart(heatMapData);

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
