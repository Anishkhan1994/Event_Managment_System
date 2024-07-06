<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
<link rel="stylesheet" href="style.css" />
</head>
<body>
    <div class="menu-bar">
      <h1 class="logo">Light<span>Code.</span></h1>
      <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="#">Services <i class="fas fa-caret-down"></i></a>

            <div class="dropdown-menu">
                <ul>
                  <li><a href="corporate-events.html"></a>Corporate Event</li>
                  <li><a href="wedding-events.html">Wedding Event</a></li>
                  <li><a href="celebrity-management.html\">Celebrity Event</a></li>
                  <li><a href="pr-management.html">PR Event</a></li>
                </ul>
              </div>
            </li>
        </li>
        <li><a href="contact.html">Contact us</a></li>
      </ul>
    </div>
 <div class="center">
        <div class="form-container">
            <form action="login">
                <input type="text" placeholder="Enter user name" name="uname"/>
                <br><br>
                <input type="password" placeholder="Enter password" name="pass"/>
                <br><br>
                <input type="submit" value="Submit"/>        
            </form>
            <% 
                String message = request.getParameter("message");
                if(message != null) {
                    out.print("<p style='color:red'>"+message+"</p>");    
                }
            %>
        </div>
    </div>
</body>
</html>