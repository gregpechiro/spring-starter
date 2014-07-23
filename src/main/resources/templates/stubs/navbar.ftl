<div id="navbar" class="navbar navbar-default navbar-static-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <#--<img class="navbar-brand logo" src="/static/img/logo.png"/>-->
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <#if username??>
                    <li><a href="/logout">Logged in as ${username}, Logout</a></li>
                <#else>
                    <li><a href="/secure/login?forward=user">Login</a></li>
                </#if>
            </ul>
        </div>
    </div>
</div>
<div class="col-sm-offset-1 col-sm-10">
    <legend><img class="img-responsive logo" src="/static/img/logo.png"/></legend>
</div>