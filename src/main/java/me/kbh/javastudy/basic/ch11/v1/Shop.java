package me.kbh.javastudy.basic.ch11.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Data
@AllArgsConstructor
public class Shop {
  public String product;

  public double getPrice(String product) {
    return calculatePrice(product);
  }

  private double calculatePrice(String product) {
    delay();
    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  public Future<Double> getPriceAsync(String product) {
    CompletableFuture<Double> futurePrice = new CompletableFuture<>();
    new Thread(
            () -> {
              try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
              } catch (Exception e) {
                futurePrice.completeExceptionally(e);
              }
            })
        .start();
    return futurePrice;
  }

  public Future<Double> getPriceAsyncSimple(String product) {
    return CompletableFuture.supplyAsync(() -> calculatePrice(product));
  }

  private void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
