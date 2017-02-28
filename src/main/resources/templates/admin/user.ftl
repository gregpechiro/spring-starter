<!DOCTYPE html>
<html lang="en">
	<head id="head">
		<title>Users</title>
	<#include "../includes/head.ftl"/>
	</head>
	<body id="body">

	<#include "../includes/admin-navbar.ftl"/>

		<!-- content -->
		<div id="content" class="container-fluid">

			<!-- add/edit -->
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">
						${(user??) ? string('Update', 'Add')} User
						<a href="/admin/user" class="btn btn-xs btn-default pull-right">${(user??) ? string('Cancel', 'Clear')}</a>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" method="post" action="/admin/user${(user??) ? string('/${(user.id?c)!}', '')}">
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
								<span class="text-danger col-xs-offset-4 col-xs-8">${(errors.password)!}</span>
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
			<!-- add/edit -->

			<!-- view all -->
			<div class="col-sm-8">
				<div class="panel panel-default">
					<div class="panel-heading">Current Users</div>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Email</th>
									<th>Role</th>
									<th>Active</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<#list users as user>
									<tr>
										<td>${(user.firstName)!} ${(user.lastName)!}</td>
										<td>${(user.username)!}</td>
										<td>${(user.role)?split('_')[1]?lower_case?cap_first!'N/A'}</td>
										<td>${(user.active == 1)?c}</td>
										<td>
											<a href="/admin/user/${(user.id)!}" class="btn btn-xs btn-primary">
												<i class="fa fa-pencil"></i>
											</a>
											<button data-message="Are you sure you would like to delete this user?" data-color="red" data-url="/admin/user/del/${(user.id)!}" data-type="warning" class="confirm-action btn btn-xs btn-danger">
												<i class="fa fa-trash-o"></i>
											</button>
										</td>
									</tr>
								</#list>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- view all -->

			<form id="delete-form" class="hide" action="" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>

		</div>
		<!-- content -->

		<#include "../includes/footer.ftl"/>

		<#include "../includes/scripts.ftl"/>

		<#include "../includes/alerts.ftl">

		<script src="/static/js/confirm.js"></script>

		<script src="/static/js/toggle-password.js"></script>

		<script>
			confirm.yes = function(btn) {
				$('form#delete-form').attr('action', btn.attr('data-url'));
				$('form#delete-form').submit();
			}
		</script>

	</body>
</html>