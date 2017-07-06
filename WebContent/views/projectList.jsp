<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>projectList</title>
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
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Start Bootstrap</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="<!--collapse--> navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-life">
					<li><a href="">首页</a></li>
					<li><a href="companyList.html" class="active">专家</a></li>
					<li><a href="">项目</a></li>
					<li><a href="">社区</a></li>

					<!--搜索框开始-->

					<li class="searchGroupWraper">
						<form action="">
							<div class="searchGroupClose">关闭</div>
							<div class="searchGroup">
								<div class="searchGroupCon clearfix">
									<input type="text" class="searchInput01 searchInput"
										placeholder="Search" /> <input type="text"
										class="searchInput02 searchInput" placeholder="123" />
								</div>
							</div>
							<button type="submit" class="searchGroupSubmit">提交</button>
							<ul class="searchGroupMenu">
								<li>1111</li>
								<li>1111</li>
								<li>1111</li>
							</ul>
						</form>

					</li>

					<!--搜索框开始-->


					<!--<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="portfolio-1-col.html">1 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-2-col.html">2 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-3-col.html">3 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-4-col.html">4 Column Portfolio</a>
                        </li>
                        <li>
                            <a href="portfolio-item.html">Single Portfolio Item</a>
                        </li>
                    </ul>
                </li>-->
					<!--<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="blog-home-1.html">Blog Home 1</a>
                        </li>
                        <li>
                            <a href="blog-home-2.html">Blog Home 2</a>
                        </li>
                        <li>
                            <a href="blog-post.html">Blog Post</a>
                        </li>
                    </ul>
                </li>-->
					<!--<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Other Pages <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="full-width.html">Full Width Page</a>
                        </li>
                        <li>
                            <a href="sidebar.html">Sidebar Page</a>
                        </li>
                        <li>
                            <a href="faq.html">FAQ</a>
                        </li>
                        <li>
                            <a href="404.html">404</a>
                        </li>
                        <li>
                            <a href="pricing.html">Pricing Table</a>
                        </li>
                    </ul>
                </li>-->
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Header Carousel -->
	<!--<header id="myCarousel" class="carousel slide">
    &lt;!&ndash; Indicators &ndash;&gt;
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    &lt;!&ndash; Wrapper for slides &ndash;&gt;
    <div class="carousel-inner">
        <div class="item active carousel01">
            <div class="fill carousel01Img"
                 style="background-image:url('images/carousel01.jpg'); background-size: cover;">
                <h2 class="overview-title">汇聚全球智慧</h2>
                <ul class="data-list">
                    <li class="data-list-Items data-list-Item01">
                        <div class="ctn">
                            &lt;!&ndash;<em>10.5PB</em>&ndash;&gt;
                            <p>推荐系统</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item02">
                        <div class="ctn">
                            &lt;!&ndash;<em>10.5PB</em>&ndash;&gt;
                            <p>时空预测</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item03">
                        <div class="ctn">
                            &lt;!&ndash;<em>10.5PB</em>&ndash;&gt;
                            <p>人脸识别</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item04">
                        <div class="ctn">
                            &lt;!&ndash;<em>10.5PB</em>&ndash;&gt;
                            <p>社交网络</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item05">
                        <div class="ctn">
                            &lt;!&ndash;<em>10.5PB</em>&ndash;&gt;
                            <p>图像分割</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item06">
                        <div class="ctn">
                            <em>10.5PB</em>
                            <p>扫描数据量/天</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item07">
                        <div class="ctn">
                            <em>10.5PB</em>
                            <p>扫描数据量/天</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item08">
                        <div class="ctn">
                            <em>10.5PB</em>
                            <p>扫描数据量/天</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item09">
                        <div class="ctn">
                            <em>10.5PB</em>
                            <p>扫描数据量/天</p>
                        </div>
                        <div class="po">
                            <div class="light"></div>
                            <div class="dot"></div>
                        </div>
                    </li>
                    <li class="data-list-Items data-list-Item10">
                        <div class="ctn">
                            <em>10.5PB</em>
                            <p>扫描数据量/天</p>
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
            <div class="fill clearfix">
                <h2 class="overview-title">科研技术对接服务</h2>
                <div class="carousel02Con clearfix">
                    <ul class="dialogue">
                        <li class="speak01 clearfix">
                            <div class="head"></div>
                            <div class="Content">
                                <span class="diarrow"></span>
                                我们项目组最近在开发商品的个性化推荐服务，但是准确率一直不高，该怎么办呢？</div>
                        </li>
                        <li class="speak02 clearfix">
                            <div class="head"></div>
                            <div class="Content">
                                <span class="diarrow"></span>
                                我的团队的研究领域就是个性化，在这个领域我们已经发表了数十篇顶级研究成果。你可以通过XXXXXX来提高算法的准确率。</div>
                        </li>

                    </ul>
                </div>
            </div>

        </div>
        <div class="item carousel03">
            <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div>
            <div class="carousel-caption">
                <h2>Caption 3</h2>
            </div>
        </div>
    </div>

    &lt;!&ndash; Controls &ndash;&gt;
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
</header>-->

	<!-- Page Content -->

	<header class="banner">
		<h1>搜你所需</h1>
		<form action="">
			<div class="srcBox clearfix">

				<div class="autoComplete" id="autoComplete">
					<div class="autoComplete-downBtn" id="autoComplete-downBtn">下拉</div>
					<input type="text" id="txt_value" class="autoComplete-input"
						autocomplete="off" disableautocomplete placeholder='输入领域' />
					<ul class="autoComplete-list" id="autoComplete-list">
					</ul>
				</div>

				<input type="text" class="srcText form-control" id="srcText"
					placeholder="请输入领域关键字" />
				<!--<input type="submit" value="" class="srcSub"/>-->
				<button type="submit" class="srcSub">
					<i class="fa fa-search"></i>
				</button>
			</div>
		</form>
	</header>

	<div class="container">

		<!-- Marketing Icons Section -->
		<h4 class="page-header">为你找到100+相关领域的专家</h4>

		<div class="clearfix">
			<div id="" class="leftCol">

				<ul class="companyListCon">
					<li class="companyListItem"><img src="images/blurred.png"
						alt="" class="blurred" />
						<div class="companyWiew clearfix">
							<img src="images/tangyong.jpg" alt="" class="companyLogo" />
							<div class="companyUrl">
								<h1>汤庸</h1>
								<p>华南师范大学计算机学院/广东省服务计算工程技术研究开发中心</p>
							</div>
							<button class="review">
								<i class="fa fa-plus"></i>&nbsp;&nbsp;Add a Review
							</button>
						</div>
						<div class="commentBox clearfix">
							<ul class="clearfix">
								<a href=""><li class="interviewsNun"><i>622</i> <b>被引频次</b>
								</li></a>

								<a href=""><li class="SalariesNun"><i>621</i> <b>成果数</b>
								</li></a>
								<a href=""><li class="reviewNun"><i>20</i> <b>关注数</b></li></a>
							</ul>
							<div class="gade">
								<i class="fa fa-heart"></i>
							</div>
						</div></li>
					<li class="companyListItem"><img src="images/blurred.png"
						alt="" class="blurred" />
						<div class="companyWiew clearfix">
							<img src="images/fuchengzhou.jpg" alt="" class="companyLogo" />
							<div class="companyUrl">
								<h1>傅城州</h1>
								<p>华南师范大学计算机学院/广东省服务计算工程中心</p>
							</div>
							<button class="review">
								<i class="fa fa-plus"></i>&nbsp;&nbsp;Add a Review
							</button>
						</div>
						<div class="commentBox clearfix">
							<ul class="clearfix">
								<a href=""><li class="interviewsNun"><i>62</i> <b>被引频次</b>
								</li></a>

								<a href=""><li class="SalariesNun"><i>21</i> <b>成果数</b>
								</li></a>
								<a href=""><li class="reviewNun"><i>60</i> <b>关注数</b></li></a>
							</ul>
							<div class="gade">
								<i class="fa fa-heart"></i>
							</div>
						</div></li>
					<li class="companyListItem"><img src="images/blurred.png"
						alt="" class="blurred" />
						<div class="companyWiew clearfix">
							<img src="images/yaojian.jpg" alt="" class="companyLogo" />
							<div class="companyUrl">
								<h1>姚剑</h1>
								<p>武汉大学遥感信息工程学院</p>
							</div>
							<button class="review">
								<i class="fa fa-plus"></i>&nbsp;&nbsp;Add a Review
							</button>
						</div>
						<div class="commentBox clearfix">
							<ul class="clearfix">
								<a href=""><li class="interviewsNun"><i>432</i> <b>被引频次</b>
								</li></a>

								<a href=""><li class="SalariesNun"><i>321</i> <b>成果数</b>
								</li></a>
								<a href=""><li class="reviewNun"><i>200</i> <b>关注数</b>
								</li></a>
							</ul>
							<div class="gade">
								<i class="fa fa-heart"></i>
							</div>
						</div></li>

				</ul>
				<nav class="pull-right">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
			<div class="siderDis">
				<h1>你可能感兴趣的领域/学者</h1>
				<ul class="jobLikeList">
					<a href="#"><li class="jobLikeListItems clearfix"><img
							src="images/lcy.jpg" class="jobLikeimg" alt="" />
							<p class="title">李春英</p>
							<p>服务计算、协同软件</p></li></a>
					<a href="#"><li class="jobLikeListItems clearfix"><img
							src="images/fjx.png" class="jobLikeimg" alt="" />
							<p class="title">方家轩</p>
							<p>信息服务、协同软件、移动互联网应用</p></li></a>
					<a href="#"><li class="jobLikeListItems clearfix"><img
							src="images/zwq.jpg" class="jobLikeimg" alt="" />
							<p class="title">曾伟铨</p>
							<p>大数据挖掘、网络与信息安全</p></li></a>
					<a href="#"><li class="jobLikeListItems clearfix"><img
							src="images/cc.jpg" class="jobLikeimg" alt="" />
							<p class="title">陈成</p>
							<p>商业智能、数据仓库</p></li></a>
					<a href="#"><li class="jobLikeListItems clearfix"><img
							src="images/jobLikeimg.png" class="jobLikeimg" alt="" />
							<p class="title">官全龙</p>
							<p>动安全、信息安全、网络安全、软件工程</p></li></a>
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


	<ul class="topBtnGroup">
		<li><a href="">热点领域</a></li>
		<li><a href="">名会领域</a></li>
		<li><i></i> <b></b> <a href="javascript:;" id="topBtn">返回顶部</a>
		</li>
	</ul>


	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/build/dist/echarts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/common.js"></script>
	<script src="js/plug.js"></script>

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

		})
	</script>


</body>

</html>
