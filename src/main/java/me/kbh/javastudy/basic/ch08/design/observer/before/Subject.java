package me.kbh.javastudy.basic.ch08.design.observer.before;

public interface Subject {
  void registerObserver(Observer o);

  void notifyObservers(String tweet);
}
