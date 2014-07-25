<!DOCTYPE html>
<html lang="en">
<head id="head">
    <title>Users</title>
    <#include "../stubs/header.ftl">
</head>
    <body id="body">

        <#include "../stubs/navbar.ftl">

        <!-- content -->
        <div id="content" class="container">
            <!-- add/edit -->
            <div class="col-sm-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Add or Update User <span class="pull-right"><a href="/secure/user">Add New</a></span></div>
                    <div class="panel-body">
                        <form role="form" method="post" action="/secure/user">
                            <#if user??>
                                <div class="form-group">
                                    <label>Created On:</label><span> ${(user.creationDate?string.medium)!}</span> <br/>
                                    <label>Last Seen:</label><span> ${(user.lastSeenDate?string.medium)!}</span>
                                </div>
                            </#if>
                            <div class="form-group">
                                <input type="text" id="name" name="name" value="${(user.name)!}" class="form-control" placeholder="Name" required="true" autofocus="true"/>
                            </div>
                            <div class="form-group">
                                <input type="email" id="email" name="email" value="${(user.email)!}" class="form-control" placeholder="Email" required="true"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="username" name="username" value="${(user.username)!}" class="form-control" placeholder="Username" required="true"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="password" name="password" value="${(user.password)!}" class="form-control" placeholder="Password" required="true"/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="role" name="role" value="${(user.role)!}" class="form-control" placeholder="Role" required="true"/>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <input id="activeCheck" type="checkbox" ${((user.active)?c)!} />
                                    </span>
                                    <input type="text" id="activeInput" name="active" value="${((user.active)?c)!}" class="form-control" placeholder="Active" required="true">
                                </div>
                            </div>
                            <input type="hidden" name="uuid" value="${(user.uuid)!}"/>
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
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Username</th>
                                    <th>Active</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list users as user>
                                        <tr>
                                            <td>${(user.name)!}</td>
                                            <td>${(user.email)!}</td>
                                            <td>${(user.username)!}</td>
                                            <td>${(user.active)?c}</td>
                                            <td>
                                                <a href="/secure/user/${(user.username)!}" class="btn btn-xs btn-primary">
                                                    <i class="fa fa-pencil"></i>
                                                </a>
                                                <a href="#" class="btn btn-danger btn-xs" data-id="${(user.name+','+user.username)!}" data-toggle="modal" data-target="#deleteCheck">
                                                    <i class="fa fa-trash-o"></i>
                                                </a>
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

        <div class="modal fade" id="deleteCheck" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Are you sure?</h4>
                    </div>
                    <div class="modal-body">
                        Permantly remove user <span id="data_name"></span>? This action cannot be undone.
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default btn-md pull-left" data-dismiss="modal">No, Cancel</button>
                        <span id="delete">
                            <form role="form" method="post" action="/secure/user/{username}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-primary btn-md">Yes, Remove User</button>
                            </form>
                        </span>

                    </div>
                </div>
            </div>
        </div>

        <!-- content -->

        <#include "../stubs/footer.ftl">

        <#include "../stubs/scripts.ftl">

        <script>
            $(document).ready(function() {

                // toggle active/disabled checkbox and value
                (function(){var activeCheck=document.getElementById('activeCheck');var activeInput=document.getElementById('activeInput');
                if(!activeCheck.checked && activeInput.value == 'true'){activeCheck.checked = true;}activeCheck.onclick=function(){
                if(activeCheck.checked){activeInput.value='true';}else{activeInput.value='false';}}})();

                // toggle safe delete modal popup
                $('a[data-toggle="modal"]').click(function(){
                    var id = $(this).data('id').split(',');
                    $('.modal-body #data_name').html(id[0]);
                    var form = $('.modal #delete');
                    form.html(form.html().replace('{username}',id[1]));
                });
            });
        </script>

    </body>
</html>
