package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.Arrays;
import java.util.List;

/* 
Простая программа
*/

public class SymbolGame extends Game {
    private final String str = "JAVARUSH";

    @Override
    public void initialize() {
        setScreenSize(8,3);
//        setCellValueEx(0, 1, Color.ORANGE, "JAVARUSH");
        List<String> chList = Arrays.asList(str.split(""));
        for (int x = 0; x < chList.size(); x++) {
            setCellValueEx(x, 1, Color.ORANGE, chList.get(x));
        }
    }
}
