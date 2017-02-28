<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Error ${(error)!}</title>
		<#include "includes/head.ftl"/>
	</head>
	<body>

		<#include "includes/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<div id="content" class="container">
			<div class="jumbotron transparent text-center">
				<h1>
					<span class="text-danger">
						<i class="fa fa-ambulance"></i> Oops!
					</span>
					<small>${(error)!}</small>
				</h1>
				<p>Maybe you should head back to higher ground</p>
			</div>
		</div>
		<!-- *** beg content section *** -->

		<#include "includes/footer.ftl"/>

	</body>
</html>
