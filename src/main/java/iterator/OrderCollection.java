package iterator;

public interface OrderCollection {

  void addOrder(Order order);

  void removeOrder(Order order);

  OrderIterator iterator(DeliveryType deliveryType);
}
