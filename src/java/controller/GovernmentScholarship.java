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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Mohammed Babukhan
 */
public class GovernmentScholarship extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Registration.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String url = "https://www.collegedekho.com/government-scholarships-csp-1";
            Document doc = Jsoup.connect(url).get();

            // Use a corrected and precise CSS selector
            Elements elements = doc.select(".scholarship_scholarshipCard__EdIeQ"); // Adjust based on structure

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Scholarship Data</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
            out.println("h1 { color: #333; text-align: center; margin-top: 20px; }");
            out.println("ul { list-style-type: none; padding: 0; margin: 20px auto; width: 80%; }");
            out.println("li { background-color: #fff; margin: 10px 0; padding: 15px; border-radius: 8px; ");
            out.println("    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); font-size: 18px; color: #555; }");
            out.println("li:hover { background-color: #e8f4fd; }");
            out.println(".container { max-width: 900px; margin: auto; padding: 20px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Government Scholarships</h1>");

            if (!elements.isEmpty()) {
                out.println("<ul>");
                for (Element element : elements) {
                    String scholarshipName = element.select("h3").text();
                    String link = element.select("a").attr("href");

                    // Print as a clickable list item
                    out.println("<li><a href='https://www.collegedekho.com" + link + "' target='_blank'>" + scholarshipName + "</a></li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p style='color: red; text-align: center;'>No scholarship data found.</p>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<p style='color: red; text-align: center;'>Error fetching data: " + e.getMessage() + "</p>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
