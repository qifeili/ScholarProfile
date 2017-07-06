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
<style>
.one{
background-color: #008CBA;  border:none; 
color:white; padding:5px 10px;
 text-decoration:none; display:inline-block; font-size:15px;
margin:4px 10px; cursor:pointer;
}
.ta{ margin:4px 10px; align:"center"
}
</style>

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
table,td{
  vertical-align:top;  padding:10px; text-align:right;width:78%;height:10px;}
        select {
            padding-right: 0 !important;
        }
    </style>
</head>  
<body  class="registerStep01 clearfix">
<div class="container">
    <div class="registerCon">
    <div align="center">
<h1>管理员登陆系统</h1>
 <form action="/scholarprofile/login.do" name="管理员登陆"  type="post">
<table >
<tr><td>用户名：</td> <td><input  class="o" type="text" name="keeper"></td></tr>
<tr><td>密码：</td><td><input type="password" name="password"></td></tr>
</table> 
<!-- 用户名：<input type="text" name="keeper"  > <br>
 密&nbsp;&nbsp;码&nbsp;：<input type="password"  name="password" > <br>  -->
<input type="submit" class=one  value="登录" >
</form>
<h2><font color="red">${error}</font></h2>
 <h2><font color="green">${update}</font></h2>
 </div>
</div>
</div>
</body>  
</html> 