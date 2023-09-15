package me.kbh.javastudy.basic.ch08.design.factory.after;

import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.util.*;
import java.util.function.Supplier;

public class ProductFactoryByLamda {

    final static Map<String, Supplier<String>> map = new HashMap<>();

    static {
        map.put("h", () -> "happy");
        map.put("s", () -> "sad");
    }

    public static String createProduct(String name) {
        Supplier<String> p = map.get(name);
        if(p != null) return p.get();
        throw new IllegalArgumentException("no such");
    }
}
