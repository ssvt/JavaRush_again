package com.javarush.task.task14.task1408;

public class RussianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }

    @Override
    public String getDescription() {
        return String.format("%s Моя страна - Russia. Я несу %d яиц в месяц.",super.getDescription(), this.getCountOfEggsPerMonth());
    }
}
