<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<meta property="qc:admins" content="73703036616426326117330741202761457" />
<link rel="shortcut icon" href="images/tablogo.png" type="image/x-icon">
<title>首页 - Comwit</title>
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

</head>
<body class="index clearfix">

	<!-- Navigation -->
	<nav class="navbar mynav navbar-inverse navbar-fixed-top"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<!--
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
-->
				<a class="navbar-brand" href="/">Comwit</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="<!--collapse--> navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-life">
					<li><a href="index.jsp" class="active">首页</a></li>
					<li><a href="expertlist.do">专家</a></li>
					<li><a href="projectlist.do">项目</a></li>
					<li><a href=""> 社区 </a></li>

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
					<li class="floatLelt Account" id="logined"><a
						href="javascript:void();" id=""><i class="fa fa-user"></i></a>
						<ul class="AccountMenuList">
							<li class="AccountMenuListItem"><a
								href="userIndexReviews.do">我的关注</a></li>
							<li class="AccountMenuListItem"><a
								href="userIndexProject.do">我的项目</a></li>
							<li class="AccountMenuListItem"><a
								href="userIndexMessage.do">我的消息</a></li>
							<li class="AccountMenuListItem"><a
								href="userIndexAccount.do">账号管理</a></li>
							<li class="AccountMenuListItem"><a href="" id="toLogout">退出登陆</a></li>
						</ul></li>
					<li class="floatLelt" id="logouted"><a href="" id="signBtn">登录</a></li>
					-->
					<li class="floatLelt message"><a href="#"> <i
							class="fa fa-envelope-o"></i>
							<ul class="messageList">
								<li class="title">提醒</li>
								<a href=""><li class="messageListItem">
								Comwit是一个服务于企业和研究人员的平台。致力于通过机器学习算法帮助企业寻找“最强大脑”，解决技术难题。
								<span class="time">2016-03-01</span>
								</li></a>
								<!-- 
								<a href=""><li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li></a>
								<a href=""><li class="messageListItem">Big Technical
										Support—中国领先的服务众包平台,注册用户超过了1300万...<span class="time">12-03</span>
								</li></a>
								 -->
							</ul>
					</a></li>
					<li class="floatLelt">
						<a href="" id="toPublishProject">发布</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Header Carousel -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active carousel01">
				<div class="fill carousel01Img"
					style="background-image: url('images/carousel01.jpg'); background-size: cover;">
					<h2 class="overview-title">汇聚全球智慧</h2>
					<ul class="data-list">
						<li class="data-list-Items data-list-Item01">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>推荐系统</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item02">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>时空预测</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item03">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>人脸识别</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item04">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>社交网络</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item05">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>图像分割</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item06">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>物联网</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item07">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>无线传感器网络</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item08">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>移动对象数据管理</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item09">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>语义WEB</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
						<li class="data-list-Items data-list-Item10">
							<div class="ctn">
								<!--<em>10.5PB</em>-->
								<p>图像处理</p>
							</div>
							<div class="po">
								<div class="light"></div>
								<div class="dot"></div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="item carousel02">
				<div class="fill clearfix" style="">
					<h2 class="overview-title">科研技术对接服务</h2>

					<div class="carousel02Con clearfix">
						<ul class="dialogue">
							<li class="speak01 clearfix">
								<div class="head"></div>
								<div class="Content">
									<span class="diarrow"></span>
									我们项目组最近在开发商品的个性化推荐服务，但是准确率一直不高，该怎么办呢？
								</div>
							</li>
							<li class="speak02 clearfix">
								<div class="head"></div>
								<div class="Content">
									<span class="diarrow"></span>
									我的团队的研究领域就是个性化，在这个领域我们已经发表了数十篇顶级研究成果。你可以通过XXXXXX来提高算法的准确率。
								</div>
							</li>
						</ul>

						<!--Echarts-->
						<div id="carousel02-Echart-line"></div>
					</div>
				</div>

			</div>
			<div class="item carousel03">

				<div class="fill" style="">
					<h2 class="overview-title">个人成果展示</h2>
				</div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>
	</header>

	<!-- Page Content -->
	<div class="container">

		<!-- Marketing Icons Section -->
		<h1 class="page-header hrefTopTarget01">热点领域</h1>

		<div class="clearfix">
			<div class="TechnologyDis clearfix">
				<ul class="TechnologyDis-row clearfix">
					<c:forEach items="${indexInfo.hotFields}" var="f"
						varStatus="fStatus" end="2">
						<li class="TechnologyDisPanel">
							<h1 class="">${f.fieldName}</h1>
							<a class="more"
							href="<%=basePath%>searchexpertlist.do?srcType=领域&srcText=${f.fieldName}">更多</a>
							<dl>
								<dt>
									<a href="#">${f.scholar1.name} ${f.scholar1.education}</a>
								</dt>
								<dd>${f.scholar1.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar2.name} ${f.scholar2.education}</a>
								</dt>
								<dd>${f.scholar2.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar3.name} ${f.scholar3.education}</a>
								</dt>
								<dd>${f.scholar3.institution}</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
				<ul class="TechnologyDis-row clearfix">
					<c:forEach items="${indexInfo.hotFields}" var="f"
						varStatus="fStatus" begin="3" end="5">
						<li class="TechnologyDisPanel">
							<h1 class="">${f.fieldName}</h1> <a class="more"
							href="<%=basePath%>searchexpertlist.do?srcType=领域&srcText=${f.fieldName}">更多</a>
							<dl>
								<dt>
									<a href="#">${f.scholar1.name} ${f.scholar1.education}</a>
								</dt>
								<dd>${f.scholar1.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar2.name} ${f.scholar2.education}</a>
								</dt>
								<dd>${f.scholar2.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar3.name} ${f.scholar3.education}</a>
								</dt>
								<dd>${f.scholar3.institution}</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
				<ul class="TechnologyDis-row clearfix">
					<c:forEach items="${indexInfo.hotFields}" var="f"
						varStatus="fStatus" begin="6">
						<li class="TechnologyDisPanel">
							<h1 class="">${f.fieldName}</h1>
							<a class="more"
							href="<%=basePath%>searchexpertlist.do?srcType=领域&srcText=${f.fieldName}">更多</a>
							<dl>
								<dt>
									<a href="#">${f.scholar1.name} ${f.scholar1.education}</a>
								</dt>
								<dd>${f.scholar1.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar2.name} ${f.scholar2.education}</a>
								</dt>
								<dd>${f.scholar2.institution}</dd>
							</dl>
							<dl>
								<dt>
									<a href="#">${f.scholar3.name} ${f.scholar3.education}</a>
								</dt>
								<dd>${f.scholar3.institution}</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div class="siderDis" id="">
				<div class="signUp" id="signUpFrame">
					<h1>注册以获取个性化服务</h1>

					<div class="trilateralLogInBtnGro">
						<a href="#" class="weixin"></a> 
						<a href="<%=basePath%>QQAuthorize.do" class="qq"></a> 
						<a href="#" class="weibo"></a>
					</div>
					<div class="or">
						<span>or</span>
					</div>
					<%-- <form action="<%=basePath%>register.do" class="signUpForm"> --%>
					<!-- <form action="registerStep01.jsp" class="signUpForm" id="signUpForm">
                     <input type="text" class="form-control" name="emailOrNumber"  placeholder="邮箱/手机号"/>
                    <input type="password" class="form-control" name="password" placeholder="密码(6-16位)"/>
                    <input type="text" class="form-control" name="signUpDialogNumInput"  placeholder="邮箱/手机号"/>
                    <input type="password" class="form-control" name="signUpDialogPassInput" placeholder="密码(6-16位)"/>

                    <h1 class="Agreement">点击注册按钮，同意本网站的 <a href="#">用户使用协议</a>
                        和 <a href="#">隐私策略。</a></h1>
                    <input type="submit" value="注册"/>
                </form>   -->

					<form action=" registerStep01.jsp" class="signUpForm"  	id="signUpAsideForm" method="post"> <!--  registerStep01.jsp -->
						<input type="text" class="form-control" name="signUpAsideNumInput"
							placeholder="邮箱/手机号" /> <input type="password"
							class="form-control" name="signUpAsidePassInput"
							placeholder="密码(6-16位)" />
						<h1 class="Agreement">
							点击注册按钮，同意本网站的 <a href="#">用户使用协议</a> 和 <a href="#">隐私策略。</a>
						</h1>
						<input type="submit" value="注册" class="double" />
					</form>
				</div>

				<div class="interest" id="interestFrame" hidden="hidden">
					<h1>你可能感兴趣的领域/学者</h1>
					<ul class="jobLikeList">

						<li class="jobLikeListItems clearfix"><img alt=""
							class="jobLikeimg" src="images/lcy.jpg">

							<p class="title">
								<a href="#">李春英</a>
							</p>

							<p>服务计算、协同软件</p></li>


						<li class="jobLikeListItems clearfix"><img alt=""
							class="jobLikeimg" src="images/fjx.png">

							<p class="title">
								<a href="#">方家轩</a>
							</p>

							<p>信息服务、协同软件、移动互联网应用</p></li>


						<li class="jobLikeListItems clearfix"><img alt=""
							class="jobLikeimg" src="images/zwq.jpg">

							<p class="title">
								<a href="#">曾伟铨</a>
							</p>

							<p>大数据挖掘、网络与信息安全</p></li>


						<li class="jobLikeListItems clearfix"><img alt=""
							class="jobLikeimg" src="images/cc.jpg">

							<p class="title">
								<a href="#">陈成</a>
							</p>

							<p>商业智能、数据仓库</p></li>


						<li class="jobLikeListItems clearfix"><img alt=""
							class="jobLikeimg" src="images/jobLikeimg.png">

							<p class="title">
								<a href="#">官全龙</a>
							</p>

							<p>动安全、信息安全、网络安全、软件工程</p></li>

					</ul>
				</div>
			</div>


		</div>

		<h1 class="page-header lastProjedt hrefTopTarget02">
			最新项目 <span class="more"><a
				href="<%=basePath%>searchprojectlist.do">更多</a></span>
		</h1>

		<ul class="projectListCon">

			<c:forEach items="${indexInfo.latestProjects}" var="p">
				<li class="projectListItem">
					<ul class="clearfix">
						<li class="projectListItem-column"><img
							src="images/jobLikeimg.png" class="companyLogo" alt="" />

							<h1>
								<a href="<%=basePath%>projectInfoDetail.do?projectId=${p.id}">${p.title}</a>
							</h1>

							<h2>${p.projectType}</h2> <!--<p>现已有logo设计，想做一个前台背后区域的logo...</p>--></li>
						<li class="projectListItem-column">¥ ${p.budget}</li>
						<li class="projectListItem-column"><i class="fa fa-heart-o"
							onclick="addOrRemoveFocusProject(this, ${p.id})"> </i></li>
					</ul>
				</li>
			</c:forEach>
		</ul>

		<h1 class="page-header hrefTopTarget03">名会领域</h1>

		<div class="enterPriseDis">
			<ul class="enterPriseDis-row clearfix">
				<li class="enterPriseDisPanel"><img src="images/cikm.jpg"
					class="enterpriseDis" alt="" />

					<h2>enterpriseDis</h2> <!--<img src="images/预算%20vs%20开销（Budget%20vs%20spending）.png" class="radar" alt=""/>-->
					<!--<div id="main" style="height:350px; width:620px; transform: scale(0.5);"></div>-->


				</li>
				<li class="enterPriseDisPanel"><img src="images/aaai.jpg"
					class="enterpriseDis" alt="" />

					<h2>enterpriseDis</h2> <!--<img src="images/预算%20vs%20开销（Budget%20vs%20spending）.png" class="radar" alt=""/>-->
				</li>
				<li class="enterPriseDisPanel"><img src="images/NIPS2015.jpg"
					class="enterpriseDis" alt="" />

					<h2></h2> <!--<img src="images/预算%20vs%20开销（Budget%20vs%20spending）.png" class="radar" alt=""/>-->
				</li>
				<li class="enterPriseDisPanel"><img src="images/NIPS2012.jpg"
					class="enterpriseDis" alt="" />

					<h2></h2> <!--<img src="images/预算%20vs%20开销（Budget%20vs%20spending）.png" class="radar" alt=""/>-->
				</li>
			</ul>
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
		<li class="active"><a href="hrefTopTarget01" class="hrefTop">热点领域</a></li>
		<li><a href="hrefTopTarget02" class="hrefTop">最新项目</a></li>
		<li><i></i> <b></b> <a href="javascript:;" id="topBtn">返回顶部</a></li>
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

