<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Register</title>
		<#include "stubs/header.ftl"/>
	</head>
	<body>

		<#include "stubs/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<section id="content" class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
				<#if RequestParameters.error??>
					<div class="alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<p>There has been an error logging you in.</p>
					</div>
				</#if>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Please Login</h3>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="/register">
								<div class="form-group">
									<input type="text" name="name" class="form-control" placeholder="Full Name" autofocus="true" required="true"/>
								</div>
								<div class="form-group">
									<input type="email" name="username" class="form-control" placeholder="Email" autofocus="true" required="true"/>
								</div>
								<div class="form-group">
									<input type="password" name="password" class="form-control" placeholder="Password" required="true"/>
								</div>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-md btn-block btn-success" type="submit">Register Account</button>
							</form>
							<br/>
							<p class="text-muted text-center">
								Have an account? <a href="/login">Login here</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- *** beg content section *** -->

		<#include "stubs/scripts.ftl"/>
		<#include "stubs/footer.ftl"/>

	</body>
</html>
