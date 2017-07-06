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

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RegisterStop01</title>
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

    <!--ju-ui-->
    <link href="css/jqui/jquery-ui.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/common.css" rel="stylesheet">
    <style>
        select {
            padding-right: 0 !important;
        }
    </style>
</head>
<body class="registerStep01 clearfix">

<!-- Navigation -->
<nav class="navbar mynav navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
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
    <div class="stepNav clearfix">
        <ul class="stepNavList clearfix">
            <li class="stepNavListItem">1 <span>基本信息</span></li>
            <li class="stepNavListItem">2 <span>个性化信息</span></li>
        </ul>
    </div>
    <div class="registerCon">

        <h1>欢迎注册!</h1>
        <h2>请完善您的基本信息</h2>

        <form action="<%=basePath%>registerStep01.do" method="post" >
            <input type="text" class="form-control realName" placeholder="真实姓名" name="realName">

            <!--<select class="form-control bornDate">-->
                <!--<option  selected = "selected">出生年月</option>-->
                <!--<option>1990</option>-->
                <!--<option>1991</option>-->
                <!--<option>1992</option>-->
                <!--<option>1993</option>-->
            <!--</select>-->

            <input type="text" class="form-control bornDate" id="bornDate" placeholder="出生日期" name="birthday"/>

            <select class="form-control sex" name="sex">
                <option  selected = "selected">男</option>
                <option>女</option>
            </select>

            <select class="form-control diploma" name="maxDegree">
            	<option  selected = "selected" value="">选择最高学历</option>
                <option value="高中以下">高中以下</option>
                <option value="高中">高中</option>
                <option value="中专">中专</option>
                <option value="大专">大专</option>
                <option value="本科">本科</option>
                <option value="硕士">硕士</option>
                <option value="博士及以上">博士及以上</option>
            </select>

            <select class="form-control startWork" name="worklife">
                <option  selected = "selected" value="">选择工作年限</option>
                <option value="在读学生">在读学生</option>
                <option value="应届毕业生">应届毕业生</option>
                <option value="一年">一年</option>
                <option value="两年">两年</option>
                <option value="三年">三年</option>
                <option value="四年">四年</option>
                <option value="五年">五年</option>
                <option value="六年">六年</option>
                <option value="七年">七年</option>
                <option value="八年">八年</option>
                <option value="九年">九年</option>
                <option value="十年">十年</option>
                <option value="十一年">十一年</option>
                <option value="十二年">十二年</option>
                <option value="十三年">十三年</option>
                <option value="十四年">十四年</option>
                <option value="十五年">十五年</option>
                <option value="十六年">十六年</option>
                <option value="十七年">十七年</option>
                <option value="十八年">十八年</option>
                <option value="十九年">十九年</option>
                <option value="二十年">二十年</option>
                <option value="二十年-三十年">二十年-三十年</option>
                <option value="三十年-四十年">三十年-四十年</option>
                <option value="四十年以上">四十年以上</option>
            </select>
            <input type="text" class="form-control workAdd" placeholder="工作地址" name="workPlace">
            <input type="submit" value="继续" class="btn btn-primary btn-block continue"/>
            <a href="<%=basePath%>registerStep02.jsp">跳过</a>

        </form>





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


<ul class="topBtnGroup">
    <li><a href="">热点领域</a></li>
    <li><a href="">名会领域</a></li>
    <li>
        <i></i>
        <b></b>
        <a href="javascript:;" id="topBtn">返回顶部</a>
    </li>
</ul>


<!-- jQuery -->
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.ui.datepicker-zh-CN.js"></script>

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

        $("#bornDate").datepicker({
            "option":"$.datepicker.regional['zh-HK']",
            "changeMonth":true,			//显示下拉月份
            //"changeYear":true,
            "showWeek":true,
//            "showButtonPanel":true,	//显示按钮面板
            //"closeText":"Close",		//设置关闭按钮文字
            //"disable":true,
            //"numberOfMonths":3,		//显示个数
//            'onSelect': function(dateText, instance) {	//选择日期触发事件
//                $("#box").html(dateText);
//            },
            'dateFormat': 'yy-mm-dd',	//设置日期格式
            inline:true,

        });


    })


</script>

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
