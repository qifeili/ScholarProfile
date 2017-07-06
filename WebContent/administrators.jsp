<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String path = request.getContextPath();
     String basePath = request.getScheme() + "://"
             + request.getServerName() + ":" + request.getServerPort()
             + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>RegisterStop01</title>
    <link href="css/reset.css" rel="stylesheet">
  <!--   Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

   <!--  Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

 <!--    Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/jqui/jquery-ui.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet"> 
    <style>
       .one{background-color: #008CBA;  border:none; color:white; padding:5px 10px;
 text-decoration:none; display:inline-block; font-size:15px;margin:4px 10px; cursor:pointer;}
table,td{border:solid white;width:65%;height:20px;
text-align:right; vertical-align:top;
}
        select {
            padding-right: 0 !important;
        }
    </style>
</head>  
<body  class="registerStep01 clearfix">
<div class="container">
    <div class="registerCon">
    <div align="center">
<h1>管理员密码修改系统</h1>
 <form action="/scholarprofile/mima.do"  name="修改管理员密码"  type="post">
<%--  用户名：<input type="text" name="keeper" value="${keep}" > <br>
 原密码：<input type="password"  name="oldpassword" > <br>
 新密码：<input type="password"  name="newpassword" > <br>
 请重新输入新密码：<input type="password" name="newpassword2"><br> --%>
<table >
 <tr ><td>用户名：</td><td align="right"><input  type="text" name="keeper"></td></tr>
 <tr><td>原密码：</td><td><input type="password" name="oldpassword"></td></tr>
  <tr><td>新密码：</td><td><input type="password" name="newpassword"></td></tr>
  <tr><td>请重新输入新密码 ：</td><td><input type="password" name="newpassword2"></td></tr>
 </table> 
<input class="one" type="submit"  value="提交" >
</form>
<font size="3" color="red" > ${news}</font>
  </div>
</div>
</div>
</body>  
</html> 