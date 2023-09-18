package me.kbh.javastudy.basic.ch08.design.factory.before;

public class ProductFactoryByGeneral {
    public static String createProduct(String name) {
        switch (name) {
            case "h" :
                return "happy";
            case "s" :
            default:
                return "sad";
        }
    }
}
