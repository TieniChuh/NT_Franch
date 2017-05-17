<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/3.3.7/css/bootstrap.min.css">
<script src="angular/1.4.6/angular.min.js"></script>
<title>userInfo</title>
</head>
<body>
        <!-- SITE TOP -->
        <div class="site-top">
            <div class="site-header clearfix">
                <div class="container">
                    <a href="#" class="site-brand pull-left"><strong>Personal</strong>Display </a>
                     
                </div>
            </div> <!-- .site-header -->
            <div class="site-banner">
                <div class="container">
                    <div class="row"></div>
      
                </div>
            </div> <!-- .site-banner -->
        </div> <!-- .site-top -->
<div class="container" boder="1">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-pills">
                <li class="active">
                     <a href="#">首页</a>
                </li>
                <li>
                     <a href="#">简介</a>
                </li>
                <li class="disabled">
                     <a href="#">信息</a>
                </li>
                <li class="dropdown pull-right">
                     <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                             <a href="#">操作</a>
                        </li>
                        <li>
                             <a href="#">设置栏目</a>
                        </li>
                        <li>
                             <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                             <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-8 column">
        <!-- addUser begin -->
 
    <div id="addUserAppDiv" ng-app="addUserApp" ng-controller="addUserCtrl">
        昵称:<input type="text" id="nickName" name="nickName" ng-model="AcctUserDto.nickName"><br> 
        电话: <input type="text" id="telePhone" name="telePhone" ng-model="AcctUserDto.telePhone"><br>
             <button class="btn btn-success btn-xs" ng-click="addUser()">
        <span class="glyphicon glyphicon-user"></span>创建新用户
    </button>
    </div>
    <script>

    var userApp = angular.module('addUserApp', []);
    userApp.controller('addUserCtrl', function($scope,$http) {
        $scope.AcctUserDto = {
                 nickName:"John",
                telePhone:"16022222222"

            };
        $scope.addUser = function(){
            $http({
                method: "POST",
                url: "user/createUser.htmls",
                data: $scope.AcctUserDto
            }).success(function (data){
                $scope.users = data;
            });
        };
       
    });
</script>
    <!-- addUser end -->
    <!-- userInfo begin-->
    <div id="userAppDiv" ng-app="userApp" ng-controller="userCtrl">
        名: <input type="text" ng-model="firstName"><br> 姓: <input type="text" ng-model="lastName"><br> <br> 姓名:
        {{firstName + " " + lastName}}

    </div>
    <script>
                    var userApp = angular.module('userApp', []);
                    userApp.controller('userCtrl', function($scope) {
                        $scope.firstName = "";
                        $scope.lastName = "Doe";
                    });
                </script> 
    <!-- userInfo end -->
    <!-- UserList begin -->
    <div id="userListAppDiv" ng-app="userListApp" ng-controller="userListCtrl">
        <table>
            <tr>
                <td>序号</td>
                <td>昵称</td>
                <td>电话</td>
                <td>注册时间</td>
                <td>id</td>
            </tr>
            <tr ng-repeat="user in users">
                <td>{{ $index + 1 }}</td>
                <td>{{ user.nickName }}</td>
                <td>{{ user.telephone }}</td>
                <td>{{ user.registerTime| date:'yyyy-MM-dd HH:mm:ss' }}</td>
                <td>{{ user.id }}</td>
            </tr>
        </table>
    </div>
    <style>
table,th,td {
    border: 1px solid grey;
    border-collapse: collapse;
    padding: 5px;
}

table tr:nth-child(odd) {
    background-color: #f1f1f1;
}

table tr:nth-child(even) {
    background-color: #ffffff;
}
</style>
    <script>
                    var userListApp = angular.module('userListApp', []);
                    userListApp.controller('userListCtrl', function($scope, $http) {
                        $http.get("user/showInfos.htmls").success(function(response) {
                            $scope.users = response;
                        });
                    });
                </script>
    <!-- UserList end -->
    <!-- multiple App -->
    <script>
     //angular.bootstrap(document.getElementById("addUserAppDiv"), [ "addUserApp" ]);
      angular.bootstrap(document.getElementById("userAppDiv"), [ "userApp" ]);
     angular.bootstrap(document.getElementById("userListAppDiv"), [ "userListApp" ]);
</script>
    用户信息 昵称： ${userInfo.nickName} 用户id：${userInfo.id} 用户电话:${userInfo.telephone } 注册时间：
    <fmt:formatDate value="${userInfo.registerTime }" pattern="yyyy-MM-dd HH:mm:ss" />
    角色：[
    <c:forEach items="${ userInfo.acctRoles}" var="role">  
                        ${role.name }   权限[  
                           <c:forEach items="${ role.acctAuthorities}" var="authority">  
                             ${authority.name }   
                           </c:forEach> ]  
                      </c:forEach>
    ]
    <hr>
    <button class="btn btn-success" ng-click="editUser('new')">
        <span class="glyphicon glyphicon-user"></span>创建新用户
    </button>
    <hr>
    <br /> ajax显示全部用户信息：
    <div id="show_all_user"></div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    Example page header <small>Subtext for header</small>
                </h1>
             </div>
        </div>
    </div>
</div>
        <!-- FOOTER -->
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <p class="copyright-text">Copyright &copy; 2084 Company Name 
                    | More Templates <a href="http://www.cssmoban.com/" target="_blank" title="123">123</a> - Collect from <a href="http://www.cssmoban.com/" title="123" target="_blank">123</a></p>
                </div>
            </div>
        </div>
    </footer>
 </body>
</html>
