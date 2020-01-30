package strategy;

public class CreditCard implements PaymentMethod {

  private String cardNumber;
  private String cardHolder;
  private String expirationDate;
  private String cvvCode;

  public CreditCard(String cardNumber, String cardHolder, String expirationDate) {
    this.cardNumber = cardNumber;
    this.cardHolder = cardHolder;
    this.expirationDate = expirationDate;
  }

  public void setCvvCode(String cvvCode) {
    this.cvvCode = cvvCode;
  }

  @Override
  public boolean pay(int amount) {
    if (BankConnection.transferMoney(this, amount)) {
      System.out.println("Payed with credit card");
      return true;
    }
    System.out.println("Some error occured :(");
    return true;
  }
}
