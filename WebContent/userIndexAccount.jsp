<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     String path = request.getContextPath();
     String basePath = request.getScheme() + "://"
             + request.getServerName() + ":" + request.getServerPort()
             + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>userIndexAccount</title>
    <link href="css/reset.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <style>
        select {
            padding-right: 0 !important;
        }
    </style>
</head>
<body class="userIndexAccount clearfix">

<!-- Navigation -->
<nav class="navbar mynav navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
<!--            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>-->
            <a class="navbar-brand" href="/">Comwit</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="<!--collapse--> navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-life">
                <li>
                    <a href="index">首页</a>
                </li>
                <li>
                    <a href="expertlist.do">专家</a>
                </li>
                <li>
                    <a href="projectlist.do">项目</a>
                </li>
                <li>
                    <a href="">社区</a>
                </li>

                <!--搜索框开始-->
                <li class="searchGroupWraper">
						<form action="<%=basePath%>searchprojectlist.do" id="dynamicSearch" method="post">
							<div class="searchGroupClose">关闭</div>
							<div class="searchGroup">
								<div class="searchGroupCon clearfix">
									<input type="text" class="searchInput01 searchInput" name="srcText"
										placeholder="搜索..." />
									<div class="searchInput02Wraper">
										<input type="text" class="searchInput02 searchInput"
											value="项目需求" />
										<input type="hidden" class="searchInput03 searchInput" name="srcType" value="领域"/>
										<ul class="searchGroupMenu">
											<li>领域专家</li>
										</ul>
									</div>
								</div>
							</div>
							<button type="submit" class="searchGroupSubmit">提交</button>
						</form>

                </li>
                <!--搜索框结束-->
                <!--
				<li class="floatLelt Account" id="logined">
                    <a href="javascript:void();" id=""><i class="fa fa-user"></i></a>
                        <ul class="AccountMenuList">
                            <li class="AccountMenuListItem"><a href="userIndexReviews.do">我的关注</a></li>
                            <li class="AccountMenuListItem"><a href="userIndexProject.do">我的项目</a></li>
                            <li class="AccountMenuListItem"><a href="userIndexMessage.do">我的消息</a></li>
                            <li class="AccountMenuListItem"><a href="userIndexAccount.do">账号管理</a></li>
                            <li class="AccountMenuListItem"><a href="" id="toLogout">退出登陆</a></li>
                        </ul>
                </li>

                <li class="floatLelt">
                    <a href="" id="signBtn">登录</a>
                </li>
                -->
                <li class="floatLelt message">
                    <a href="#">
                        <i class="fa fa-envelope-o"></i>
                        <ul class="messageList">
                            <li class="title">提醒</li>
                            <a href=""><li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span></li></a>
                            <a href=""><li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span></li></a>
                            <a href=""><li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span></li></a>
                        </ul>
                    </a>
                </li>
                <li class="floatLelt">
                    <a href="" id="toPublishProject">发布项目</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- Page Content -->
<div class="container">
    <!--<div class="stepNav clearfix">
        <ul class="stepNavList clearfix">
            <li class="stepNavListItem complete">1 <span>选择项目类型</span></li>
            <li class="stepNavListItem">2 <span>描述项目需求</span></li>
            <li class="stepNavListItem">3 <span>设置合同金额</span></li>
            <li class="stepNavListItem">4 <span>预览并发布项目</span></li>
        </ul>
    </div>-->
    <div class="userIndex clearfix">

            <div class="leftCol">
                <ul class="userMenuList">
                    <li class="userMenuListIetms"><a href="userIndexReviews.do">我的关注</a></li>
                    <li class="userMenuListIetms"><a href="userIndexProject.do">我的项目</a></li>
                    <li class="userMenuListIetms"><a href="userIndexMessage.do">我的消息</a></li>
                    <li class="userMenuListIetms"><a href="#"  class="active">账号管理</a></li>
                </ul>
            </div>
            <div class="rightCol">

                <div class="userAcconut">
                    <h1>账号</h1>
                        <div class="nowAcconut">${userIndexAccount.userAccount}</div>

                        <div class="trilateralAcconutBinding">
                            <h2>绑定第三方账号</h2>
                            <span class ="weixinIcon"></span><a>已绑定</a>
                            <span class ="qqIcon"></span><a href="">已绑定</a>
                            <span class ="weiboIcon"></span><a href="">已绑定</a>
                        </div>

                        <div class="editPassword">
                            <h2>修改登录密码</h2>
                            <form action="">
                            <ul class="formList">
                                <li class="formListItems clearfix">
                                    <label for="">旧密码</label><input type="password" class="form-control " name="oldPassWord" placeholder="">
                                    <label class="errorTip"><span class="errorText"></span><span class="arrow"></span></label>
                                </li>
                                <li class="formListItems clearfix">
                                    <label for="">新密码</label><input type="password" class="form-control " name="newPassWord" placeholder="">
                                    <label class="errorTip"><span class="errorText"></span><span class="arrow"></span></label>
                                </li>
                                <li class="formListItems clearfix">
                                    <label for="">再次确认密码</label><input type="password" class="form-control " name="confirmNewPassWord" placeholder="">
                                    <label class="errorTip"><span class="errorText"></span><span class="arrow"></span></label>
                                </li>
                                <button type="submit" class="btn btn-primary btn-block continue">确认修改</button>
                            </ul>
                            </form>
                        </div>
                </div>
            </div>


    </div>



