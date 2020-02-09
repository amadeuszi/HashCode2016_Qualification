package com.kosior.hash;

import com.kosior.hash.model.GameSettings;

import org.tc33.jheatchart.HeatChart;

import java.io.File;
import java.io.IOException;

public class Main {

    private static GameSettings gameSettings;

    public static void main(String[] args) {
        gameSettings = InputReaderAndParser.readAndParseInput();
        HeatMapGenerator.generateHeatMap(gameSettings);
    }


}
