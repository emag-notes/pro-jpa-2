package projpa2.servlet;

import projpa2.ejb.ShoppingCart;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

/**
 * @author tanabe
 */
@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

  @EJB
  private ShoppingCart shoppingCart;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, Integer> items = shoppingCart.getItems();
    response.getWriter().println(items);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    String item = request.getParameter("item");
    int quantity;
    try {
      quantity = Integer.parseInt(request.getParameter("quantity"));
    } catch (NumberFormatException e) {
      quantity = 0;
    }

    switch (action) {
      case "add":
        shoppingCart.addItem(item, quantity);
        break;
      case "remove":
        shoppingCart.removeItem(item, quantity);
        break;
      case "checkout":
        shoppingCart.checkout(Math.abs(new Random().nextInt()));
        break;
      case "cancel":
        shoppingCart.cancel();
        break;
      default:
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        break;
    }
  }

}
