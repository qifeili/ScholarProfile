//各个页面需注销用户登录时所用的工具类
$(function () {
	$("#toLogout").click(function(event) {
		$.ajax({
			url: 'logoutAjax.do',
			type: 'GET',
			dataType: 'text',
			success: function(data) {
					if(data == 'true') {
//						alert("注销成功");
//						$('#logined').hide();
//        				$('#logouted').show();
        				addLoginBtn();
					} else if (data == 'false') {
						//alert('注销失败');
//        				$('#logined').show();
//        				$('#logouted').hide();
					}
 				},
			error:function(err) {     
	                //alert(err + "失败了");     
	            } 
		});
		return false;
	});
});

$('#bs-example-navbar-collapse-1').delegate('#toLogout', 'click', function(event) {
	$.ajax({
		url: 'logoutAjax.do',
		type: 'GET',
		dataType: 'text',
		success: function(data) {
				if(data == 'true') {
//					alert("注销成功");
//					$('#logined').hide();
//    				$('#logouted').show();
    				addLoginBtn();
				} else if (data == 'false') {
					//alert('注销失败');
//    				$('#logined').show();
//    				$('#logouted').hide();
				}
				},
		error:function(err) {     
                //alert(err + "失败了");     
            } 
	});
	return false;
});

//各个页面点击“发布项目”，需验证用户是否登录、session是否过期时所用的工具类
function islogin() {
	var flag = true;
	$.ajax({
		async : false,
		url : 'isloginAjax.do',
		type : 'GET',
		dataType : 'text',
		success : function(data) {
			if (data == 'true') {
				//用户已登录，session未过期
				flag = true;
			} else if (data == 'false') {
				//用户未登录，session已过期
				flag = false;
			}
		},
		error : function(err) {
			alert(err + "失败了");
		}
	});
	return flag;
}

//发布项目按钮触发登录校验
$('#toPublishProject').click(function(event) {  
	/*
	loginflag = islogin();
    if(!loginflag) { //用户未登录、session已失效
    	$('#signBtn').click();    
    }
    */
    window.location.href = "publishingProjectStep01.jsp";
    return false;//必须加上这句阻止掉浏览器的默认动作
});

//在页面banner中添加“登录”按钮,用户未登录时，调用该方法
function addLoginBtn() {
	$('#logined').remove();
	var loginBtnHtml = '<li class="floatLelt" id="logouted"><a href="" id="signBtn">登录</a></li>';
	$(loginBtnHtml).insertAfter($('li.searchGroupWraper'));
	
}

//在页面banner中添加“头像”图标，用户登陆后，调用该方法
function addLoginLogo() {
	$('#logouted').remove();
	var loginLogoHtml = 
		'<li class="floatLelt Account" id="logined">\
		 	<a href="javascript:void();" id=""><i class="fa fa-user"></i></a>\
				<ul class="AccountMenuList">\
					<li class="AccountMenuListItem"> <a href="userIndexReviews.do">我的关注</a></li>\
					<li class="AccountMenuListItem"><a href="userIndexProject.do">我的项目</a></li>\
					<li class="AccountMenuListItem"><a href="userIndexMessage.do">我的消息</a></li>\
					<li class="AccountMenuListItem"><a href="userIndexAccount.do">账号管理</a></li>\
					<li class="AccountMenuListItem"><a href="" id="toLogout">退出登陆</a></li>\
				</ul>\
		</li>';
	$(loginLogoHtml).insertAfter($('li.searchGroupWraper'));
}