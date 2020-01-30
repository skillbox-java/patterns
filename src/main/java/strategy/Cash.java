package strategy;

public class Cash implements PaymentMethod {

  public Cash() {

  }

  @Override
  public boolean pay(int amount) {
    System.out.println("Will be payed later by cash");
    return false;
  }
}
