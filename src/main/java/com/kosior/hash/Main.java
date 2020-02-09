package com.kosior.hash;

import com.kosior.hash.model.GameSettings;

public class Main {

    private static GameSettings gameSettings;

    public static void main(String[] args) {
        gameSettings = InputReaderAndParser.readAndParseInput();
    }


}
