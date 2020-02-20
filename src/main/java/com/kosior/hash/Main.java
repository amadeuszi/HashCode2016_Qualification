package com.kosior.hash;

import com.kosior.hash.model.Data;


import java.util.ArrayList;
import java.util.List;

public class Main {

    private Data data;

    private int currentTurn = 0;

    private static List<String> output = new ArrayList<>();

    private void run() {
        data = InputReaderAndParser.readAndParseInput();
        // HeatMapGenerator.generateHeatMap(data);


    }


    public static void main(String[] args) {
        new Main().run();
    }
}
