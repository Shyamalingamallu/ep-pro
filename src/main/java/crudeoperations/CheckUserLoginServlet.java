package crudeoperations;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkuser")

public class CheckUserLoginServlet extends HttpServlet {
       
	 public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	  {
	      response.setContentType("text/html");
	      PrintWriter out=response.getWriter();
	     
	      String uid=request.getParameter("uid");
	      String upwd=request.getParameter("upwd");

	      
	      try
	      {
	        Connection con = DBConnection.getConnection();
	      
	        PreparedStatement pstmt = con.prepareStatement("select * from userregistration where id=? and password=?");
	        
	        pstmt.setString(1, uid);
	        pstmt.setString(2, upwd);
	        
	          ResultSet rs = pstmt.executeQuery();
	          if(rs.next())
	          {
	           response.sendRedirect("userhome");
	          }
	          else
	          {
	            response.sendRedirect("userlogin.html");
	          }
	        pstmt.close();
	        con.close();
	      }
	      catch(Exception e)
	      {
	        out.println(e);
	      }
	      
	  }
	}