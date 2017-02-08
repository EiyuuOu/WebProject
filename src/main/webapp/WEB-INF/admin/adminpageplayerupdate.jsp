<!DOCTYPE HTML>
<!--
	Hyperspace by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Generic - Hyperspace by HTML5 UP</title>
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

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		  <section id="main" class="wrapper">
			<div class="inner"> 
				<h1 class="major">Update Player</h1>
				<form method="post" action="AdminPlayerUpdate">

					<div class="6u 12u$(xsmall)">
						<input type="text" name="username" id="username" value=""
							placeholder="Username" required />
							<%
						if (request.getSession().getAttribute("noUsername") != null) {
							out.print("<label>" + request.getSession().getAttribute("noUsername") + "</label>");
						}
					%>
					</div>
					<br>
					<br>
					<br>
					<div class="6u 12u$(xsmall)">
						<input type="text" name="firstname" id="firstname" value=""
							placeholder="First Name" required />
					</div>
					</br>
					<div class="6u 12u$(xsmall)">
						<input type="text" name="lastname" id="lastname" value=""
							placeholder="Last Name" required />
					</div>
					</br>

					<div class="6u 12u$(xsmall)">
						<input type="text" name="age" id="age" value="" placeholder="Age"
							required />
						<%
							if (request.getSession().getAttribute("ageNumber1") != null) {
								out.print("<label>" + request.getSession().getAttribute("ageNumber1") + "</label>");
							}
						%>
					</div>
					</br>

					<div class="6u 12u$(xsmall)">
						<input type="text" name="team" id="team" value=""
							placeholder="Team" required />
					</div>
					</br>
					<div class="6u 12u$(xsmall)">
						<input type="text" name="nationality" id="nationality" value=""
							placeholder="Nationality" required />
					</div>
					</br>


					<div class="4u 12u$(small)">
						<input type="radio" id="Terran" name="race" value="Terran">
						<label for="Terran">Terran</label>
					</div>
					<div class="4u 12u$(small)">
						<input type="radio" id="Zerg" name="race" value="Zerg"> <label
							for="Zerg">Zerg</label>
					</div>
					<div class="4u$ 12u$(small)">
						<input type="radio" id="Protoss" name="race" value="Protoss">
						<label for="Protoss">Protoss</label>
					</div>
					<div class="4u 12u$(small)">
						<input type="radio" id="Random" name="race"  value="Random" checked>
						<label for="Random">Random</label>
					</div>
					

					<%
						if (request.getSession().getAttribute("playeradded") != null) {
							out.print("<label>" + request.getSession().getAttribute("playeradded") + "</label>");
						}
					%>

				<br>
					<div class="12u$">
							<ul class="actions">
								<li>
								<input type="submit" id="option1" name="option1" value="Update"
									class="special" /></li>
								<li>
								<input type="submit" id="option1" name="option1" value="Delete" class="special"/></li>
							</ul>
							<br>
							<% 
							if(request.getSession().getAttribute("playerupdated")!=null){
								out.print("<label>"+request.getSession().getAttribute("playerupdated")+"</label>");
							}
								
							%>
							<% 
							if(request.getSession().getAttribute("playerdeleted")!=null){
								out.print("<label>"+request.getSession().getAttribute("playerdeleted")+"</label>");
							}
								
							%>
							
						</div>
				</form>



			</div>
		  </section>

	</div> 
	<!-- Footer -->
	<footer id="footer" class="wrapper alt">
		<div class="inner">
			<ul class="menu">
				<li>&copy; Untitled. All rights reserved.</li>
				<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
	</footer>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>