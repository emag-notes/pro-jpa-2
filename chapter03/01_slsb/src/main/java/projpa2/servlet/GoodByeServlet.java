package projpa2.servlet;

import projpa2.ejb.GoodByeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tanabe
 */
@WebServlet("/goodbye")
public class GoodByeServlet extends HttpServlet {

  @EJB
  private GoodByeService goodByeService;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    response.getWriter().println(goodByeService.sayGoodBye(name));
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
