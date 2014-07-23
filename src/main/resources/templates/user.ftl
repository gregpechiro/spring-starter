<!DOCTYPE html>
<html lang="en">
<head id="head">
    <title>Users</title>
    <#include "stubs/header.ftl">
</head>
    <body id="body">

        <#include "stubs/navbar.ftl">

        <!-- content -->
        <div id="content" class="container">
            <!-- add/edit -->
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
            <!-- add/edit -->
            <!-- view all -->
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
            <!-- view all -->
        </div>
        <!-- content -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
