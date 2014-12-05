<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<#include "stubs/header.ftl"/>
	</head>
	<body>

		<#include "stubs/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<section id="content" class="container">
			<div class="row">
				<div class="jumbotron transparent">
					<h1><i class="fa fa-cogs"></i> ${app.name}</h1>
					<p class="lead">${app.description}</p>
					<p><a href="/estimator" class="btn btn-lg btn-success">Go to Estimator</a></p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default translucent">
					<div class="panel-heading">About ${app.name}</div>
					<div class="panel-body">
						A simple, clean, starting workspace for your next spring-boot project. A project estimator is
						built in so you can quickly plan out your next application and start building it out.
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default translucent">
					<div class="panel-heading">Contact Us</div>
					<div class="panel-body">
						${app.name} <br/>
						123 Example Drive <br/>
						Some City, ST 98765 <br/>
						<a href="mailto:contact@example.com">contact@example.com</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default translucent">
					<div class="panel-heading">Quick Links</div>
					<div class="panel-body">
						<a href="/terms">View Terms & Conditions</a> <br/>
						<a href="/privacy">Our Privacy Policy</a> <br/>
						<a href="/register">Register an Account</a> <br/>
						<a href="/login">Login to Your Account</a> <br/>
					</div>
				</div>
			</div>
		</section>
		<!-- *** end content section *** -->

		<#include "stubs/scripts.ftl"/>
		<#include "stubs/footer.ftl"/>
	</body>
</html>
