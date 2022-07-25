package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/**
 * @author Svyatoha Sergey
 * 25.07.2022
 */

public class KeyboardGame extends Game {

   /* private boolean mass[][] = {{false, false, false}, {false, false, false}, {false, false,false}};
    private boolean massUP[][] = {{true, false, false}, {true, false, false}, {true, false,false}};
    private boolean massDown[][] = {{false, false, true}, {false, false, true}, {false, false,true}};
    private boolean massLeft[][] = {{true, true, true}, {false, false, false}, {false, false,false}};
    private boolean massRight[][] = {{false, false, false}, {false, false, false}, {true, true,true}};*/

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

 /*   @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case UP: showMass(massUP);
                        break;
            case DOWN: showMass(massDown);
                        break;
            case LEFT: showMass(massLeft);
                        break;
            case RIGHT: showMass(massRight);
                        break;
            default: showMass(mass);
        }
    }
*/

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case UP:    setCellColor(0, 0, Color.GREEN);
                        setCellColor(1, 0, Color.GREEN);
                        setCellColor(2, 0, Color.GREEN);
                        break;
            case DOWN:  setCellColor(0, 2, Color.GREEN);
                        setCellColor(1, 2, Color.GREEN);
                        setCellColor(2, 2, Color.GREEN);
                        break;
            case LEFT:  setCellColor(0, 0, Color.GREEN);
                        setCellColor(0, 1, Color.GREEN);
                        setCellColor(0, 2, Color.GREEN);
                        break;
            case RIGHT: setCellColor(2, 0, Color.GREEN);
                        setCellColor(2, 1, Color.GREEN);
                        setCellColor(2, 2, Color.GREEN);
                        break;
//            default: showMass(mass);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT || key == Key.RIGHT || key == Key.UP || key == Key.DOWN){
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    setCellColor(x, y, Color.WHITE );
                }
            }
        }

    }

    /*public void showMass(boolean[][] mass){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                setCellColor(x, y, mass[x][y] ? Color.GREEN: Color.WHITE );
            }
        }
    }*/
}
