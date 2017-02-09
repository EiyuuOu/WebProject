<%@page import="com.fdmgroup.model.Player"%>
<%@page import="java.util.List"%>
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



	
	<div class="inner">
		<h1>Here's a list of all Players in the Tournament</h1>
		<h3>Alternate</h3>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Username</th>
						<th>Team</th>
						<th>Nationality</th>
						<th>Race</th>
					</tr>
				</thead>
				<tbody>

											<%
					List<Player> playerList = (List<Player>)request.getSession().getAttribute("liste");
					
					for(Player player : playerList){
						
						out.println("<tr>");
						out.println("<td>"+player.getId()+"</td>");
						out.println("<td>"+player.getFirstname()+" "+player.getLastname()+"</td>");
						out.println("<td>"+player.getAge()+"</td>");
						out.println("<td>"+player.getUsername()+"</td>");
						out.println("<td>"+player.getTeam()+"</td>");
						out.println("<td>"+player.getNationality()+"</td>");
						out.println("<td>"+player.getRace()+"</td>");
						out.println("</tr>");
					} %>		

					
				</tbody>
				
			</table>


		</div>
		</div>
	

	<!-- Footer -->
	<%@include file="_footer.jsp"%>

</body>
</html>