package me.kbh.javastudy.basic.ch11.v2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ShopTest {

    public static void main(String[] args) {
        List<Shop> shopList = Arrays.asList(
                new Shop("BestShop1"),
                new Shop("BestShop2"),
                new Shop("BestShop3"),
                new Shop("BestShop4")
        );

        final Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        return t;
                    }
                }
        );

        long start = System.nanoTime();
        //System.out.println(findPrices(shopList,"BestShop1")); 4s
        //System.out.println(findPricesByStream(shopList,"BestShop1")); 1s
        System.out.println(findPricesByExecutor(shopList, "BestShop1", executor));

        long doneTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("done " + doneTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("do something");
    }

    public static List<String> findPrices(List<Shop> shopList, String product) {
        return shopList.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getProduct(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesByStream(List<Shop> shopList, String product) {
        return shopList.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getProduct(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesByExecutor(List<Shop> shopList, String product, Executor executor) {
        return shopList.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProduct() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
