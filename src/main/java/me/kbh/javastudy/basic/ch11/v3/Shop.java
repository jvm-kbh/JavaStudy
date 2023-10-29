package me.kbh.javastudy.basic.ch11.v3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Data
@AllArgsConstructor
public class Shop {
  public String product;

  public String getPrice(String product) {
    Random random = new Random();
    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
    return String.format("%s:%.2f:%s", product, price, code);
  }

  private double calculatePrice(String product) {
    delay();
    Random random = new Random();
    return random.nextDouble() * product.charAt(0) + product.charAt(1);
  }

  private void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
