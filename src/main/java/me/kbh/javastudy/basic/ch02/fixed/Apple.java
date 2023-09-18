package me.kbh.javastudy.basic.ch02.fixed;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    String color;
    int weight;

    public Apple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public static List<Apple> appleFilter(List<Apple> list, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple e : list){
            if (p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("green"));
        inventory.add(new Apple("red"));
        inventory.add(new Apple("blue"));


        List<Apple> redAppleList = appleFilter(inventory, (Apple a) -> "red".equals(a.getColor()));
        List<Apple> istNotBlueAppleList = appleFilter(inventory, (Apple a) -> ! "blue".equals(a.getColor()));
        List<Apple> greenAppleList = appleFilter(inventory, new AppleGreenColorPredicate());
    }
}
