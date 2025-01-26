/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Mohammed Babukhan
 */
public class Course extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to registration page on a GET request
        response.sendRedirect("Registration.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the course parameter
        String course = request.getParameter("courses");
        out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Course Overview</title>");
out.println("<style>");
out.println("body { font-family: 'Arial', sans-serif; background: linear-gradient(45deg, #f3ec78, #af4261); margin: 0; padding: 0; color: #333; }");
out.println(".container { max-width: 800px; margin: 20px auto; background: #fff; border-radius: 10px; box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.2); padding: 20px; }");
out.println("h2 { color: #444; text-align: center; margin-bottom: 20px; font-size: 28px; }");
out.println("p { font-size: 18px; line-height: 1.8; margin: 15px 0; padding: 10px; background: #f9f9f9; border-radius: 5px; }");
out.println(".error { color: red; font-weight: bold; text-align: center; }");
out.println(".highlight { font-weight: bold; color: #ff5722; }");
out.println("footer { text-align: center; margin-top: 20px; font-size: 14px; color: #666; }");
out.println("@media (max-width: 600px) { h2 { font-size: 22px; } p { font-size: 16px; } }");
out.println("</style>");
out.println("</head>");
out.println("<body>");
out.println("<div class='container'>");
out.println("<h2>Course Overview</h2>");

        try {
            // Determine the URL based on the course
            String url = "";
            if ("btech".equalsIgnoreCase(course)) {
                url = "https://www.collegedekho.com/bachelor-of-technology-btech-course-cid";
                Document doc = Jsoup.connect(url).get();

            // Select the relevant elements
            Elements elements = doc.select(".collegeDetail_overview__Qr159 , .scrollTable");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
            else if("mtech".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/master-of-technology-mtech/syllabus-subjects";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
             else if ("bba".equalsIgnoreCase(course)) {
    url = "https://www.coursera.org/articles/bba";
    Document doc = Jsoup.connect(url).get();
    Elements elements = doc.select(".rc-RichText");

    if (elements.isEmpty()) {
        out.println("<p style='color: red;'>No data available for the selected course.</p>");
        return;
    }

    // Print course overview details
    elements.forEach(e -> {
        String courseOverview = e.select("p").text();

        // Split the overview into sentences and wrap each in <p> tags
        String[] sentences = courseOverview.split("\\. "); // Split by period followed by a space
        for (String sentence : sentences) {
            out.println("<p>" + sentence.trim() + ".</p>");
        }
    });
}

             else if ("mba".equalsIgnoreCase(course)) {
    url = "https://www.collegedekho.com/courses/master-of-business-administration-mba";
    Document doc = Jsoup.connect(url).get();
     Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
           else if("bca".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/bca";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
            
            else if("mca".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/mca-full-stack-development";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
            
            else if("bcom".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/bcom-banking-management";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
            
            else if("mcom".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/master-of-commerce-mcom";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
            
             else if("law".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/bsw-llb";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            }
             
            else if("ba".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/bachelor-of-fine-arts-bfa";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            } 
            
             else if("ma".equalsIgnoreCase(course)){
                 url = "https://www.collegedekho.com/courses/master-of-arts-ma";
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(".collegeDetail_overview__Qr159");
            if (elements.isEmpty()) {
                out.println("<p style='color: red;'>No data available for the selected course.</p>");
                return;
            }

            // Print course overview details
            
            elements.forEach(e -> {
                String courseOverview = e.select("p").text();
                out.println("<p>" + courseOverview + "</p>");
            });
            
            } 
            else {
                out.println("<p style='color: red;'>Invalid course provided or course not supported.</p>");
                return;
            }

            // Fetch and parse the web page
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            // Handle exceptions and display an error message
            out.println("<p style='color: red;'>Error fetching data: " + e.getMessage() + "</p>");
        } finally {
            out.close(); // Close the PrintWriter
        }
    }
}
