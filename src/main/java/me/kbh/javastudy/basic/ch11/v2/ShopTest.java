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
        //System.out.println(findPrices(shopList,"BestShop1")); //4s
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

    public static List<CompletableFuture<String>> findPricesByExecutor(List<Shop> shopList, String product, Executor executor) {
        return shopList.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProduct() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList());
    }

    // 각각 비동기적으로 계산하고 모든 비동기 동작이 끝나길 기다린다.
    // 단일 파이프라인으로 작성해버리면 모든 가격 정보요청이 동기적이고 순차적으로 이루어진다.
    // CompletableFuture로 각 상점의 정보를 요청해서 완료과 되어야 join()이 결과를 반환하면서 다음 상점의 정보를 요청할 수 있기 때문이다.
    // 반면 두개의 스트림으로 연산하면 독립적으로 각각 수행이 가능하다
    public static List<String> findPricesByExecutor2(List<Shop> shopList, String product, Executor executor) {
        return shopList.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getProduct() + " price is " + shop.getPrice(product), executor))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