//        返回顶端模块开始-----------------------------------------------------------------------------

        //跳转上滚
        $('.hrefTop').click(function () {
            $('html,body').animate({
                scrollTop: $("."+$(this).attr("href")).offset().top-80,
            }, 700);
            return false;
        });

        //返回顶端
        $('#topBtn').toTop();

        //滚动导航变色
        $(document).scroll(function () {
            $('.hrefTopTarget01,.hrefTopTarget02').each(function (index,element) {
                if(Math.abs(parseInt($(element).offset().top-95-$(document).scrollTop()))<=30){
                    if($(element).index() == 0){
                        $('.topBtnGroup li').removeClass('active');
                        $('.topBtnGroup li').eq(0).addClass('active');
                    }else if($(element).index() == 2)
                    {
                        $('.topBtnGroup li').removeClass('active');
                        $('.topBtnGroup li').eq(1).addClass('active');
                    }
                }
            });
        });

        //点击导航变色
        $('.topBtnGroup li a').click(function () {
            window.setTimeout(function(){
                $('.topBtnGroup li').removeClass('active');
                $('.topBtnGroup li a').parent('li').eq(1).addClass('active');
            },500)

        })




//        返回顶端模块结束-----------------------------------------------------------------------------

        //应用动态search插件
        $('#searchGroupWraper').dySearchBox({
            closeWidth: "150",
            openWdith: "272"
        });

        //首页侧边栏表单提示验证开始
        $("#signUpAsideForm").validate({

            //debug模式
            //debug:true,
            onkeyup: false,
            onfocusout: false,


            //验证成功了
            //success:function(lable){
            //
            //},

            "rules": {
                "signUpAsideNumInput": {
                    "required": true,
                    "Mobile||EMail": true,
                    //用户名单独执行ajax验证
                    "remote": {
                        url: "registerAjax.do",     //后台处理程序
                        //type: "post",               //数据发送方式
                        //dataType: "json",           //接受数据格式
                        data: {                     //要传递的数据
                            //要传递的数据
                            signUpDialogNumInput: function() {
                                return $('input[ name= "signUpAsideNumInput"]').val();
                            },
                            signUpDialogPassInput: function() {
                                return $('input[ name= "signUpAsidePassInput"]').val();
                            }
                        }
                    },
                    //判断控制器返回的内容
                    dataFilter: function (data) {
                        if (data == "true") {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                },
                "signUpAsidePassInput": {
                    "required": true,
                    "rangelength":[6,12],
                },
            },//必须加逗号


            "messages": {
                "signUpAsideNumInput": {
                    "required": '请输入账号',
                    "remote":"已经注册"
                },
                "signUpAsidePassInput": {
                    "required": '请输入密码',
                    'rangelength':'6-16位密码',
                },


            },
        })



        //首页侧边栏表单提示验证结束

        
        //关注专家
		$('.projectListItem-column i').hover(function() {
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

    });






    // 路径配置
    require.config({
        paths: {
            echarts: 'js/build/dist'	//设置根目录
        }
    });


    // 使用
    require(
            [
                'echarts',
                'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
                'echarts/chart/radar', // 使用雷达图就加载radar模块，按需加载
                'echarts/chart/line' // 使用雷达图就加载radar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('carousel02-Echart-line'), 'macarons');

                option = {

                    xAxis: [
                        {
                            type: 'category',
                            boundaryGap: false,
//								data : ['周一','周二','周三','周四','周五','周六','周日']
                            data: ['', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '']
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '邮件营销',
                            type: 'line',
                            stack: '总量',
                            data: [0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.85, 0.87, 0.88, 0.89, 0.90, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97]
                        },
                    ]
                };

                // 为echarts对象加载数据
                myChart.setOption(option);
            }
    );


</script>


	<!--<div id="signCon">\
    <img src="images/signConColseBtn.png" class="signConColseBtn" alt=""/>\
    <div id=signConTab>\
        <div class="tabBtnGro clearfix">\
            <div class="tabBtn">注册</div>\
            <div class="tabBtn">登录</div>\
        </div>\
        <div class="tabPlane">\
            <div class="signInDialog">\
                <h1>注册以获取个性化服务</h1>\
                <div class="trilateralLogInBtnGro">\
                    <a href="registerStep01.html" class="weixin"></a>\
                    <a href="registerStep01.html" class="qq"></a>\
                    <a href="registerStep01.html" class="weibo"></a>\
                </div>\
                <div class="or"><span>or</span></div>\
                <form action="registerStep01.html" class="signUpForm">\
                    <input type="text" class="form-control" placeholder="邮箱/手机号"/>\
                    <input type="text" class="form-control" placeholder="密码"/>\
                    <h1 class="Agreement">点击注册按钮，同意本网站的 <a href="#">用户使用协议</a>\
                        和 <a href="#">隐私策略。</a></h1>\
                    <input type="submit" value="注册"/>\
                </form>\
            </div>\
        </div>\
        <div class="tabPlane">\
            <div class="signInDialog">\
                <h1>登录以获取个性化服务</h1>\
                <div class="trilateralLogInBtnGro">\
                    <a href="#" class="weixin"></a>\
                    <a href="#" class="qq"></a>\
                    <a href="#" class="weibo"></a>\
                </div>\
                <div class="or"><span>or</span></div>\
                <form action="registerStep01.html" class="signUpForm">\
                    <input type="text" class="form-control" placeholder="邮箱/手机号"/>\
                    <input type="text" class="form-control" placeholder="密码"/>\
                    <input type="submit" value="登录"/>\
                </form>\
            </div>\
        </div>\
    </div>\
</div>\
<div id="signMask"></div>-->

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
</body>
</html>
