// JavaScript Document
$(function () {

    //动态弹出框开始

    $('body').append('<div id="signCon">\
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
    <form action="registerStep01.html" class="signUpForm" id="signUpForm">\
            <input type="text" class="form-control" name="signUpDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="text" class="form-control" name="signUpDialogPassInput" placeholder="密码(6-16位)"/>\
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
    <form action="registerStep01.html" class="signUpForm" id="signInForm">\
            <input type="text" class="form-control" name="signInDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="text" class="form-control" name="signInDialogPassInput" placeholder="密码"/>\
            <input type="submit" name="signInSubmit" value="登录"/>\
    </form>\
            </div>\
            </div>\
            </div>\
            </div>\
            <div id="signMask"></div>\
            ');

    //应用signContabs插件
    $('#signConTab').signContabs();


    function signMask() {
        $('#signMask').width($(document).width()).height($(document).height());

    }

    signMask();
    $(window).resize(function () {
        signMask();
    });

    //点击注册按钮
    $('#signBtn').click(function () {
        $('#signCon').show().removeClass("bounceOutDown").addClass('bounceInDown');
        $('#signMask').fadeIn("slow");
        $('body').css({"overflow": "hidden"});
        return false;
    });
    //点击关闭按钮
    $('.signConColseBtn').click(function () {
        $('#signMask').fadeOut(3000);
        //window.setTimeout(function(){
        //    $('#signCon').hide();
        //},1500)

        $('#signCon').removeClass("bounceInDown").addClass('bounceOutDown');
        $('body').css({"overflow": "auto"})
    });


    //动态弹出框结束


    //弹出框表单提示验证开始-----------------------------------------


    //登录开始
    $("#signInForm").validate({

        //debug模式
        debug:true,
        onkeyup: false,
        onfocusout: false,


        //验证成功了
        //success:function(lable){
        //
        //},

        "rules": {
            "signInDialogNumInput": {
                "required": true,
                //用户名单独执行ajax验证
                //"remote": {
                //    url: "check-email.php",     //后台处理程序
                //    type: "post",               //数据发送方式
                //    dataType: "json",           //接受数据格式
                //    data: {                     //要传递的数据
                //
                //    }
                //},
                //dataFilter: function (data) {　　　　//判断控制器返回的内容
                //    if (data == "true") {
                //        return true;
                //    }
                //    else {
                //        //alert('ajax失败');
                //
                //        return false;
                //    }
                //}
            },
            "signInDialogPassInput": {
                "required": true,
            },
        },//必须加逗号


        "messages": {
            "signInDialogNumInput": {
                "required": '请输入登录账号',
                "remote":"账号或密码错误"
            },
            "signInDialogPassInput": {
                "required": '请输入登录密码',
            },


        },
    });
    //登录结束

    //注册开始
    $("#signUpForm").validate({

        //debug模式
        debug:true,
        onkeyup: false,
        onfocusout: false,


        //验证成功了
        //success:function(lable){
        //
        //},

        "rules": {
            "signUpDialogNumInput": {
                "required": true,
                //用户名单独执行ajax验证
                //"remote": {
                //    url: "check-email.php",     //后台处理程序
                //    type: "post",               //数据发送方式
                //    dataType: "json",           //接受数据格式
                //    data: {                     //要传递的数据
                //
                //    }
                //},
                //dataFilter: function (data) {　　　　//判断控制器返回的内容
                //    if (data == "true") {
                //        return true;
                //    }
                //    else {
                //        //alert('ajax失败');
                //
                //        return false;
                //    }
                //}
            },
            "signUpDialogPassInput": {
                "required": true,
            },
        },//必须加逗号


        "messages": {
            "signUpDialogNumInput": {
                "required": '请输入登录账号',
                "remote":"账号或密码错误"
            },
            "signUpDialogPassInput": {
                "required": '请输入登录密码',
            },


        },
    });
    //注册结束




    //表单提示添加箭头开始
    window.setInterval(function () {
        $('label[class="error"]').each(function (index,element) {
            if($(element).find('span').length == 0){
                $(element).append("<span></span>");
            }
        })
    },10);
    //表单提示添加箭头结束


    //点击隐藏错误提示
    $(document).click(function () {
        $('label[class="error"]').hide();
    });


    //弹出框表单提示验证结束---------------------------------


});
