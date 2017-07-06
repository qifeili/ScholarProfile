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
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/jqui/jquery-ui.min.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <style>
      .one{background-color: #008CBA;border:none; color:white; padding:5px 10px;
 text-decoration:none; display:inline-block; font-size:15px;margin:4px 10px; cursor:pointer;}
    .four{text-align:center}
        select {
            padding-right: 0 !important;
        }
    </style>
</head>  
<body  class="registerStep01 clearfix">
<div class="container">
    <div class="registerCon">
 <div class="four">
 <h1>添加用户</h1>  
    <form action="/scholarprofile/adduser.do" name="userForm" method="post"  >
用 户 名  ：       <input type="text" name="username"><br>
登录密码：      <input type="text" name="password"><br>
电子邮箱：      <input type="text" name="email" ><br>
真实姓名：      <input type="text" name="realName" ><br>
出生日期：      <input type="text" name="birthday"><br>
 性 &nbsp;&nbsp; &nbsp;&nbsp;别：           <input type="text" name="sex" ><br>
最高学历：      <input type="text" name="maxDegree"><br>
工作年限：       <input type="text" name="worklife" ><br>
工作地点：      <input type="text" name="workPlace"><br>
行业职能 ：<input type="text" name="industryAndFunctional" ><br>
公 司 名 ：      <input type="text" name="companyName"><br>
职&nbsp; &nbsp;&nbsp; &nbsp; 位：      <input type="text" name="curPosition" ><br>
电话号码：&nbsp; <input type="text" name="phone" ><br>
感兴趣领域：<input type="text" name="interestField"><br>
注册手机号：<input type="text" name="registerNumber" ><br>
注册类型：&nbsp;&nbsp; <input type="text" name="registerType" ><br>
第三方登录名：<input type="text" name="thirdPartyUsername" >&nbsp;&nbsp;&nbsp;&nbsp;<br>
<%-- 用户创建的项目：<input type="text" name="projects" value="${user.projects} "><br>
用户关注数： <input type="text" name="focuses" value="${user.focuses} "><br> --%>
     <input   class="one" type="submit" value="增加">  </div>  
    <!-- 下面两行用于往scholar中导入paperlist列 -->
     <h3 align="center"><a href="/scholarprofile/paperlist.do">数据导入</a></h3>
     <h4>${paperlist}</h4>
</form> 
 </div> </div> </div>
</body>  
</html> 