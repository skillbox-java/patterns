package abstract_factory;

import java.awt.Point;
import java.util.List;

public class TaxiRouteFactory implements RouteAbstractFactory {

  private List<Point> points;
  private double costPerKm;
  private double costPerMinute;

  public TaxiRouteFactory(List<Point> points, double costPerKm, double costPerMinute) {
    this.points = points;
    this.costPerKm = costPerKm;
    this.costPerMinute = costPerMinute;
  }

  @Override
  public Route createRoute() {
    TaxiRoute route = new TaxiRoute(points);
    route.setCostPerKm(costPerKm);
    route.setCostPerMinute(costPerMinute);
    route.setAverageSpeed(SpeedProvider.getSpeed(
        points.get(0), points.get(points.size() - 1))
    );
    return route;
  }
}
