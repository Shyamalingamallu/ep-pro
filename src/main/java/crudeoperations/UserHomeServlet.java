package crudeoperations;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/userhome")
public class UserHomeServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      
      //out.println("You are in Admin Home");
      RequestDispatcher rd = request.getRequestDispatcher("userhome.html");
      rd.include(request, response);

  }
}