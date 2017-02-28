<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
    <#include "../includes/head.ftl"/>
		<style>textarea{resize: none;}</style>
	</head>
	<body>
    <#include "../includes/default-navbar.ftl"/>
		<!-- *** beg content section *** -->
		<div id="content" class="container">
            <#include "../includes/alerts.ftl"/>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-4">
					<div class="panel panel-default translucent">
						<div class="panel-heading">
							<span class="lead">Password Reset</span>
						</div>
						<div class="panel-body">
							<div id="spinner" class="text-center hide">
								<p class="lead">
									<strong>Processing...</strong><br/>
								</p>
								<i class="fa fa-5x fa-circle-o-notch fa-spin"></i>
								<p class="lead">One moment please.</p>
							</div>
							<form id="password-reset" role="form" method="post" action="/reset/password">
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
		<!-- *** end content section *** -->
    <#include "../includes/scripts.ftl"/>
    <#include "../includes/footer.ftl"/>
    <script>
        (function(){
			$('form[id="password-reset"]').on('submit',function(){
				$(this).addClass('hide');
				$('div[id="spinner"]').removeClass('hide');
			});
        })();
    </script>
	</body>
</html>
