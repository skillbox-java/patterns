package abstract_factory;

public class RouteFactory {

  public static Route getRoute(RouteAbstractFactory factory) {
    return factory.createRoute();
  }
}