<%--
  Created by IntelliJ IDEA.
  User: KUYLIM
  Date: 5/16/2017
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" ng-app="DealerApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Efinance-Dashboard</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath }/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/kselect.min.css" rel="stylesheet"/>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Oswald');

        body {
            background-image: url("${pageContext.request.contextPath }/resources/images/Background.png");
            background-size: cover;
            font-family: 'Oswald', sans-serif;
        }

        .menu {
            width: 140px;
            height: 150px;
        }

        #link {
            color: black
        }

        .navbar-default {
            background-color: transparent;
            border: none;
        }
    </style>
</head>
<body ng-app="">
<div style="width:200px; height:200px; background-color:none; float:left;">
    <center>
        <img src="${pageContext.request.contextPath }/resources/images/gl-logo.png"
             style="width:70px; height:70px; margin:10px"/><br/>
        <img src="${pageContext.request.contextPath }/resources/images/e-finance-logo.png" style="width: 120px"/>
    </center>
</div>

<nav class="navbar navbar-default pull-right">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath }/index">Home</a></li>
            <security:authorize access="hasAnyRole('ADMIN')">
                <li><a href="${pageContext.request.contextPath }/admin/list-users">Manage Users</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/list-products">Manage
                    Products</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/list-applications">Manage
                    Application</a></li>
            </security:authorize>
            <li><a href="${pageContext.request.contextPath }/page/change-password">Change Password</a>
            </li>
            <li><a href="${pageContext.request.contextPath }/logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div style="padding-top: 150px" ng-controller="DealerController">
    <center>
        <div class="container">
            <div class="row">
                <center><h1 style="margin-right:110px">Please Select System Product</h1></center>
            </div>
            <div class="row" style="margin-top:30px;">
                <c:forEach items="${Apps}" var="products">
                    <c:set var="title" value="${fn:split(products.key, '@')}"/>
                    <c:choose>
                        <c:when test="${fn:length(products.value) gt 1}">
                            <a href="#" id="link" data-toggle="modal" data-target="#${title[1]}">
                                <div class="col-md-2 col-md-offset-1">
                                    <h4 style="margin-left:-30px">${title[1]}</h4>
                                    <img src="${pageContext.request.contextPath }/image/${title[2]}" ​​
                                         class="menu">
                                </div>
                            </a>
                        </c:when>
                        <c:when test="${fn:length(products.value) lt 1}">
                            <a href="#" id="link" ng-disabled="disable">
                                <div class="col-md-2 col-md-offset-1">
                                    <h4 style="margin-left:-30px">${title[1]}</h4>
                                    <img style="opacity: 0.5;"
                                         src="${pageContext.request.contextPath }/image/${title[2]}" ​​
                                         class="menu">
                                </div>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${products.value}" var="hd">
                                <a href="${pageContext.request.contextPath }/page/app/${hd.front}"
                                   id="link">
                                    <div class="col-md-2 col-md-offset-1">
                                        <h4 style="margin-left:-30px">${title[1]}</h4>
                                        <img src="${pageContext.request.contextPath }/image/${title[2]}" ​​
                                             class="menu">
                                    </div>
                                </a>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach items="${products.value}" var="applications" varStatus="loop">
                        <div class="modal fade" id="${title[1]}" role="dialog">--%>
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;
                                        </button>
                                        <h4 class="modal-title">Honda Applications</h4>
                                    </div>
                                    <div class="modal-body">
                                        <c:forEach items="${products.value}" var="hd">
                                            <div>
                                                <a style="text-decoration: none;"
                                                   href='${pageContext.request.contextPath }/page/app/${hd.front}'
                                                   >${hd.name}</a>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">
                                            Close
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:forEach>
            </div>
        </div>
    </center>
</div>
<div style="margin-top:30px; margin-bottom: 30px;">
    <center>
    <h6><img src="${pageContext.request.contextPath }/resources/images/Help.png" style="width:20px; height:20px"/>&nbsp;
        &nbsp;Any
        query please contact IT team by 087 830 222 or itdep@gl-f.com</h6>
    </center>
</div>

<script src="${pageContext.request.contextPath }/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/angular/dealerApp.js"></script>
</body>
</html>
