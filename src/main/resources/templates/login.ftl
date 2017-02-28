<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Login</title>
		<#include "includes/head.ftl"/>
	</head>
	<body>

		<#include "includes/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<div id="content" class="container">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-1">
					<#if RequestParameters.error??>
						<div class="alert alert-danger alert-dismissable">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
							<p>There has been an error logging you in.</p>
						</div>
					</#if>
					<div class="panel panel-default translucent">
						<div class="panel-heading">Login</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form" method="post" action="/login">
								<div class="form-group">
									<label class="control-label col-xs-4">Email</label>
									<div class="col-xs-8">
										<input type="text" name="username" class="form-control" placeholder="Email" required/>
									</div>
								</div>

								<!-- toggle show password input -->
								<div class="form-group">
									<label class="control-label col-xs-4">Password</label>
									<div class="col-xs-8">
										<div class="input-group">
											<input type="password" id="password" name="password" class="form-control toggle-pass" placeholder="Password" />
											<span class="input-group-btn">
												<button type="button" class="btn btn-default toggle-pass" data-toggle="tooltip" data-placement="right" title="Click to show/hide your password">
													<i class="fa fa-eye-slash"></i>
												</button>
											</span>
										</div>
									</div>
								</div>
								<!-- toggle show password input -->

								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-block btn-primary" type="submit">Login</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-lg-offset-2">
					<div class="panel panel-default">
						<div class="panel-heading">Register</div>
						<div class="panel-body">
							<form role="form" class="form-horizontal" method="post" action="/register">
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.firstName)!}</span>
									<label class="control-label col-xs-4">First Name</label>
									<div class="col-xs-8">
										<input type="text" name="firstName" class="form-control" placeholder="First name"  value="${(user.firstName)!}"/>
									</div>
								</div>
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.lastName)!}</span>
									<label class="control-label col-xs-4">Last Name</label>
									<div class="col-xs-8">
										<input type="text" name="lastName" class="form-control" placeholder="Last Name"  value="${(user.lastName)!}"/>
									</div>
								</div>

								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.username)!}</span>
									<label class="control-label col-xs-4">Email</label>
									<div class="col-xs-8">
										<input type="text" name="username" class="form-control" placeholder="Email" value="${(user.username)!}"/>
									</div>
								</div>

								<!-- toggle show password input -->
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.password)!}</span>
									<label class="control-label col-xs-4">Password</label>
									<div class="col-xs-8">
										<div class="input-group">
											<input type="password" id="password" name="password" class="form-control toggle-pass" placeholder="Password" value="${(user.password)!}"/>
											<span class="input-group-btn">
												<button type="button" class="btn btn-default toggle-pass" data-toggle="tooltip" data-placement="right" title="Click to show/hide your password">
													<i class="fa fa-eye-slash"></i>
												</button>
											</span>
										</div>
									</div>
								</div>
								<!-- toggle show password input -->

								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-block btn-success" type="submit">Register</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- *** beg content section *** -->

		<#include "includes/footer.ftl"/>
		<#include "includes/scripts.ftl"/>
		<#include "includes/alerts.ftl"/>
		<script src="/static/js/toggle-password.js"></script>

	</body>
</html>
