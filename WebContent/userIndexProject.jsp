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

    <title>userIndexProject</title>
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
<body class="userIndexProject clearfix">

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
                    <li class="userMenuListIetms"><a href="#"  class="active">我的项目</a></li>
                    <li class="userMenuListIetms"><a href="userIndexMessage.do">我的消息</a></li>
                    <li class="userMenuListIetms"><a href="userIndexAccount.do">账号管理</a></li>
                </ul>
            </div>
            <div class="rightCol">

                <div class="userAcconut">
                    <h1>我的项目</h1>
                    <ul class="reviewExpertList">
                        <!--项目列表标题-->
                        <li class="reviewExpertListTitle clearfix">
                            <ul class="reviewExpertListTitleList">
                                <li class="items">项目名称</li>
                                <li class="items">项目状态</li>
                            </ul>
                        </li>
                        <!--项目列表-->
                       	<c:forEach items="${myProjects}" var="p">
	                        <li class="reviewExpertListItems working">
	                            <ul class="reviewExpertListItemsList clearfix">
	                                <li class="items">
	                                    <img class="companyLogo" src="images/jobLikeimg.png" alt="">${p.title}
	                                </li>
	                                <li class="items">${p.stage}</li>
	                                
	                                <c:choose>
										<c:when test="${p.status == 0}">  
											<li class="items"><button class="btn btn-primary" onclick="continuePublishing(${p.id})">继续发布</button></li>
										</c:when>
										<c:otherwise> 
											<li class="items">
												<div class="progressBarWraper">
			                                        <ul class="progressList clearfix">
			                                            <li class="progressListItems"><label><input type="radio" name="progressRadio" id=""><i class=" fa fa-check"></i><span class="text">匹配专家</span></label></li>
			                                            <li class="progressListItems"><label><input type="radio" name="progressRadio" id=""><i class=" fa fa-check"></i><span class="text">合作洽谈</span></label></li>
			                                            <li class="progressListItems"><label><input type="radio" name="progressRadio" id=""><i class=" fa fa-check"></i><span class="text">项目研究</span></label></li>
			                                            <li class="progressListItems"><label><input type="radio" name="progressRadio" id=""><i class=" fa fa-check"></i><span class="text">项目验收</span></label></li>
			                                        </ul>
			                                    </div>
			                                    <button class="btn btn-primary updataState" >更新状态</button>
											</li>
										</c:otherwise>
									</c:choose>
	                            </ul>
	                        </li>
						</c:forEach>
                      
                    </ul>
                    <nav class="paginationWraper clearfix">
	                 	<ul class="pagination">
							<c:if test="${requestScope.curPage <= 0}">

							</c:if>
							<c:if
								test="${requestScope.curPage != 1 && requestScope.curPage > 0}">
								<li><a
									href="<%=basePath%>userIndexProject.do?curPage=${curPage-1}">上一页</a></li>
								<li><a
									href="<%=basePath%>userIndexProject.do?curPage=1">1</a></li>
								<c:if test="${curPage-1 != 1}">
									<li><span>...</span></li>
									<li><a
										href="<%=basePath%>userIndexProject.do?curPage=${curPage-1}">${curPage-1}</a></li>
								</c:if>
							</c:if>
							<c:if test="${requestScope.curPage > 0}">
								<li><a href="javascript:;" style="color: #6CF;"
									class="active">${curPage}</a></li>
							</c:if>
							<c:if test="${curPage != maxPage}">
								<c:if test="${curPage+1 != maxPage}">
									<li><a
										href="<%=basePath%>userIndexProject.do?curPage=${curPage+1}">${curPage+1}</a></li>
									<li><span>...</span></li>
								</c:if>
								<li><a
									href="<%=basePath%>userIndexProject.do?curPage=${maxPage}">${maxPage}</a></li>
								<li><a
									href="<%=basePath%>userIndexProject.do?curPage=${curPage+1}">下一页</a></li>
							</c:if>
						</ul>
					</nav>
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
        })


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

<!--继续发布项目-->
<script type="text/javascript">
function continuePublishing(projectId) {
        $.ajax({
            url : 'continuePublishProject.do?projectId=' + projectId,
            type : 'GET',
            dataType : 'text',
            success : function(data) {
                window.location.href = data;
                return false;
            },
            error : function(err) {
                alert(err + "失败了");
            }
        });
    }
    
//gengxinzhangtai1
(function(){
    $('.userIndexProject .progressListItems label input:checked').each(function(index,ele){
        $(ele).parent().parent().prevUntil().addClass('over');
    });
    $('.userIndexProject .progressListItems label').click(function (){
        $(this).parent().parent().find('li').removeClass('over');
        $(this).parent().prevUntil().addClass('over');
    });
   return function(){
        $('.updataState').each(function(index,ele){
            var swich = 0;
            return (function(){
                $(ele).click(function(){
                    if(swich == 0){
                        $(ele).text('确定修改').prev().show().removeClass('fadeOutRight').addClass('fadeInRight');
                        swich = 1;
                    }else{
                        $(ele).text('更新状态').prev().removeClass('fadeInRight').addClass('fadeOutRight');
                        $.ajax({
                            url:"php1.php",
                            data:{},
                            type:'GET',
                            success:function(response,status,xhr){
                                if(response == ture){
                                    //console.log('quxiao');
                                    $(ele).parent().parent().parent('.reviewExpertListItems').remove();
                                }
                            },
                            error: function () {
                                $().setiingTip({text:'修改成功',type:1});
                            }

                        });

                        swich = 0;
                    }
                });
            })();
        });
    };
})()();
    
</script>
</body>

</html>
