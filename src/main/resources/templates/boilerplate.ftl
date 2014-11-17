<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<#include "stubs/header.ftl"/>
	</head>
	<body>
		<#include "stubs/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<section id="content" class="container-fluid">
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Edit Something</h3>
						</div>
						<div class="panel-body">
							<form role="form">
								<div class="form-group">
									<label for="input-1">Input 1 Label</label>
									<input type="text" class="form-control" id="input-1" placeholder="Input 1">
								</div>
								<div class="form-group">
									<label for="input-2">Input 2 Label</label>
									<input type="text" class="form-control" id="input-2" placeholder="Input 2">
								</div>
								<div class="form-group">
									<label for="input-3">Input 3 Label</label>
									<input type="text" class="form-control" id="input-3" placeholder="Input 3">
								</div>
								<button type="submit" class="btn btn-primary btn-block">Submit Form</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">List Something</h3>
						</div>
						<div class="panel-body">
							Panel content
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- *** end content section *** -->

		<#include "stubs/scripts.ftl"/>
		<#include "stubs/footer.ftl"/>
	</body>
</html>
