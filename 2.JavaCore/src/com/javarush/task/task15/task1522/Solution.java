package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        String line = new Scanner(System.in).nextLine();
        if (line.equals(Planet.SUN)) {
            Sun sun = Sun.getInstance();
            thePlanet = sun;
        }else if (line.equals(Planet.MOON)){
            Moon moon = Moon.getInstance();
            thePlanet = moon;
        }else if (line.equals(Planet.EARTH)){
            Earth earth = Earth.getInstance();
            thePlanet = earth;
        }else thePlanet = null;
    }
}
