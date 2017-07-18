<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<!doctype html>

<html lang="en" ng-app="LoginApp">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | Web applicant</title>
    <link href="${pageContext.request.contextPath }/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Oswald');

        .error {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 20px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
            margin-top: 30px;
            width: 350px;
        }

        body {
          /*  background-image: url("${pageContext.request.contextPath }/resources/images/Background.png");*/
            background-size: cover;
            font-family: 'Oswald', sans-serif;
            color:black;
        }

        input[type="text"],
        input[type="password"] {

            border-radius: 20px;
            padding: 10px;
            border: 1px solid #00bdff;
            width: 350px;

        }

        ::-webkit-input-placeholder {
            text-align: center;
        }

        :-moz-placeholder { / Firefox 18- /
        text-align: center;
        }

        ::-moz-placeholder { / Firefox 19+ /
        text-align: center;
        }

        :-ms-input-placeholder {
            text-align: center;
        }

        .btn-submit {
            color: #fcffff;
            border-radius: 20px;
            padding: 10px;
            background-color: #1176c6;
        }

    </style>
</head>
<body ng-controller="LoginController">
<center>
    <div style="background-color:none; width:500px;">
        <%--<div style="margin-top:50px">
            <img src="${pageContext.request.contextPath }/resources/images/gl-logo.png"
                 style="width:100px; height:100px"/>
        </div>--%>
      <%--  <div style="padding-top: 20px">
            <img src="${pageContext.request.contextPath }/resources/images/e-finance-logo.png" style="width:250px;"/>
        </div>--%>
        <c:if test="${not empty error}">
            <div class="error" ng-hide="isHide">${error}</div>
        </c:if>
        <form class="form-signin" action="login" method="post">
            <div style="width: 350px; margin-top:30px">
                <div class="form-group">
                    <input type="text" name="username" placeholder="username" ng-model="username" ng-change="change()">
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="password" ng-model="password" ng-change="change()">
                </div>
                <button type="submit" class="btn btn-submit" style="width:220px; color:#fff"><b>Login</b></button>
            </div>
        </form>
    </div>
</center>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/angular/login.js"></script>
</body>
</html>