</div>


<hr>

<!-- Footer -->
<footer>
    <div class="row">
        <div class="col-lg-12">
            <p>Copyright &copy; Your Website 2014</p>
        </div>
    </div>
</footer>

<!-- /.container -->


<!--<ul class="topBtnGroup">-->
    <!--<li><a href="">热点领域</a></li>-->
    <!--<li><a href="">名会领域</a></li>-->
    <!--<li>-->
        <!--<i></i>-->
        <!--<b></b>-->
        <!--<a href="javascript:;" id="topBtn">返回顶部</a>-->
    <!--</li>-->
<!--</ul>-->


<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_cn.js"></script>

<script type="text/javascript" src="js/build/dist/echarts.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script src="js/common.js"></script>
<script src="js/plug.js"></script>
<!-- js工具类 -->
<script src="jsutils/util.js"></script>
<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>

<script>
    $(function () {


        $('#topBtn').toTop();

        //应用动态search插件
        $('#searchGroupWraper').dySearchBox({
            closeWidth:"150",
            openWdith:"272"
        });


        //表单验证开始-------

        (function(){

            var swich;

            function valiOldPassWord() {
                var $Input = $('input[name = "oldPassWord"]');
                var InputVal = $Input.val();
                
                if (!InputVal) {
                    $Input.next('.errorTip').show();
                    $Input.next('.errorTip').find('.errorText').text('请输入旧密码');
                    return false;
                } else{
                    $Input.next('.errorTip').hide();
                    return true;
                }
            }
            function valiNewPassWord() {
                var $Input = $('input[name = "newPassWord"]');
                var InputVal = $Input.val();
                if (!InputVal) {
                    $Input.next('.errorTip').show()
                    $Input.next('.errorTip').find('.errorText').text('请输入新密码');
                    return false;
                } else if((InputVal.length < 6) || (InputVal.length > 16)){
                    $Input.next('.errorTip').show()
                    $Input.next('.errorTip').find('.errorText').text('6-16位密码');
                    return false;
                } else{
                    $Input.next('.errorTip').hide();
                    return true;
                }
            }
            function valiConfirmNewPassWord() {
                var $Input = $('input[name = "confirmNewPassWord"]');
                var InputVal = $Input.val();
                if (!InputVal) {
                    $Input.next('.errorTip').show();
                    $Input.next('.errorTip').find('.errorText').text('再次输入新密码');
                    return false;
                } else if(InputVal!==$('input[name = "newPassWord"]').val()){
                    $Input.next('.errorTip').show();
                    $Input.next('.errorTip').find('.errorText').text('不一致');
                    return false;
                } else{
                    $Input.next('.errorTip').hide();
                    return true;
                }
            }



//         分别验证
            //隐藏全部提示
            $(document).click(function () {
                $('label[class="errorTip"]').hide();
            });

            //提交验证
            $('button[type = "submit"]').click(function () {
                        var valiFunArr = ['valiOldPassWord','valiNewPassWord','valiConfirmNewPassWord'];
                        swich = valiFunArr.join("()&") + "()";
                        swich = eval(swich);
                        if (!swich) {
                            return false;
                        }else{
                            //验证成功后，发送ajax
                            $.ajax({
                                type: 'post',
                                //庞超
                                url: "changePasswordAjax.do",
                                dataType : 'text',
                                data: {
                                    oldPassword: $('input[name = "oldPassWord"]').val(),
                                    newPassword: $('input[name = "newPassWord"]').val(),
                                },
                                success: function(response, status, xhr) {
                                    if(response=='true'){
                                        $('input[name = "oldPassWord"]').next('.errorTip').hide();
                                        //页面可以跳转了
                                        $().setiingTip({text:'修改成功',type:'1'});
                                        <%-- window.location.href = "<%=basePath%>index.jsp"; --%> 
                                        return false;
                                    }else {
                                        $('input[name = "oldPassWord"]').next('.errorTip').show();
                                        $('input[name = "oldPassWord"]').next('.errorTip').find('.errorText').text('原密码输入不正确');
                                        return false;
                                    }
                                },
                                error:function(){
                                }
                            });
                           return false;
                        }
                    }
            );

        })();


        //表单验证结束-------


    })


</script>
<!-- 验证是否session过期登录 -->
<%-- <script type="text/javascript">
$(function() {

    var userInfoId = '<%=session.getAttribute("userInfoId")%>';
    var projectId = '<%=session.getAttribute("projectId")%>';
    if(userInfoId == "null") { //当session中没有值时， js获取到的是"null"，而不是null
        $('#signBtn').click();           
    }
    /* if(projectId == "null") {
        alert("发布项目等待时间太久，请重新发布");
    } */
    return false;//必须加上这句阻止掉浏览器的默认动作
});

</script> --%>

<!-- 发布项目验证是否登录 -->
<script type="text/javascript">
$(function() {
    var userInfoId = '<%=session.getAttribute("userInfoId")%>';
    //切换登录显示
    if(userInfoId == "null" || userInfoId === null) {
        //$('#logined').hide();
        //$('#logouted').show();
    	addLoginBtn();
    }else {
        //$('#logined').show();
        //$('#logouted').hide();
    	addLoginLogo();
    }
});
</script>


</body>

</html>

