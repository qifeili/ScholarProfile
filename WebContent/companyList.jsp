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

<link rel="shortcut icon" href="images/tablogo.png" type="image/x-icon">
<title>专家 - Comwit</title>
<link href="css/reset.css" rel="stylesheet">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

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
<body class="companyList clearfix">

	<!-- Navigation -->
	<nav class="navbar mynav navbar-inverse navbar-fixed-top"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">Comwit</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="<!--collapse--> navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-life">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="expertlist.do" class="active">专家</a></li>
					<li><a href="projectlist.do">项目</a></li>
					<li><a href="">社区</a></li>

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

	                <li class="floatLelt" id="logouted">
	                    <a href="" id="signBtn">登录</a>
	                </li>
	                -->

					<li class="floatLelt message"><a href="#"> <i
							class="fa fa-envelope-o"></i>
							<ul class="messageList">
								<li class="title">message</li>
								<a href=""><li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li></a>
								<a href=""><li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li></a>
								<a href=""><li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li></a>
							</ul>
					</a></li>
					<li class="floatLelt"><a href="" id="toPublishProject">发布项目</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>


	<!-- Page Content -->

	<header class="banner">
		<h1>搜你所需</h1>

		<form action="<%=basePath%>searchexpertlist.do" method="post">
			<div class="srcBoxList clearfix">

				<!--<select name="" id="srcType" class="srcType form-control">-->
				<!--<option value="">领域</option>-->
				<!--<option value="">研究者</option>-->
				<!--<option value="">组织机构</option>-->
				<!--</select>-->

				<div class="srcTypeWraper" id="srcTypeWraper">
					<input type="text" class="srcType form-control" id="srcType"
						<%-- name="srcType" readonly value="${srcType}" /> --%>
						name="srcType" readonly value="${srcType == null ? '领域' : srcType}" />
					<ul class="srcTypeList" id="srcTypeList">
						<li class="active" >领域</li>
						<li>研究者</li>
						<li>组织机构</li>
					</ul>
				</div>

				<input type="text" class="srckey form-control" id="srcText"
					name="srcText" placeholder="请输入领域关键字" value="${srcText}" />
				<!--<input type="submit" value="" class="srcSub"/>-->
				<button type="submit" class="srcSub">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</form>
	</header>

	<div class="container">

		<!-- Marketing Icons Section -->
		<h4 class="page-header">为你找到${scholarNum}位相关领域的专家</h4>

		<div class="clearfix">
			<div id="" class="leftCol">

				<ul class="companyListCon">
					<c:forEach items="${scholars}" var="s">
				<%-- 	<%String name=new String((request.getParameter("${s.name}")).getBytes("iso-8859-1"),"utf-8"); 
					String institution=new String((request.getParameter("${s.institution}")).getBytes("iso-8859-1"),"utf-8");
					%> --%>
						<a href="companyInfo.do?name=${s.name}&institution=${s.institution}">         
							<li class="companyListItem">
								<!--<img src="images/blurred.png" alt="" class="blurred"/>-->
								<div class="companyWiew clearfix">
								    <!-- 
									<img src="<%=basePath%>photos/${s.name}.jpg" alt=""
										class="companyLogo" />
									-->
									<img src="<%=basePath%>images/scholar_default.png" alt=""
										class="companyLogo" />

									<div class="companyUrl">
										<h1>${s.name}</h1>

										<p>${s.institution}</p>
									</div>
									<button class="review">
										<i class="fa fa-plus"></i>&nbsp;&nbsp;邀请
									</button>
								</div>
								<div class="commentBox clearfix">
									<ul class="clearfix">
										<a href="">
											<li class="interviewsNun"><i>${s.reference}</i> <b>被引频次</b></li>
										</a>

										<a href="">
											<li class="SalariesNun"><i>${s.outcome}</i> <b>成果数</b></li>
										</a>
										<a href="">
											<li class="reviewNun"><i>${s.follow}</i> <b>关注数</b></li>
										</a>
									</ul>
									<div class="gade">
										<c:choose>
											<c:when test="${s.isFollowByCurrentUser == true}">  
												<i class="fa fa-heart" onclick="addOrRemoveFocus(this, ${s.id})"></i>
											</c:when>
											<c:otherwise>
												<i class="fa fa-heart-o" onclick="addOrRemoveFocus(this, ${s.id})"></i>
											</c:otherwise>
										</c:choose>
									</div>
								</div>

						</li>
						</a>
					</c:forEach>

				</ul>
				<nav class="paginationWraper clearfix">
					<form
						action="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&">
						<ul class="pagination">
							<c:if test="${requestScope.curPage <= 0}">

							</c:if>
							<c:if
								test="${requestScope.curPage != 1 && requestScope.curPage > 0}">
								<li><a
									href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=${curPage-1}">上一页</a></li>
								<li><a
									href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=1">1</a></li>
								<c:if test="${curPage-1 != 1}">
									<li><span>...</span></li>
									<li><a
										href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=${curPage-1}">${curPage-1}</a></li>
								</c:if>
							</c:if>
						 	<c:if test="${requestScope.curPage > 0}">
								<li><a href="javascript:;" style="color: #6CF;"
									class="active">${curPage}</a></li>
							</c:if>
							<c:if test="${curPage != maxPage}">
								<c:if test="${curPage+1 != maxPage}">
									<li><a
										href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=${curPage+1}">${curPage+1}</a></li>
									<li><span>...</span></li>
								</c:if>
								<li><a
									href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=${maxPage}">${maxPage}</a></li>
								<li><a
									href="<%=basePath%>searchexpertlist.do?srcType=${srcType}&srcText=${srcText}&curPage=${curPage+1}">下页</a></li>
							</c:if>
						</ul>
					</form>
				</nav> 
			</div>
			<div class="siderDis">
				<h1>你可能感兴趣的领域/学者</h1>
				<ul class="jobLikeList">
					<a href="#">
						<li class="jobLikeListItems clearfix"><img
							src="images/lcy.jpg" class="jobLikeimg" alt="" />

							<p class="title">李春英</p>

							<p>服务计算、协同软件</p></li>
					</a>
					<a href="#">
						<li class="jobLikeListItems clearfix"><img
							src="images/fjx.png" class="jobLikeimg" alt="" />

							<p class="title">方家轩</p>

							<p>信息服务、协同软件、移动互联网应用</p></li>
					</a>
					<a href="#">
						<li class="jobLikeListItems clearfix"><img
							src="images/zwq.jpg" class="jobLikeimg" alt="" />

							<p class="title">曾伟铨</p>

							<p>大数据挖掘、网络与信息安全</p></li>
					</a>
					<a href="#">
						<li class="jobLikeListItems clearfix"><img
							src="images/cc.jpg" class="jobLikeimg" alt="" />

							<p class="title">陈成</p>

							<p>商业智能、数据仓库</p></li>
					</a>
					<a href="#">
						<li class="jobLikeListItems clearfix"><img
							src="images/jobLikeimg.png" class="jobLikeimg" alt="" />

							<p class="title">官全龙</p>

							<p>动安全、信息安全、网络安全、软件工程</p></li>
					</a>
				</ul>
			</div>
		</div>


	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<p>Copyright &copy; Your Website 2014</p>
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
		interval : 5000
	//changes the speed
	})
