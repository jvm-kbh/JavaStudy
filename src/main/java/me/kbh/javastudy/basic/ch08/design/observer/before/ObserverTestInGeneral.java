package me.kbh.javastudy.basic.ch08.design.observer.before;

public class ObserverTestInGeneral {
    public static void main(String[] args) {
        Feed feed = new Feed();

        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());

        feed.notifyObservers("the queen said her favourite book is Java 8 in Action money wine");
    }
}
