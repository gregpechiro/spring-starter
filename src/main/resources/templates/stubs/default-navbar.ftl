<!-- *** beg default-navbar injection *** -->
<#import "global.ftl" as global>
<div id="navbar" class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">
				<i class="fa fa-leaf"></i> ${global.project}
			</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/login">Login</a></li>
				<li><a href="/login">Register</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- *** end default-navbar injection *** -->