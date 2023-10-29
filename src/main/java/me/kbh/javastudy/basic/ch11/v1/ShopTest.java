package me.kbh.javastudy.basic.ch11.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopTest {
  public static void main(String[] args) {
    Shop shop = new Shop("BestShop");
    long start = System.nanoTime();
    Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
    long invocationTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Invocation returned after " + invocationTime + " msecs");

    doSomethingElse();

    try {
      double price = futurePrice.get();
      System.out.printf("Price is %.2f%n", price);
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
    System.out.println("Price returned after " + retrievalTime + "m secs");
  }

  private static void doSomethingElse() {
    System.out.println("do something");
  }
}
