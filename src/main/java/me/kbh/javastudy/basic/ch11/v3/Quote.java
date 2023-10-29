package me.kbh.javastudy.basic.ch11.v3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quote {
  private final String shopName;
  private final double price;
  private final Discount.Code dicountCode;

  public static Quote parse(String s) {
    String[] split = s.split(":");
    String shopName = split[0];
    double price = Double.parseDouble(split[1]);
    Discount.Code dicountCode = Discount.Code.valueOf(split[2]);
    return new Quote(shopName, price, dicountCode);
  }
}
