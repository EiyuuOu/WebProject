<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Betting Site</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
	</head>
<body>

<!-- Header -->
<%@include file="_header.jsp"%>
 
<% 
String  str2  = (String) session.getAttribute("str4");   

%>

					<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>Success!</h1>
							<h2> <%= str2
											%> </h2>
							
							<br>
							<h3>View upcoming Matches <a href="upcomingmatches.jsp">here</a></h3>
							
						</div>
					</section>

<!-- Footer -->
<%@include file="_footer.jsp"%> 

</body>
</html>