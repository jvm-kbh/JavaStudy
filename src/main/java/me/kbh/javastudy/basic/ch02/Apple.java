package me.kbh.javastudy.basic.ch02;

import java.util.ArrayList;
import java.util.List;

public class Apple {

    String color;
    int weight;

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public static List<Apple> filterAppleList(List<Apple> inventory,
                                              String color,
                                              int weight,
                                              boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if((flag && apple.getColor().equals(color))
            || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return  result;
    }
}
