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

    <title>projectInfo</title>
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

        br{
            /*margin-bottom:5px;*/
        }
    </style>
</head>
<body class="projectInfo clearfix">

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
                    <a href="projectlist.do" class="active">项目</a>
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
                    <a href="" id="toPublishProject">发布项目</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


<!-- Page Content -->

<!--<header class="banner">
    <h1>搜你所需</h1>
        <form action="">
            <div class="srcBox clearfix">
                <select name="" id="srcType" class="srcType form-control">
                    <option value="">领域</option>
                    <option value="">研究者</option>
                    <option value="">组织机构</option>
                    <option value="">4</option>
                </select>
                <input type="text" class="srcText form-control" id="srcText" placeholder="请输入领域关键字" />
                &lt;!&ndash;<input type="submit" value="" class="srcSub"/>&ndash;&gt;
                <button type="submit" class="srcSub"><i class="fa fa-search"></i>
                </button>
            </div>
        </form>
</header>-->

<div class="container">

    <!-- Marketing Icons Section -->
    <div class="clearfix">
        <div id="" class="leftCol">

            <!--<div class="projectInfoCon">-->
            <div class="projectInfoTitle">
                <img src="images/blurred1.jpg" alt="" class="blurred"/>

                <div class="companyWiew clearfix">
                    <img src="images/jobLikeimg.png" alt="" class="companyLogo"/>

                    <div class="companyUrl">
                        <h1>${details.title}</h1>

                        <!-- <p>iHealth</p>  -->
                        <!--<i class="fa fa-heart"></i>-->
                    </div>
                    <!--<button class="review"><i class="fa fa-plus"></i>&nbsp;&nbsp;Add a Review</button>-->
                </div>

            </div>

            <div class="progressBarWraper clearfix">
                <ul class="progressBarBgList">
                    <li class="progressBarBgItem now"></li>
                    <li class="progressBarBgItem"></li>
                    <li class="progressBarBgItem"></li>
                    <li class="progressBarBgItem"></li>
                </ul>
                <ul class="progressBarvList clearfix">
                <!-- 
                    <li class="progressBarListItem  fa fa-check"><span>匹配专家</span></li>
                    <li class="progressBarListItem  fa fa-check"><span>合作洽谈</span></li>
                -->
                    <li class="progressBarListItem now"><span>匹配专家</span></li>
                    <li class="progressBarListItem future"><span>合作洽谈</span></li>
                    <li class="progressBarListItem future"><span>项目研发</span></li>
                    <li class="progressBarListItem future"><span>项目验收</span></li>
                </ul>
            </div>

            <div class="projectInfoMain clearfix" id="projectInfoMain">
                <!-- 添加选项卡-->

				<div class="tabBtnGro clearfix">
                <div class="tabBtn">项目详情<i class="fa fa-info-circle"></i></div>
                <div class="tabBtn">数据集<i class="fa fa-database"></i></div>
	            </div>
	            <div class="tabPlane">
	            	<c:forEach items="${details.tagsNames}" var="tagsName" varStatus="nameStatus">
	                <h1>${tagsName}</h1>
	
	               
	                	<c:forEach items="${details.tagsinfos}" var="tagsinfo" varStatus="infoStatus">
	                		
	                		<c:if test="${nameStatus.index == infoStatus.index}">
	                			 <p>
	                				${tagsinfo}
	                			 </p>
	                		</c:if>
	                		
	                	</c:forEach>
	                </c:forEach>
	                <h1>附件</h1>
	                <ul class="dataList">
	                	<c:forEach items="${details.projectEnclosures}" var="enclosures">
	                		<li class="dataListItems"><i class="fa fa-file-archive-o"></i><a href="<%=basePath%>download.do?id=${enclosures.value}">${enclosures.key}</a></li>
	                	</c:forEach>
	                </ul>
	            </div>
	
	            <div class="tabPlane">
	                <h1>数据文件</h1>
	
	                <ul class="dataList">
	                	<c:forEach items="${details.projectDataSetFilenames}" var="filename" varStatus="filenameStatus">
	                		<c:forEach items="${details.projectDataSetFileIds}" var="fileId" varStatus="fileIdStatus">
	                			<c:if test="${filenameStatus.index == fileIdStatus.index}">
		                			<li class="dataListItems"><i class="fa fa-file-archive-o"></i><a href="<%=basePath%>download.do?id=${fileId}">${filename}</a></li> 
	                			</c:if>
	                		</c:forEach>
	                	</c:forEach>                      
	                </ul>
	
	                <h1>文件描述</h1>
	                
	                <c:forEach items="${details.projectDataSetFilenames}" var="filename" varStatus="filenameStatus">
	                		<c:forEach items="${details.projectDataSetFileIds}" var="fileId" varStatus="fileIdStatus">
	                			<c:if test="${filenameStatus.index == fileIdStatus.index}">
	                				<h2><i class="fa fa-file-archive-o"></i><a href="<%=basePath%>download.do?id=${fileId}">${filename}</a></h2>              				
	                			</c:if>
	                		</c:forEach>
	                		<c:forEach items="${details.upLoadDataSetFileDis}" var="fileDis" varStatus="fileDisStatus">
	                			<c:if test="${filenameStatus.index == fileDisStatus.index}">
	                				<p>
	                					${fileDis}
	                				</p>
	                			</c:if>
	                		</c:forEach>
	                				
	                </c:forEach>   
	
	
	                <h1>数据字段描述</h1>
	
					<c:forEach items="${details.projectDataSetFilenames}" var="filename" varStatus="filenameStatus">
	                		<c:forEach items="${details.projectDataSetFileIds}" var="fileId" varStatus="fileIdStatus">
	                			<c:if test="${filenameStatus.index == fileIdStatus.index}">
	                				<h2><i class="fa fa-file-archive-o"></i><a href="<%=basePath%>download.do?id=${fileId}">${filename}</a></h2>              				
	                			</c:if>
	                		</c:forEach>
	                		<c:forEach items="${details.upLoadDataSetFieldDis}" var="fieldDis" varStatus="fieldDisStatus">
	                			<c:if test="${filenameStatus.index == fieldDisStatus.index}">
	                				<p>
	                					${fieldDis}
	                				</p>
	                			</c:if>
	                		</c:forEach>
	                				
	                </c:forEach>
	            </div>
                
            </div>
            <!--</div>-->

        </div>
        <div class="siderDis">

            <div class="competitiveBidding clearfix">
                <ul class="comList">
                    <h1>基本信息</h1>
                    <li class="comListItems"><span>发布时间：</span>${details.releaseDate}</li>
                    <li class="comListItems"><span>开发周期：</span>${details.developmentCycle}</li>
                    <li class="comListItems"><span>竞标人数：</span>${details.auctionNumber}</li>
                    <li class="comListItems"><span>项目现处于：</span>${details.stage}</li>
                    <li class="comListItems"><span>项目预算：</span>约${details.budget}元</li>
                    <li class="comListItems"><span>项目分类：</span>${details.projectType}</li>
                </ul>
                <button class="btn btn-primary" type="button">申请项目</button>
                <!--<a  target="_self" href="publishingProjectStep03.html" type="button">下一步 ></a>-->
            </div>

            <div class="getEmail">
                <form action="" class="clearfix">
                    <h1>有类似项目时提醒我</h1>
                    <button class="btn btn-primary" type="submit">订制</button>
                    <input type="text" class="form-control" placeholder="输入接收提醒的邮箱"/>
                    <!--<a  target="_self" href="publishingProjectStep03.html" type="button">下一步 ></a>-->
                </form>
            </div>


            <div class="Recommend">
                <h1>你可能感兴趣的领域/学者</h1>
                <ul class="jobLikeList">

                    <li class="jobLikeListItems clearfix">
                        <img src="images/lcy.jpg" class="jobLikeimg" alt=""/>

                        <p class="title"><a href="#">李春英</a></p>

                        <p>服务计算、协同软件</p>
                    </li>


                    <li class="jobLikeListItems clearfix">
                        <img src="images/fjx.png" class="jobLikeimg" alt=""/>

                        <p class="title"><a href="#">方家轩</a></p>

                        <p>信息服务、协同软件、移动互联网应用</p>
                    </li>


                    <li class="jobLikeListItems clearfix">
                        <img src="images/zwq.jpg" class="jobLikeimg" alt=""/>

                        <p class="title"><a href="#">曾伟铨</a></p>

                        <p>大数据挖掘、网络与信息安全</p>
                    </li>


                    <li class="jobLikeListItems clearfix">
                        <img src="images/cc.jpg" class="jobLikeimg" alt=""/>

                        <p class="title"><a href="#">陈成</a></p>

                        <p>商业智能、数据仓库</p>
                    </li>


                    <li class="jobLikeListItems clearfix">
                        <img src="images/jobLikeimg.png" class="jobLikeimg" alt=""/>

                        <p class="title"><a href="#">官全龙</a></p>

                        <p>动安全、信息安全、网络安全、软件工程</p>
                    </li>

                </ul>
            </div>


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
        <a href="javascript:;" id="topBtn" >返回顶部</a>
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
//
//        $('#topBtn').toTop();
//
//
//        //应用手风琴插件
//        $('#acc').accordion();
//
//        //应用tab插件
//        $('.tab').tabs();


        $("a").get().hideFocus = "true";


//        //banner搜索框开始
//        $('#srcType').change(function () {
//            var srcTextPlaArr = ["请输入领域关键字","请输入研究者姓名","请输入组织机构名",'4'];
//            $('#srcText').attr({'placeholder':srcTextPlaArr[$(this).children('option:selected').index()]})
//        });
//        //banner搜索框结束
//
        //应用动态search插件
        $('#searchGroupWraper').dySearchBox({
            closeWidth: "150",
            openWdith: "272"
        })


        //应用tab插件
        $('#projectInfoMain').projectInfoTabs();


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
