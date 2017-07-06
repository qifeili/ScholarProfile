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

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/jqui/jquery-ui.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <style>
    .three{background-color: #008CBA;  border:none; color:white; padding:5px 10px;
 text-decoration:none; display:inline-block; font-size:15px;margin:4px 10px; cursor:pointer;}
  .container{text-align:center}
        select {
            padding-right: 0 !important;
        }
    </style>
</head>  
<body  class="registerStep01 clearfix">
<div class="container">
    <div class="registerCon" >
<h1>修改user信息</h1>
<form action="/scholarprofile/updateuser.do" name="edit" method="post">
<input type="hidden" name="id"  value="${user.id} ">
用户 名  ：    <input type="text" name="username" value="${user.username }"><br>
登录密码：<input type="text" name="password" value="${user.password }"><br>
电子邮箱：<input type="text" name="email" value="${user.email} "><br>
真实姓名：<input type="text" name="realName" value="${user.realName} "><br>
出生日期：<input type="text" name="birthday"   value="${user.birthday} "><br>
性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp; ：<input type="text" name="sex" value="${user.sex} "><br>
最高学历： <input type="text" name="maxDegree" value="${user.maxDegree} "><br>
工作年限：<input type="text" name="worklife" value="${user.worklife} "><br>
工作地点：<input type="text" name="workPlace" value="${user.workPlace} "><br>
当前行业与职能：<input type="text" name="industryAndFunctional" value="${user.industryAndFunctional} "><br>
公 司 名 ： <input type="text" name="companyName" value="${user.companyName} "><br>
职 &nbsp;&nbsp;位&nbsp; ：<input type="text" name="curPosition" value="${user.curPosition} "><br>
电话号码：  <input type="text" name="phone" value="${user.phone} "><br>
感兴趣的领域：<input type="text" name="interestField" value="${user.interestField} "><br>
注册的手机号：<input type="text" name="registerNumber" value="${user.registerNumber} "><br>
注册类型 &nbsp;&nbsp;：  <input type="text" name="registerType" value="${user.registerType} "><br>
第三方登录名：<input type="text" name="thirdPartyUsername" value="${user.thirdPartyUsername} "><br>
<%-- 用户创建的项目：<input type="text" name="projects" value="${user.projects} "><br>
用户关注数： <input type="text" name="focuses" value="${user.focuses} "><br> --%>
<input class="three"  type="submit" value="提交编辑信息" >
</form>
 </div>

</div>
</body>  
</html> 