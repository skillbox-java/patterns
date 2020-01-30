package strategy;

public class YandexMoney implements PaymentMethod {

  private String billNumber;

  public YandexMoney(String billNumber) {
    this.billNumber = billNumber;
  }

  @Override
  public boolean pay(int amount) {
    if (YandexMoneyOperator.charge(this, amount)) {
      System.out.println("Charge successful!");
      return true;
    }
    System.out.println("Error while charge YandexMoney");
    return false;
  }
}