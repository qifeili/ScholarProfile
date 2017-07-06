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

    <link rel="shortcut icon" href="images/tablogo.png" type="image/x-icon">

    <title>发布项目 - Comwit</title>
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
        select{
            padding-right:0 !important;
        }
    </style>
</head>
<body class="publishingProjectStep03 clearfix">

<!-- Navigation -->
<nav class="navbar mynav navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <!--<button type="button" class="navbar-toggle" data-toggle="collapse"
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
                            <a href="">
                                <li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span
                                        class="time">12-03</span></li>
                            </a>
                            <a href="">
                                <li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span
                                        class="time">12-03</span></li>
                            </a>
                            <a href="">
                                <li class="messageListItem">Big Technical Support—中国领先的服务众包平台,注册用户超过了1300万...<span
                                        class="time">12-03</span></li>
                            </a>
                        </ul>
                    </a>
                </li>
                <li class="floatLelt">
                    <a href="" id="toPublishProject" class="active">发布项目</a>
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
            <li class="stepNavListItem complete">1 <span>选择项目类型</span></li>
            <li class="stepNavListItem complete">2 <span>描述项目需求</span></li>
            <li class="stepNavListItem complete">3 <span>设置合同金额</span></li>
            <li class="stepNavListItem">4 <span>预览并发布项目</span></li>
        </ul>
    </div>
    <div class="registerCon">

        <h1>设置合同金额</h1>
        <!--<h2>Tell us a little about yourself so we can customize your site experience.</h2>-->
        <!--<h3 class=""></h3>-->
        <form action="<%=basePath%>publishingProjectStep03.do" id="priceForm" onSubmit="return checklogin()">
            <ul class="priceList clearfix">
                <li class="price-top-wrap">
                    <div class="price-top-wrap-title">
                        <label>
                            <input type="radio" name="price-set" id="" checked/>
                            <i class="fa fa-bookmark"></i>有明确预算,明确的预算更能吸引服务商参与
                        </label>
                    </div>

                    <div class="price-top-wrap-input">
                        <i class="fa fa-jpy"></i>
                        <input type="text" class="form-control" name="priceInput" value="0.00"/>
                    </div>
                </li>
                <li class="price-bottom-wrap">
                    <label>
                        <input type="radio" name="price-set" id=""/><i class="fa fa-bookmark-o"></i>无明确预算，先看看服务商的报价
                    </label>
                </li>
                <li class="projectInfListItem projectNav">
                    <a href="publishingProjectUpdateStep02.jsp" class="prevStep" target="_self">上一步</a>
                    <!--<a type="button" class="btn btn-primary" href="" target="_self">下一步&nbsp;></a>-->
                    <button type="submit" class="btn btn-primary">下一步</button>
                </li>
            </ul>
        </form>

    </div>

	<input name="projectId" value="${projectId}" hidden="hidden"/>
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


<!--<ul class="topBtnGroup">
    <li><a href="">热点领域</a></li>
    <li><a href="">名会领域</a></li>
    <li>
        <i></i>
        <b></b>
        <a href="javascript:;" id="topBtn">返回顶部</a>
    </li>
</ul>-->


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
            closeWidth: "150",
            openWdith: "272"
        })


        $('input[name = "price-set"]').each(function (index, element) {
            $(this).click(function () {
                        if (index == 0) {
                            $('input[name = "priceInput"]').attr({
                                "disabled": false,
                            })
                        } else {
                            $('input[name = "priceInput"]').attr({
                                "disabled": true,
                            })
                        }
                    }
            )

        });

        //表单验证开始

        $("#priceForm").validate({

            //debug模式
            //debug: true,
            onkeyup: false,
            onfocusout: false,


            //验证成功了
            //success:function(lable){
            //
            //},

            "rules": {
                "priceInput": {
                    "required": true,
                },
            },//必须加逗号


            "messages": {
                "priceInput": {
                    "required": '请输入金额',
                },

            },
        })

        //表单验证结束

    })


</script>

<!-- 验证是否session过期登录 -->
<%-- <script type="text/javascript">
$(function() {

    var userInfoId = '<%=session.getAttribute("userInfoId")%>';
    var projectId = '<%=session.getAttribute("projectId")%>';
    /*
    if(userInfoId == "null") { //当session中没有值时， js获取到的是"null"，而不是null
        $('#signBtn').click();           
    }
    */
    if(projectId == "null") {
        //alert("发布项目等待时间太久，请重新发布");
    	$().sessionExpiredDia();
    }
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

function checklogin() {
	//未登录
	if (!islogin()) {
		$().sessionExpiredDia();
		return false;
	}
	return true;
}

</script>
</body>

</html>
