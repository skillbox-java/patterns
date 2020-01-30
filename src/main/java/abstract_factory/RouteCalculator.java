package abstract_factory;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculator {

  public static void main(String[] args) {
    List<Point> points = new ArrayList<>();
    points.add(new Point(102780, 37265));
    points.add(new Point(4523674, 478374));

    Route carRoute = RouteFactory.getRoute(
        new CarRouteFactory(points)
    );

    Route taxiRoute = RouteFactory.getRoute(
        new TaxiRouteFactory(points, 15, 20)
    );

    System.out.println("Car route duration: " +
        carRoute.calculateDuration() + " minutes");

    System.out.println("Taxi route duration: " +
        taxiRoute.calculateDuration() + " minutes");
  }
}
