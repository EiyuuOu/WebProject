<%@page import="com.fdmgroup.model.Match"%>
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
						<th>Player 1</th>
						<th>Player 2</th>
						<th>Odds Player 1</th>
						<th>Odds Player 2</th>
						<th>Winner</th>
					</tr>
				</thead>
				<tbody>

						<%
					List<Match> matchList = (List<Match>)request.getSession().getAttribute("matchListe");
					
					for(Match match : matchList){
						
						out.println("<tr>");
						out.println("<td>"+match.getId()+"</td>");
						out.println("<td>"+match.getPlayerNameOne()+"</td>");
						out.println("<td>"+match.getPlayerNameTwo()+"</td>");
						out.println("<td>"+match.getOddsPlayerOne()+"</td>");
						out.println("<td>"+match.getOddsPlayerTwo()+"</td>");
						out.println("<td>"+match.getWinner()+"</td>");
						out.println("</tr>");
					} %>	
						

					
				</tbody>
				
			</table>
			
				<h1 class="major">Place Bet</h1>
				<form method="post" action="UserMatch">
				<input type="hidden" name="id" value="<%= session.getAttribute("id") %>"
								/>

					<div class="6u 12u$(xsmall)">
						<input type="text" name="matchId" id="matchId" value=""
							placeholder="Match ID" required />
					</div>
					</br>
					<div class="6u 12u$(xsmall)">
						<input type="text" name="player" id="player" value=""
							placeholder="Player Name" required />
					</div>
					</br>

					<div class="6u 12u$(xsmall)">
						<input type="text" name="amount" id="amount" value="" placeholder="Amount"
							required />
						<%
							if (request.getSession().getAttribute("betError") != null) {
								out.print("<label>" + request.getSession().getAttribute("betError") + "</label>");
							}
						%>
						<div class="12u$">
							<ul class="actions">
								<li><input type="hidden" name="hidden" value="update"/>
								<input type="submit" id="option" name="option" value="Update"
									class="special" /></li>
								<li><input type="hidden" name="hidden" value="delete"/>
								<input type="submit" id="option" name="option" value="Delete" class="special"/></li>
							</ul>
							<br>							
						</div>
					</div>
					</form>
					</br>


		</div>
		</div>
	

	<!-- Footer -->
	<%@include file="_footer.jsp"%>

</body>
</html>