</script>

<script>
	$(function() {
		//返回顶部
		$('#topBtn').toTop();

		//应用手风琴插件
		$('#acc').accordion();

		//应用tab插件
		$('.tab').tabs();

		$("a").get().hideFocus = "true";

		//banner搜索框开始
		$('#srcTypeList li').click(function() {

			$('#srcTypeList li').removeClass('active');
			$(this).addClass('active');

			var srcTextPlaArr = [ "请输入领域关键字", "请输入研究者姓名", "请输入组织机构名" ];

			$('#srcType').val($(this).text());

			$('#srcText').attr({
				"placeholder" : srcTextPlaArr[$(this).index()]
			});
			$('#srcTypeList').hide();

		});

		$('.srcTypeWraper').hover(function() {
			$('.srcTypeList').show();
		}, function() {
			$('.srcTypeList').hide();
		});

		//防止聚焦
		$('#srcType').focus(function() {
			$(this).blur();
		});

		//banner搜索框结束

		//应用动态search插件
		$('#searchGroupWraper').dySearchBox({
			closeWidth : "150",
			openWdith : "272"
		});

		//关注专家
		$('.gade i').hover(function() {
			if ($(this).hasClass('fa-heart-o')) {
				$(this).removeClass("fa-heart-o");
				$(this).addClass("fa-heart");
			} else {
				$(this).removeClass("fa-heart");
				$(this).addClass("fa-heart-o");
			}

		}, function() {
			if ($(this).hasClass('fa-heart-o')) {
				$(this).removeClass("fa-heart-o");
				$(this).addClass("fa-heart");
			} else {
				$(this).removeClass("fa-heart");
				$(this).addClass("fa-heart-o");
			}
		})

	})
</script>
<script type="text/javascript">
	function addOrRemoveFocus(obj, scholarId) {
		$.ajax({
			url : 'changeFocusAjax.do?scholarId=' + scholarId,
			type : 'GET',
			dataType : 'text',
			success : function(data) {
				if (data == 'true') {
					//改变关注按钮的显示
					if (obj.className == 'fa fa-heart') {//添加关注							
						obj.className = 'fa fa-heart-o';
					} else if (obj.className == 'fa fa-heart-o') {//取消关注
						obj.className = 'fa fa-heart';
					}

				} else if (data == 'false') {
					$('#signBtn').click();
				}
			},
			error : function(err) {
				alert(err + "失败了");
			}
		});
	}
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
