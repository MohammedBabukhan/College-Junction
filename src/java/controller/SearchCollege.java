/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author mitesh
 */
public class SearchCollege extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
      response.sendRedirect("Registration.html");
   }
     
         
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String course = request.getParameter("courses");
    String city = request.getParameter("city");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>College Data</title>");
    out.println("<style>");
    out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f9f9f9; }");
    out.println("h1 { color: #333; }");
    out.println(".college-list { margin: 20px 0; padding: 0; list-style: none; }");
    out.println(".college-item { padding: 10px; background: #fff; border: 1px solid #ddd; margin-bottom: 10px; }");
    out.println(".college-item:hover { background: #f0f0f0; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    
    out.println("<h1>Colleges in " + city + " For "+course.toUpperCase()+"</h1>");
    out.println("<ul class='college-list'>");

    try {
        String url;
        if ("law".equalsIgnoreCase(course)) {
            url = "https://www.collegedekho.com/law-humanities/law-colleges-in-" + city + "/";
        } else {
            url = "https://www.collegedekho.com/" + course + "-colleges-in-" + city + "/";
        }

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select(".titleBar");

        elements.forEach(e -> {
            String collegeName = e.select(".titleSection>h3>a").text();
            out.println("<li class='college-item'>" + collegeName + "</li>");
        });

    } catch (Exception e) {
        out.println("<p style='color: red;'>Error fetching data: " + e.getMessage() + "</p>");
    }

    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
}

  /* public static void getData(String course,String city) throws Exception
    {
        String url="https://www.collegedekho.com/"+course+"-colleges-in-"+city+"/";
       Document doc= Jsoup.connect(url).get();
        Elements elements= doc.select(".titleBar");
        
        elements.forEach((e)->
        {
            System.out.println(e.select(".titleSection>h3>a").text());
            System.out.println("");
            System.out.println("");
            
        });
        
        
       
    }*/

}