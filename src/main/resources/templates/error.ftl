<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Error ${(error)!}</title>
		<#include "stubs/header.ftl"/>
	</head>
	<body>

		<#include "stubs/default-navbar.ftl"/>

		<!-- *** beg content section *** -->
		<section id="content" class="container">
			<div class="jumbotron transparent text-center">
				<h1>
					<span class="text-danger">
						<i class="fa fa-ambulance"></i> Oops!
					</span>
					<small>${(error)!}</small>
				</h1>
				<p>Maybe you should head back to higher ground</p>
			</div>
		</section>
		<!-- *** beg content section *** -->

		<#include "stubs/footer.ftl"/>

	</body>
</html>
