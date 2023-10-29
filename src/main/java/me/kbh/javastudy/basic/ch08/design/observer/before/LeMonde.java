package me.kbh.javastudy.basic.ch08.design.observer.before;

public class LeMonde implements Observer {
  @Override
  public void notify(String tweet) {
    if (tweet != null && tweet.contains("wine")) {
      System.out.println("Today chesse, wine and news! " + tweet);
    }
  }
}
