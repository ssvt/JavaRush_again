package com.javarush.task.pro.task16.task1616;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        Set<String> setZOnes = ZoneId.getAvailableZoneIds();
        TreeSet<String> treeZone = new TreeSet<>();
        setZOnes.forEach(s -> {
            treeZone.add(s);
        });
        return treeZone;
    }

    static ZonedDateTime getBeijingDateTime() {
        ZonedDateTime pekinTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));

        return pekinTime;
    }
}
