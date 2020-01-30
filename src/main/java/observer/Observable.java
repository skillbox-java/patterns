package observer;

import java.util.HashSet;

public class Observable {

  private HashSet<Observer> observers;

  public void subscribe(Observer observer) {
    observers.add(observer);
  }

  public void unsubscribe(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    observers.forEach(observer -> observer.update());
  }
}