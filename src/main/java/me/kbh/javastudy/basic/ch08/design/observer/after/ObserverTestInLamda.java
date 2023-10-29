package me.kbh.javastudy.basic.ch08.design.observer.after;

import me.kbh.javastudy.basic.ch08.design.observer.before.Feed;
import me.kbh.javastudy.basic.ch08.design.observer.before.Observer;

public class ObserverTestInLamda {
  public static void main(String[] args) {
    Feed feed = new Feed();

    // 가능은 하나 이렇게 사용하지 않을 것이다.
    Observer queen =
        (String tweet) -> {
          if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another new in London... " + tweet);
          }
        };

    feed.registerObserver(queen);
  }
}
