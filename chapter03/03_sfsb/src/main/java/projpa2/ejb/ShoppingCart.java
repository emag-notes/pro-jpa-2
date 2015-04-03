package projpa2.ejb;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanabe
 */
@Stateful
public class ShoppingCart {

  private Map<String, Integer> items = new HashMap<>();

  public void addItem(String item, int quantity) {
    Integer orderQuantity = items.get(item);
    if (orderQuantity == null) {
      orderQuantity = 0;
    }
    orderQuantity += quantity;
    items.put(item, orderQuantity);
  }

  public void removeItem(String item, int quantity) {
    Integer orderQuantity = items.get(item);
    if (orderQuantity == null) {
      return;
    }

    orderQuantity -= quantity;
    if (orderQuantity > 0) {
      items.put(item, orderQuantity);
    } else {
      items.remove(item);
    }
  }

  public Map<String, Integer> getItems() {
    return items;
  }

  @Remove
  public void checkout(int paymentId) {
    System.out.println("Payment ID:" + paymentId + " store items to database... " );
    items.clear();
  }

  @Remove
  public void cancel() {
    System.out.println("Canceled");
    items.clear();
  }

}
