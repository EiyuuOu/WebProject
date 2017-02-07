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
				<h1 class="major">Change Balance</h1>
				<form method="post" action="AdminUser">
					
						<div class="6u$ 12u$(xsmall)">
							<input type="email" name="email" id="email" value=""
								placeholder="Email" required/>
												<% 
							if(request.getSession().getAttribute("email")!=null){
								out.print("<label>"+request.getSession().getAttribute("email")+"</label>");
							}
								
							%>
						</div>
						<br>
						<div class="6u 12u$(xsmall)">
							<input type="text" name="balance" id="balance" value=""
								placeholder="Balance" />
										<% 
							if(request.getSession().getAttribute("double")!=null){
								out.print("<label>"+request.getSession().getAttribute("double")+"</label>");
							}
								
							%>
						</div>
						</br>
						
						<div class="12u$">
							<ul class="actions">
								<li><input type="submit" value="Submit"
									class="special" /></li>
								<li><input type="reset" value="Reset" /></li>
							</ul>
							<% 
							if(request.getSession().getAttribute("success")!=null){
								out.print("<label>"+request.getSession().getAttribute("success")+"</label>");
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