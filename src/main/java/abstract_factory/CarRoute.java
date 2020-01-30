package abstract_factory;

import java.awt.Point;
import java.util.List;

public class CarRoute extends Route {

  public CarRoute(List<Point> points) {
    super(points);
  }

  @Override
  public double calculateDuration() {
    double totalDuration = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      double length = LengthCalculator.getLength(
          points.get(i), points.get(i + 1)
      );
      totalDuration += length * SpeedProvider.getSpeed(
          points.get(i), points.get(i + 1)
      );
    }
    return totalDuration;
  }

  @Override
  public double calculateLength() {
    double totalLength = 0;
    for (int i = 0; i < points.size() - 1; i++) {
      totalLength += LengthCalculator.getLength(
          points.get(i), points.get(i + 1)
      );
    }
    return totalLength;
  }
}
