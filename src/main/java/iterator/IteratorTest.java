package iterator;

public class IteratorTest {

  public static void main(String[] args) {
    OrderCollectionImpl orders = new OrderCollectionImpl();
    generateOrders(orders);

    OrderIterator iterator = orders.iterator(DeliveryType.AIRPLANE);
    while (iterator.hasNext()) {
      Order order = iterator.next();
      System.out.println(order);
    }
  }

  public static void generateOrders(OrderCollectionImpl orders) {
    orders.addOrder(new Order(5670, DeliveryType.AIRPLANE));
    orders.addOrder(new Order(4637, DeliveryType.AIRPLANE));
    orders.addOrder(new Order(322, DeliveryType.BICYCLE_COURIER));
    orders.addOrder(new Order(331, DeliveryType.PEDESTRIAN_COURIER));
    orders.addOrder(new Order(905, DeliveryType.PICKUP));
    orders.addOrder(new Order(37881, DeliveryType.AIRPLANE));
    orders.addOrder(new Order(8960, DeliveryType.TRUCK));
    orders.addOrder(new Order(56, DeliveryType.PICKUP));
  }
}
