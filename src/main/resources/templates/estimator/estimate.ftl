<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Project Estimator</title>
		<#include "../stubs/header.ftl"/>
	</head>
	<body>

		<#include "../stubs/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<section id="content" class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">Estimate Builder</div>
						<div class="panel-body">
							<form action="/estimator/add" method="post" role="form">
								<div class="form-group row">
									<div class="col-xs-8">
										<input type="text" name="name" class="form-control" placeholder="Name" required="true"/>
									</div>
									<div class="col-xs-4">
										<select name="size" class="form-control">
											<option value="0">0</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
										</select>
									</div>
								</div>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<button class="btn btn-md btn-primary btn-block" type="submit">Add Object</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-heading">Project Estimate Overview</div>
						<div class="panel-body">
							<form action="/estimator" method="post" role="form">
								<div class="form-group row">
									<div class="col-xs-4">
										<input type="number" name="roles" value="${(estimate.roles)!}"class="form-control" placeholder="Roles" required="true"/>
									</div>
									<div class="col-xs-4">
										<input type="number" name="users" value="${(estimate.users)!}" class="form-control" placeholder="Users" required="true"/>
									</div>
									<div class="col-xs-4">
										<input type="hidden" name="id" value="${(estimate.id)!}"/>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<button class="btn btn-md btn-primary btn-block" type="submit">Update</button>
									</div>
								</div>
							</form>
						</div>
						<table class="table table-responsive table-striped">
							<tbody>
								<#list estimate.objects as object>
									<tr>
										<td>${(object.name)!}</td>
										<td>${(object.size)!}</td>
										<td>
											<#switch object.size>
												<#case 1>
													<span class="label label-success">SM</span>
													<#break>
												<#case 2>
													<span class="label label-warning">MD</span>
													<#break>
												<#case 3>
													<span class="label label-danger">LG</span>
													<#break>
												<#default>
													<span class="label label-default">NA</span>
											</#switch>
										</td>
									</tr>
								</#list>
								<tr>
									<td colspan="2"></td>
									<td><strong>${(estimate.developmentCost?string.currency)!}</strong></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<!-- *** end content section *** -->

		<#include "../stubs/scripts.ftl"/>
		<#include "../stubs/footer.ftl"/>
	</body>
</html>
