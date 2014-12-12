<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
    <#include "../stubs/header.ftl"/>
		<style>textarea{resize: none;}</style>
	</head>
	<body>
    <#include "../stubs/default-navbar.ftl"/>
		<!-- *** beg content section *** -->
		<section id="content" class="container">
            <#include "../stubs/alerts.ftl"/>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="">
						<div class="panel panel-default translucent">
							<div class="panel-heading">
								<span class="lead">Password Reset</span>
							</div>
							<div class="panel-body">
								<form role="form" method="post" action="/reset/password">
									<div class="form-group">
                                    <label for="username">Account Email</label>
										<input id="username" type="email" name="username" class="form-control" placeholder="Email" required="true"/>
									</div>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									<button class="btn btn-md btn-block btn-primary" type="submit">Recover My Password</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- *** end content section *** -->
    <#include "../stubs/scripts.ftl"/>
    <#include "../stubs/footer.ftl"/>
	</body>
</html>
