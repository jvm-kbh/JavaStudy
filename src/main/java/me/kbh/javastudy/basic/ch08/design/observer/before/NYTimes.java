package me.kbh.javastudy.basic.ch08.design.observer.before;

public class NYTimes implements Observer{
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking New in Ny : " + tweet);
        }
    }
}
