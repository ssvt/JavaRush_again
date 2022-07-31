package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth() {
        return 80;
    }
    @Override
    public String getDescription() {
        return String.format("%s Моя страна - Moldova. Я несу %d яиц в месяц.",super.getDescription(), this.getCountOfEggsPerMonth());
    }
}
