package factory;

import java.awt.Point;
import java.util.List;

public class FigureFactory {

  public static Figure createFigure(List<Point> points) {
    int pointsCount = points.size();
    if (pointsCount < 2) {
      throw new IllegalArgumentException("Points count should be more than one!");
    }
    switch (pointsCount) {
      case 2:
        return new Line(points.get(0), points.get(1));
      case 3:
        return new Triangle(
            points.get(0), points.get(1), points.get(3)
        );
      case 4:
        return new Rectangle(
            points.get(0),
            points.get(1),
            points.get(2),
            points.get(3)
        );
      case 5:
        return new Pentagon(points);
      case 6:
        return new Hexagon(points);
      default:
        return new Polygon(points);
    }
  }


}
