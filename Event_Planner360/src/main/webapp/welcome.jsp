<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		String uname = (String)session.getAttribute("uname");
		out.print(uname);
		if(uname==null) {
			response.sendRedirect("login.jsp");
		}
		
	%>
	<h1>Welcome</h1>
	<p><a href="dashboard.jsp">Dash board</a></p>
	
	
	<form action="logout">
		<input type="submit" value="Logout"/>
	</form>

</body>
</html>