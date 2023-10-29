package me.kbh.javastudy.basic.ch08.design.chain.before;

public class HeaderTextProcessing extends ProcessingObject<String> {

  @Override
  protected String handleWork(String input) {
    return "From Raoul, Mario and Alan: " + input;
  }
}
