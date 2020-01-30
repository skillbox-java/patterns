package strategy;

import java.util.HashMap;

public class ShoppingCart {

  HashMap<Item, Integer> items;

  public ShoppingCart() {
    items = new HashMap<>();
  }

  public void addItem(Item item, int count) {
    if (items.containsKey(item)) {
      count = items.get(item) + count;
    }
    items.put(item, count);
  }

  public boolean pay(PaymentMethod paymentMethod) {
    int amount = 0;
    for (Item item : items.keySet()) {
      amount += item.getPrice() * items.get(item);
    }
    return paymentMethod.pay(amount);
  }
}
