package projpa2.servlet;

import projpa2.ejb.LoggerBean;

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
@WebServlet("/logger")
public class LoggerServlet extends HttpServlet {

  @EJB
  private LoggerBean loggerBean;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String message = request.getParameter("message");
    loggerBean.logMessage(message);
    response.getWriter().println("please check server log");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
