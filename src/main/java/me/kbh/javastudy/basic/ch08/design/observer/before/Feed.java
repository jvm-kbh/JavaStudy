package me.kbh.javastudy.basic.ch08.design.observer.before;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject {

  private final List<Observer> observerList = new ArrayList<>();

  @Override
  public void registerObserver(Observer o) {
    this.observerList.add(o);
  }

  @Override
  public void notifyObservers(String tweet) {
    observerList.forEach(o -> o.notify(tweet));
  }
}
