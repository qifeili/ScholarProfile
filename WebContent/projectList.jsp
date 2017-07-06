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
<title> 项目 - Comwit</title>
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
<body class="projectList clearfix">

	<!-- Navigation -->
	<nav class="navbar mynav navbar-inverse navbar-fixed-top"
		role="navigation">
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
			<div class="<!--collapse--> navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-life">
					<li><a href="index.jsp">首页</a></li>
					<li><a href="expertlist.do">专家</a></li>
					<li><a href="projectlist.do" class="active">项目</a></li>
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

                <li class="floatLelt">
                    <a href="" id="signBtn">登录</a>
                </li>
                -->
					
					<li class="floatLelt message"><a href="#"> <i
							class="fa fa-envelope-o"></i>
							<ul class="messageList">
								<li class="title">提醒</li>
								<a href="">
									<li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li>
								</a>
								<a href="">
									<li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li>
								</a>
								<a href="">
									<li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li>
								</a>
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


		<div class="bannerinner clearfix">
			<h1>搜你所需</h1>

			<form action="<%=basePath%>searchprojectlist.do" class="clearfix">
				<ul class="srcBoxList clearfix">


					<li class="clearfix srcBoxListOption srckeyWraper"><input
						type="text" name="srcText" value="${srcText}"
						class="srckey form-control" id="srckey" placeholder="请输入项目关键字" />
						<input type="hidden" name="searchType" value="h" />
						<!--<input type="submit" value="" class="srcSub"/>-->
						<button type="submit" class="srcSub">
							<i class="fa fa-search"></i>
						</button>
						<div class="supperSrcBtn">
							<i class="fa fa-chevron-down"></i>&nbsp;高级搜索
						</div> <!--<button type="submit" class="srcSub"><i class="fa fa-search"></i>-->
						<!--</button>--></li>

					<li class="clearfix srcBoxListOption projectTypeWraper"><label
						class="srcBoxListOptionLabel">项目类型：</label> <label><input
							type="checkbox" name="projectTypeRadio" id="" value="培训讲座" /><i
							class="type01">培训讲座</i></label> <label><input type="checkbox"
							name="projectTypeRadio" id="" value="应用软件" /><i class="type02">应用软件</i></label>
						<label><input type="checkbox" name="projectTypeRadio"
							id="" value="算法研究" /><i class="type03">算法研究</i></label> <span
						class="srcTip">默认情况下搜索所有项目类型</span></li>

					<!--autoComplete开始-->
					<li class="clearfix srcBoxListOption projectTypeWraper"><label
						class="srcBoxListOptionLabel">项目领域：</label>

						<div class="autoComplete" id="autoComplete">
							<div class="autoComplete-downBtn" id="autoComplete-downBtn">下拉</div>
							<input type="text" name="fieldName" id="autoComplete-input"
								class="autoComplete-input" autocomplete="off"
								disableautocomplete placeholder='输入领域' />
							<ul class="autoComplete-list" id="autoComplete-list">
							</ul>
						</div></li>
					<!--autoComplete结束-->
					
					<!-- 热门领域数据动态填充 -->
					<c:if test="${!empty hotFieldNames}">
					<li class="clearfix srcBoxListOption areaDesWraper">
					<c:forEach items="${hotFieldNames}" var="hotFieldName" >
	         			<span>${hotFieldName}</span>
	                </c:forEach>
					</li>
					</c:if>
					 
				</ul>
				<button type="submit" class="srcSub">
					<i class="fa fa-search"></i>&nbsp;&nbsp;搜索
				</button>
				<!-- 记录查询类型 , 0表示普通搜索， 1表示高级搜索-->
				<input id="searchType" name="searchType" type="hidden" value="0">
			</form>

		</div>


	</header>

	<div class="container">

		<!-- Marketing Icons Section -->
		<h4 class="page-header">为你找到${projectNum}个相关领域的项目</h4>

		<div class="clearfix">
			<div id="" class="leftCol">
				<ul class="projectListCon">
					<c:forEach items="${projects}" var="p">
						<li class="projectListItem" >
							<ul class="clearfix">
								<li class="projectListItem-column"><img
									src="images/jobLikeimg.png" class="companyLogo" alt="" />

									<h1>
										<a href="<%=basePath%>projectInfoDetail.do?projectId=${p.id}">${p.title}</a>
									</h1>

									<h2>${p.projectType}</h2>

									<p>
                						${p.summary}
									</p>
								</li>
								<li class="projectListItem-column">¥ ${p.budget}</li>
								<%-- <li class="projectListItem-column">
								<!-- <i class="fa fa-heart"></i> -->
									<c:choose>
										<c:when test="${s.isFollowByCurrentUser == true}">  
											<i class="fa fa-heart" onclick="addOrRemoveFocusProject(this, ${p.id})"></i>
										</c:when>
										<c:otherwise> 
											<i class="fa fa-heart-o" onclick="addOrRemoveFocusProject(this, ${p.id})"></i>
										</c:otherwise>
									</c:choose>
								</li> --%>
								<li class="projectListItem-column">
									<div class="gade">
										<c:choose>
											<c:when test="${p.isFollowByCurrentUser == true}">  
												<i class="fa fa-heart" onclick="addOrRemoveFocusProject(this, ${p.id})"></i>
											</c:when>
											<c:otherwise> 
												<i class="fa fa-heart-o" onclick="addOrRemoveFocusProject(this, ${p.id})"></i>
											</c:otherwise>
										</c:choose>
									</div>
								</li>
							</ul>
						</li>
					</c:forEach>
				</ul>
				<nav class="paginationWraper clearfix">
					<form
						action="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}">
						<ul class="pagination">
							<c:if test="${requestScope.curPage <= 0}">

							</c:if>
							<c:if
								test="${requestScope.curPage != 1 && requestScope.curPage > 0}">
								<li><a
									href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=${curPage-1}">上一页</a></li>
								<li><a
									href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=1">1</a></li>
								<c:if test="${curPage-1 != 1}">
									<li><span>...</span></li>
									<li><a
										href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=${curPage-1}">${curPage-1}</a></li>
								</c:if>
							</c:if>
							<c:if test="${requestScope.curPage > 0}">
								<li><a href="javascript:;" style="color: #6CF;"
									class="active">${curPage}</a></li>
							</c:if>
							<c:if test="${curPage != maxPage}">
								<c:if test="${curPage+1 != maxPage}">
									<li><a
										href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=${curPage+1}">${curPage+1}</a></li>
									<li><span>...</span></li>
								</c:if>
								<li><a
									href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=${maxPage}">${maxPage}</a></li>
								<li><a
									href="<%=basePath%>searchprojectlist.do?srcText=${srcText}&projectTypeRadio=${projectTypeRadio}&fieldName=${fieldName}&curPage=${curPage+1}">下一页</a></li>
							</c:if>
						</ul>
					</form>
				</nav>
			</div>
			<div class="siderDis">
				<h1>你可能感兴趣的领域/学者</h1>
				<ul class="jobLikeList">

					<li class="jobLikeListItems clearfix"><img
						src="images/lcy.jpg" class="jobLikeimg" alt="" />

						<p class="title">
							<a href="#">李春英</a>
						</p>

						<p>服务计算、协同软件</p></li>


					<li class="jobLikeListItems clearfix"><img
						src="images/fjx.png" class="jobLikeimg" alt="" />

						<p class="title">
							<a href="#">方家轩</a>
						</p>

						<p>信息服务、协同软件、移动互联网应用</p></li>


					<li class="jobLikeListItems clearfix"><img
						src="images/zwq.jpg" class="jobLikeimg" alt="" />

						<p class="title">
							<a href="#">曾伟铨</a>
						</p>

						<p>大数据挖掘、网络与信息安全</p></li>


					<li class="jobLikeListItems clearfix"><img src="images/cc.jpg"
						class="jobLikeimg" alt="" />

						<p class="title">
							<a href="#">陈成</a>
						</p>

						<p>商业智能、数据仓库</p></li>


					<li class="jobLikeListItems clearfix"><img
						src="images/jobLikeimg.png" class="jobLikeimg" alt="" />

						<p class="title">
							<a href="#">官全龙</a>
						</p>

						<p>动安全、信息安全、网络安全、软件工程</p></li>

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

		$('#topBtn').toTop();

		//应用手风琴插件
		$('#acc').accordion();

		//应用tab插件
		$('.tab').tabs();

		$("a").get().hideFocus = "true";

		$('#searchGroupWraper').dySearchBox({
			closeWidth : "150",
			openWdith : "272"
		})

		//banner搜索框开始
		$('#srcType').change(
				function() {
					var srcTextPlaArr = [ "请输入领域关键字", "请输入研究者姓名",
							"请输入组织机构名", '4' ];
					$('#srcText').attr(
							{
								'placeholder' : srcTextPlaArr[$(this)
										.children('option:selected')
										.index()]
							})
				});
		//banner搜索框结束

		//应用带下拉选项的自动完成搜索框插件
		$('#autoComplete').autoCompleteSreachBox();

		$('.projectList .banner .srcBoxList .areaDesWraper span')
				.click(
						function() {
							$(
									'.projectList .banner .srcBoxList .areaDesWraper span')
									.css({
										"background" : "#fff",
										"color" : "#000",
									})
							$(this).css({
								"background" : "rgb(43, 161, 230)",
								"color" : "#fff",
							})
							$('#autoComplete-input').val($(this).text());
						});

		//高级搜索开始
		var supperSrcBtnSwitch = 0;
		$('.supperSrcBtn').click(function() {
			if (supperSrcBtnSwitch == 0) {
				$('.srcBoxList>li+li,.bannerinner form>.srcSub').css({
					"display" : "block"
				});
				$('.srcBoxList .srcSub').hide();
				$('.supperSrcBtn i').css({
					"transform" : "rotate(180deg)"
				});
				supperSrcBtnSwitch = 1;
				$("#searchType").val("1");

			} else {
				$('.srcBoxList>li+li,.bannerinner form>.srcSub').hide();
				$('.srcBoxList .srcSub').show();
				$('.supperSrcBtn i').css({
					"transform" : "rotate(0deg)"
				});
				supperSrcBtnSwitch = 0;
				$("#searchType").val("0");
			}

		}
		//高级搜索结束
		
		)
		
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
<!-- 改变关于项目的关注状态 -->
<script type="text/javascript">
	function addOrRemoveFocusProject(obj, projectId) {
		$.ajax({
			url : 'changeFocusProjectAjax.do?projectId=' + projectId,
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
    if(userInfoId == "null" || userInfoId == null) {
        //$('#logined').hide();
        //$('#logouted').show();
        addLoginBtn();
        $('#signUpFrame').show();
        $('#interestFrame').hide();
    }else {
        //$('#logined').show();
        //$('#logouted').hide();
        addLoginLogo();
        $('#signUpFrame').hide();
        $('#interestFrame').show();
    }
});

</script>
<!-- 根据上次搜索显示高级搜索或者是普通搜索 -->
<script type="text/javascript">
$(function() {
    var searchType = '<%=request.getAttribute("searchType")%>';
    //切换显示
    if(searchType == "1") {//高级搜索
    	$('.supperSrcBtn').click();
    	//alert("高级搜索");
    }else {//普通搜索
        //alert("普通搜索");
    }
});

</script>

</body>

</html>
