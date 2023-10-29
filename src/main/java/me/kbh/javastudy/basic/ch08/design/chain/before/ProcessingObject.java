package me.kbh.javastudy.basic.ch08.design.chain.before;

public abstract class ProcessingObject<T> {

  protected ProcessingObject<T> successor;

  public void setSuccessor(ProcessingObject<T> successor) {
    this.successor = successor;
  }

  public T handle(T input) {
    T r = handleWork(input);
    if (successor != null) {
      return successor.handle(r);
    }
    return r;
  }

  protected abstract T handleWork(T input);
}
