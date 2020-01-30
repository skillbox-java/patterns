package iterator;

import java.util.ArrayList;
import java.util.List;

public class OrderCollectionImpl implements OrderCollection {

  private List<Order> orders;

  public OrderCollectionImpl() {
    orders = new ArrayList<>();
  }

  @Override
  public void addOrder(Order order) {
    orders.add(order);
  }

  @Override
  public void removeOrder(Order order) {
    orders.remove(order);
  }

  @Override
  public OrderIterator iterator(DeliveryType deliveryType) {
    return new OrderIterator() {
      private int position = 0;

      @Override
      public boolean hasNext() {
        for (int i = position; i < orders.size(); i++) {
          Order order = orders.get(i);
          if (order.getDeliveryType().equals(deliveryType) ||
              order.getDeliveryType().equals(DeliveryType.ALL)) {
            return true;
          }
        }
        return false;
      }

      @Override
      public Order next() {
        while (position < orders.size()) {
          Order order = orders.get(position++);
          if (order.getDeliveryType().equals(deliveryType) ||
              order.getDeliveryType().equals(DeliveryType.ALL)) {
            return order;
          }
        }
        return null;
      }
    };
  }
}
