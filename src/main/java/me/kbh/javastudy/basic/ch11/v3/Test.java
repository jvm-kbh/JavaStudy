package me.kbh.javastudy.basic.ch11.v3;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Test {
    static List<Shop> shopList = Arrays.asList(
            new Shop("BestShop1"),
            new Shop("BestShop2"),
            new Shop("BestShop3"),
            new Shop("BestShop4")
    );

    static final Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
                }
            }
    );

    public static void main(String[] args) {
        String product = "BestShop1";

        List<String> discountList = shopList.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());

        List<CompletableFuture<String>> priceFutures =
                shopList.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(
                                        () -> Discount.applyDiscount(quote), executor)))
                        .collect(toList());

        List<String> resultList = priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());


        //독립 CompletableFuture와 비독립 CompletableFuture 합치기
        /*Future<Double> futurePriceInUSD =
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(
                                CompletableFuture.supplyAsync(
                                        () -> exchangeService.getRate(Money.EUR, Money.USD)), (price, rate) -> price * rate
                        );*/

        /*Future<Double> futurePriceInUSD =
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(
                                CompletableFuture.supplyAsync(
                                        () -> exchangeService.getRate(Money.EUR, Money.USD)),
                                (price, rate) -> price * rate)
                        .orTimeout(3, TimeUnit.SECONDS);*/

        /*Future<Double> futurePriceInUSD =
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                        .thenCombine(
                                CompletableFuture.supplyAsync(
                                                () -> exchangeService.getRate(Money.EUR, Money.USD))
                                        .completeOnTimeout(DEFAULT_RATE, 1 , TimeUnit.SECONDS), // 정해둔 환율로 계산
                                (price, rate) -> price * rate)
                        .orTimeout(3, TimeUnit.SECONDS);*/
        Stream<CompletableFuture<String>> findPriceStream = shopList.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor)));

        CompletableFuture[] futures = findPriceStream
                .map(f -> f.thenAccept(System.out::println))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
    }
}
