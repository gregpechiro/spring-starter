<!DOCTYPE html>
<html lang="en">
	<head id="head">
		<title>Home</title>
		<#include "../includes/head.ftl"/>
	</head>
	<body id="body">

		<#include "../includes/secure-navbar.ftl"/>

		<!-- content -->
		<div id="content" class="container">
			<div class="row">
				<!-- edit -->
				<div class="col-lg-6 col-lg-offset-3">
					<div class="panel panel-default">
						<div class="panel-heading">Edit My Information</div>
						<div class="panel-body">
							<form class="form-horizontal" role="form" method="post" action="/user">
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.firstName)!}</span>
									<label class="control-label col-xs-4">First Name</label>
									<div class="col-xs-8">
										<input type="text" id="firstName" name="firstName" value="${(user.firstName)!}" class="form-control" placeholder="First Name"/>
									</div>
								</div>
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.lastName)!}</span>
									<label class="control-label col-xs-4">Last Name</label>
									<div class="col-xs-8">
										<input type="text" id="lastName" name="lastName" value="${(user.lastName)!}" class="form-control" placeholder="Last Name"/>
									</div>
								</div>
								<div class="form-group">
									<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.username)!}</span>
									<label class="control-label col-xs-4">Email</label>
									<div class="col-xs-8">
										<input type="text" id="username" name="username" value="${(user.username)!}" class="form-control" placeholder="Email"/>
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
										*Leave blank to keep current password
									</div>
								</div>
								<!-- toggle show password input -->

								<input type="hidden" name="id" value="${(user.id)!}"/>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-md btn-primary btn-block" type="submit">Save</button>
							</form>
						</div>
					</div>
				</div>
				<!-- edit -->
			</div>
		</div>

		<!-- content -->

		<#include "../includes/footer.ftl"/>

		<#include "../includes/scripts.ftl"/>

		<#include "../includes/alerts.ftl">

		<sctipt src="/static/js/toggle-password.js"></sctipt>

	</body>
</html>
