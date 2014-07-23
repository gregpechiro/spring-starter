<!DOCTYPE html>
<html lang="en">
	<head id="head">
		<title>Login Page</title>
        <#include "stubs/header.ftl">
	</head>
	<body id="body">

		<#include "stubs/navbar.ftl">

        <!-- content -->
        <div id="content" class="container">
            <div class="col-sm-offset-4 col-sm-4">
                <p class="lead">Please Login</p>
                <form role="form" method="post" action="/login">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="Username" required="true"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" required="true"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-md btn-primary btn-block" type="submit">Login</button>
                </form>
            </div>
        </div>
        <!-- content -->

	    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	</body>
</html>
