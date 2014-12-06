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
					<div class="modal-panel">
						<h3 class="text-light">Register Account</h3>
						<div class="panel panel-default translucent">
							<div class="panel-body">
								<form role="form" method="post" action="/register">
									<div class="form-group row">
										<div class="col-xs-6">
											<input type="text" name="firstName" class="form-control" placeholder="First" autofocus="true" required="true"/>
										</div>
										<div class="col-xs-6">
											<input type="text" name="lastName" class="form-control" placeholder="Last" autofocus="true" required="true"/>
										</div>
									</div>
									<div class="form-group">
										<input type="email" name="username" class="form-control" placeholder="Email" autofocus="true" required="true"/>
									</div>
									<div class="form-group">
										<div class="input-group">
											<input type="password" id="toggle-pass" name="password" class="form-control"
												   placeholder="Password" required="true" />
											<span class="input-group-btn">
												<button id="toggle-pass" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="right"
															title="Click to show/hide your password">
													<i class="fa fa-eye-slash"></i>
												</button>
											</span>
										</div>
									</div>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<div class="form-group row">
										<div class="col-xs-8">
											<button class="btn btn-md btn-block btn-primary" type="submit">Register Account</button>
										</div>
										<div class="col-xs-4">
											<a href="/login" class="btn btn-block btn-success">Login</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- *** beg content section *** -->

		<#include "stubs/scripts.ftl"/>
		<script src="/static/js/toggle-password.js"></script>
		<#include "stubs/footer.ftl"/>

	</body>
</html>
