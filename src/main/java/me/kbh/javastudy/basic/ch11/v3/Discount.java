package me.kbh.javastudy.basic.ch11.v3;

public class Discount {
  public enum Code {
    NONE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15),
    DIAMOND(20);

    private final int persentage;

    Code(int persentage) {
      this.persentage = persentage;
    }
  }

  public static String applyDiscount(Quote quoto) {
    return quoto.getShopName()
        + " price is "
        + Discount.apply(quoto.getPrice(), quoto.getDicountCode());
  }

  private static double apply(double price, Code code) {
    delay();
    return (price * 100 - code.persentage) / 100;
  }

  public static void delay() {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
