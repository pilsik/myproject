<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/css/login.css" rel="stylesheet"/>
    <script src=" https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link href="/css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
</head>

<body>

<c:if test="${param.error != null}">
    <div class="row">
        <div class="alert alert-danger col-sm-12">
            <p>Invalid username and password.</p>
        </div>
    </div>
</c:if>

<c:if test="${param.logout != null}">
    <div class="row">
        <div class="alert alert-success col-sm-12">
            <p>You have been logged out successfully.</p>
        </div>
    </div>
</c:if>

<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-primary btn-block" role="button">Login</a>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
     style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Login to Your Account</h1><br>
            <c:url var="loginUrl" value="/login"/>
            <form action="${loginUrl}" method="post" class="form-horizontal">
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter login"
                           required>
                </div>
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="Enter Password" required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>

                <div class="form-actions">
                    <input type="submit"
                           class="btn btn-block btn-primary btn-default" value="Log in">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
