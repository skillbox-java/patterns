package adapter;

import java.util.Date;
import java.util.List;

public class CustomerDataObject implements DataObject {

  private Customer customer;

  private static long millisecondsInMonth = 30 * 24 * 3600 * 1000L;
  private static long millisecondsInYear = 365 * 24 * 3600 * 1000L;

  public CustomerDataObject(Customer customer) {
    this.customer = customer;
  }

  @Override
  public double getValue(String fieldName) {
    switch (fieldName) {
      case "callsPerMonth":
        return calculateCallsPerLastMonth();
      case "callsPerYear":
        return calculateCallsPerLastYear();
      case "minutesPerMonth":
        return calculateMinutesPerLastMonth();
      default:
        throw new IllegalArgumentException(
            "Field " + fieldName + " doesn't exist!"
        );
    }
  }

  private double calculateCallsPerLastMonth() {
    Date now = new Date();
    Date monthAgo = new Date(now.getTime() - millisecondsInMonth);
    return customer.getCallsCount(now, monthAgo);
  }

  private double calculateCallsPerLastYear() {
    Date now = new Date();
    Date yearAgo = new Date(now.getTime() - millisecondsInYear);
    return customer.getCallsCount(now, yearAgo);
  }

  private double calculateMinutesPerLastMonth() {
    Date now = new Date();
    Date monthAgo = new Date(now.getTime() - millisecondsInMonth);
    List<Call> calls = customer.getCalls(now, monthAgo);
    int minutes = 0;
    for (Call call : calls) {
      minutes += call.getDuration();
    }
    return minutes;
  }
}