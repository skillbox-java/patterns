package abstract_factory;

import java.awt.Point;
import java.util.List;

public class CarRouteFactory implements RouteAbstractFactory {

  private List<Point> points;

  public CarRouteFactory(List<Point> points) {
    this.points = points;
  }

  @Override
  public Route createRoute() {
    return new CarRoute(points);
  }
}
