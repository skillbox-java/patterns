package abstract_factory;

import java.awt.Point;
import java.util.List;

public class TaxiRoute extends Route {

  private double averageSpeed;
  private static final double taxiSpeedCoeff = 0.7;

  private double costPerKm;
  private double costPerMinute;

  public TaxiRoute(List<Point> points) {
    super(points);
  }

  public double calculateCost() {
    double priceForLength = costPerKm * calculateLength();
    double priceForDuration = costPerMinute * calculateDuration();

    return Math.min(priceForLength, priceForDuration);
  }

  public void setAverageSpeed(double averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  @Override
  public double calculateDuration() {
    return calculateLength() / averageSpeed;
  }

  @Override
  public double calculateLength() {
    double totalLength = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      totalLength += LengthCalculator.getLength(
          points.get(i), points.get(i + 1)
      );
    }
    return totalLength * taxiSpeedCoeff;
  }

  public void setCostPerKm(double costPerKm) {
    this.costPerKm = costPerKm;
  }

  public void setCostPerMinute(double costPerMinute) {
    this.costPerMinute = costPerMinute;
  }
}
