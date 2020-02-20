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
        System.out.println("hashcode");
        // HeatMapGenerator.generateHeatMap(data);


    }


    public static void main(String[] args) {
        new Main().run();
    }
}
