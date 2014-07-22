<!DOCTYPE html>
<html lang="en">
<head id="head">
    <title>Users</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css"/>
    <link href="/static/css/custom.css" rel="stylesheet" type="text/css"/>
</head>
<body id="body">

<!-- navbar -->
<div id="navbar" class="navbar navbar-default navbar-static-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">StarterApp</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/">Home</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div id="content" class="container">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">Add or Update User <span class="pull-right"><a href="/user">Add New</a></span></div>
            <div class="panel-body">
                <form role="form" method="post" action="/user">
                    <input type="hidden" name="id" value="${(user.id)!}"/>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="${(user.name)!}" class="form-control" placeholder="Name" required="true" autofocus="true"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" value="${(user.email)!}" class="form-control" placeholder="Email" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" value="${(user.username)!}" class="form-control" placeholder="Username" required="true"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" value="${(user.password)!}" class="form-control" placeholder="Password" required="true"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-md btn-primary btn-block" type="submit">Save</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">Current Users</div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Username</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list users as user>
                                <tr>
                                    <td>${(user.id)!}</td>
                                    <td>${(user.name)!}</td>
                                    <td>${(user.email)!}</td>
                                    <td>${(user.username)!}</td>
                                    <td>
                                        <a href="/user/${(user.id)!}" class="btn btn-xs btn-link pull-left">Edit</a>
                                        <form role="form" method="post" action="/user/${(user.id)!}">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            <button class="btn btn-xs btn-link" type="submit">Del</button>
                                        </form>
                                    </td>
                                </tr>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- scripts -->
<div id="scripts">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</div>
</body>
</html>
