/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mitesh
 */
public class ForgotPassword extends HttpServlet 
{
    
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
      response.sendRedirect("Login.html");
   }
   
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
       response.setContentType("text/html");
       String email=request.getParameter("email");
       String mobile=request.getParameter("mobile");
       PrintWriter out = response.getWriter();
       String password=null;
        try
        {
            Statement st= DBConnector.getStatement(); 
            String query="Select password From cj where email='"+email+"' "; 
           ResultSet rs=st.executeQuery(query);
            if (rs.next()) {
                 password = rs.getString(1);
                out.println("<html><body>");
                out.println("<script>");
                out.println("alert('Your password is: " + password + "');");
                out.println("window.location = 'Login.html';");
                out.println("</script>");
                out.println("</body></html>");
            }
             else
            {
                out.println("<script>");
                out.println("alert('Incorrect Email Entered. Please try again.');");
                out.println("window.history.back();"); // Redirects back to the form
                out.println("</script>");
            }
            
        }
        catch(SQLException e)
            {
               System.out.println(e);        
            }
       
            
   } 
}