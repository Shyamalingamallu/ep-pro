package crudeoperations;
import java.sql.*;

public class DBConnection 
{    static Connection con = null;

  public static Connection getConnection() 
  {
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver Class Loaded");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/klu?useSSL=false","root", "Momdadlove@04");
    System.out.println("Connection Established Successfully");
    }
    
    catch(Exception e)
    {
      System.out.println(e);
      
    }
    return con;
    
  }
  
  

}