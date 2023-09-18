package me.kbh.javastudy.basic.ch08.design.observer.before;

public class Guardian implements Observer{
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet another new in London... " + tweet);
        }
    }
}
