<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Login</title>
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
						<h3 class="text-light">Please Login</h3>
						<div class="panel panel-default translucent">
							<div class="panel-body">
								<form role="form" method="post" action="/login">
									<div class="form-group">
										<input type="text" name="username" class="form-control" placeholder="Username" autofocus="true" required="true"/>
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
											<button class="btn btn-md btn-block btn-primary" type="submit">Login</button>
										</div>
										<div class="col-xs-4">
											<a href="/register" class="btn btn-block btn-success">Register</a>
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
