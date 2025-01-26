<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome & Home</title>
     <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
       /* General body styling */
       body {
  margin: 0;
  height: 100vh;
  background: linear-gradient(90deg, #ff7eb3, #ff758c, #ff6a6a);
  background-size: 300% 300%;
  animation: gradientAnimation 2s ease infinite;
}

@keyframes gradientAnimation {
  0% { background-position: 0% 50%; }
  50% { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}
        /* Navigation bar styles */
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        li {
            float: left;
        }

        .align {
            float: right;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        li a:hover {
            background-color: white;
        }

        .active {
            background-color: #04AA6D;
        }

        /* Centered logo */
        .center-image {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        /* Section styling */
        section {
            /*padding: 20px;*/
            text-align: center;
        }

        h1 {
            padding-top: 20px;
            font-size: 40px;
            color: #FFFFFF; /* Vibrant white for the new headings */
            margin-bottom: 20px;
            text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.7), 0 0 10px #FF5722; /* Subtle glow effect */
        }

        /* Styling for developers and researchers list */
        .developer-list, .researcher-list {
            display: inline-block;
            text-align: center;
            margin: 0 auto;
            padding: 15px;
            background: rgba(255, 255, 255, 0.1); /* Transparent white for background */
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            width: 300px;
        }

        .developer-list li, .researcher-list li {
            padding: 10px;
            font-size: 18px;
            line-height: 1.6;
            list-style-type: none; /* Remove bullet points */
            margin-bottom: 10px;
        }

        .developer-list a, .researcher-list a {
            color: #FFFFFF;
            font-weight: bold;
            text-decoration: none;
            background: #FFC107; /* Gold background for buttons */
            padding: 10px 15px;
            border-radius: 5px;
            display: block; /* Ensures the names are in a block format */
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        .developer-list a:hover, .researcher-list a:hover {
            background-color: #FF5722; /* Deep orange background on hover */
            color: #FFFFFF; /* Keep text white on hover */
            transform: scale(1.05); /* Slight zoom effect */
        }

        /* Add space between sections */
        .spacer {
            margin-top: 30px;
        }
        .carousel-inner {
      text-align: center;
      background-color: #f8f9fa;
      padding: 40px 0;
    }
    .carousel-inner .item {
/*      background-color: #FF5722;  Orange background for each slide */
  background: #a18cd1;
  
      color: white;
      padding: 50px;
      font-size: 24px;
      border-radius: 10px;
    }
    .carousel-indicators li {
      background-color: #a18cd1;
    }
    .search-container {
            margin-top: 30px;
            text-align: center;
        }

        .search-box {
            width: 50%;
            max-width: 600px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
            color: black;
        }

        .search-box input {
            width: 70%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .search-box button {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background-color: #FF5722;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-box button:hover {
            background-color: #FFC107; /* Golden hover effect */
        }

        /* Profile icon container */
        .profile-container {
            position: absolute;
            top: 20px;
            right: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .profile-icon {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background: #FFFFFF;
            color: #FF6A00;
            font-size: 1.5em;
            font-weight: bold;
            display: flex;
            justify-content: center;
            align-items: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, background-color 0.3s ease;
            cursor: pointer;
            text-decoration: none;
        }

        .profile-icon:hover {
            background: #FFD700;
            transform: scale(1.1);
        }

        .profile-container:hover .tooltip {
            display: block;
        }
        button
        {
            color: black;
            margin-top:20px;
        }
        .styled-button {
        background-color: #4CAF50; /* Green background */
        color: white; /* White text */
        padding: 10px 30px; /* Increased padding for larger size */
        font-size: 18px; /* Slightly larger font size */
        border: none; /* Remove border */
        border-radius: 5px; /* Rounded corners */
        cursor: pointer; /* Pointer cursor on hover */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        transition: background-color 0.3s, box-shadow 0.3s; /* Smooth transition */
        width: 200px; /* Explicit width */
        height: 60px; /* Explicit height */
        text-align: center; /* Center-align the text */
    }

    .styled-button:hover {
        background-color: #45a049; /* Darker green on hover */
        box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15); /* Enhanced shadow on hover */
    }
    .styled-button:active {
        background-color: #3e8e41; /* Even darker green when clicked */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Reduced shadow when clicked */
    } /* Reduced shadow when clicked */
      .website-heading {
    font-family: 'Arial', sans-serif; /* Choose a clean, modern font */
    font-size: 3em; /* Adjust size based on your design */
    font-weight: bold; /* Make the heading bold */
    color: #2C3E50; /* Choose a dark color for the text */
    text-align: center; /* Center the text */
    text-transform: uppercase; /* Make text all uppercase */
    letter-spacing: 2px; /* Add some space between letters */
    margin-top: 50px; /* Add space above the heading */
    margin-bottom: 20px; /* Add space below the heading */
    background: linear-gradient(90deg, #ff9966, #ff5e62, #00c6ff);
    padding: 20px; /* Add some padding around the text */
    border-radius: 10px; /* Optional: Add rounded corners */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Optional: Add shadow for depth */
}
    </style>
</head>
<body>
    <%
            
        String name="";
        String mobile = "";
        String course = "";
        String level = "";
        String password = "";
        String city = "";
        try{
             String email=(String) session.getAttribute("email");
             if(email==null)
         {
             response.sendRedirect("Login.html");
         }
            Statement st= DBConnector.getStatement(); 
            String query="SELECT * FROM cj WHERE email='"+email+"'";
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                 name = rs.getString(1);
                mobile = rs.getString(3);
                course = rs.getString(4);
                level = rs.getString(5);
                password = rs.getString(6);
                city = rs.getString(7);
            }
                
        }
        catch(SQLException e)
            {
               System.out.println(e);        
            }
            
        
          %>

    <!-- Navigation Bar -->
    <nav>
        <ul>
        <li><a href="#home" class="active">Home</a></li>
        <li><a href="#services">Services</a></li>
        <li><a href="#search">Search</a></li>
        <li><a href="#scholarship">Scholarship</a></li>
        <li><a href="#course">Course</a></li>
        <li><a href="#about">About Us</a></li>
    </ul>
        
    <section>
        <h1 class="website-heading">College Junction</h1>
    </section>
    <!-- Profile Icon -->
    <div class="profile-container">
        <a href="Profile.jsp">
            <div class="profile-icon">P</div>
        </a>
        <div class="tooltip">My Profile</div>
    </div>
    <section id="services">
        <div class="container">
  <h1 class="text-center" style="margin-top: 30px;">Our Services</h1>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      
      <div class="item active">
        <h3>College Search</h3>
        <p>Find the perfect college that fits your academic and personal goals.</p>
      </div>

      <div class="item">
        <h3>College Profiles</h3>
        <p>Explore detailed profiles of colleges to make informed decisions.</p>
      </div>
    
      <div class="item">
        <h3>Comparison Tool</h3>
        <p>Easily compare multiple colleges based on various factors.</p>
      </div>

      <div class="item">
        <h3>Personalized Recommendations</h3>
        <p>Get college recommendations tailored to your preferences and goals.</p>
      </div>

      <div class="item">
        <h3>Entrance Exam Information</h3>
        <p>Stay updated with the latest entrance exam schedules and requirements.</p>
      </div>
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
        <section id="search">
<!--        <div class="search-container">
-->            <h1>Search for Colleges</h1><!--
            <div class="search-box">
                <input type="text" placeholder="Enter college name" />
                <button type="button">Search</button>
            </div>
        </div>-->
           
        <form action="Collegedata" method="post">
            <input type="hidden" name="courses" value="<%=course%>">
            <input type="hidden" name="city" value="<%=city%>">
            <button type="submit" value="Colleges in my City" class="styled-button">Colleges in my City
            </button>
        </form>
            <form action="Search.html" method="post">
            <input type="hidden" name="courses" value="<%=course%>">
            <input type="hidden" name="city" value="<%=city%>">
            <button type="submit" value="Search" style="margin-top:30px" class="styled-button">Search College 
            </button>
        </form>
             </section>
            <section id="scholarship">
                <center><h1>Scholarship</h1></center>
            <form action="GovernmentScholarship" method="post">
<!--            <input type="hidden" name="courses" value="<%=course%>">
            <input type="hidden" name="city" value="<%=city%>">-->
            <button type="submit" class="styled-button">Government Scholarships
            </button>
        </form>
             <form action="PrivateScholarship" method="post">
<!--            <input type="hidden" name="courses" value="<%=course%>">
            <input type="hidden" name="city" value="<%=city%>">-->
            <button type="submit" class="styled-button">Private Scholarships
            </button>
        </form>
            </section>
                
            <section id="course">
                <center><h1>Course Overview</h1></center>
                <form action="Course" method="post">
            <input type="hidden" name="courses" value="<%=course%>">
            <!--<input type="hidden" name="city" value="<%=city%>">-->
            <button type="submit" class="styled-button">My Course Overview
            </button>
                </form>
            </section>
    <!-- About Section -->
    <section id="about">
        <h1>Developers</h1>
        <ul class="developer-list">
            <li><a href="https://www.linkedin.com/in/mitesh-parmar-a45190258/">Mitesh Parmar</a></li>
            <li><a href="https://www.linkedin.com/in/mohammed-babukhanwala-56b317258/">Mohammed Babukhanwala</a></li>
        </ul>

        <div class="spacer"></div>

        <h1>Research And Documentation</h1>
        <ul class="researcher-list">
            <li><a href="https://www.linkedin.com/in/nikhil-dhavarya-8b5aa8330/">Nikhil Dhavarya</a></li>
        </ul>
    </section>
</body>
</html>
