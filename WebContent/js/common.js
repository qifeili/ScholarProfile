// JavaScript Document
// JavaScript Document

var reSendCodeTimer;
$(function() {
    
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
            <a href="WeixinAuthorize.do" class="weixin"></a>\
            <a href="QQAuthorize.do" class="qq"></a>\
            <a href="SinaWeiboAuthorize.do" class="weibo"></a>\
            </div>\
            <div class="or"><span>or</span></div>\
    <form action="registerStep01.jsp" class="signUpForm" id="signUpForm" method = "post">\
            <input type="text" class="form-control" name="signUpDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signUpDialogPassInput" placeholder="密码(6-16位)"/>\
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
    <form action="" class="signUpForm" id="signInForm" method = "post">\
            <input type="text" class="form-control" name="signInDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signInDialogPassInput" placeholder="密码"/>\
    		<input type="hidden" class="form-control" name="signInDialogProjectId"/>\
            <input type="submit" name="signInSubmit" value="登录"/>\
    </form>\
            <div class="findPass"><a href = "#" class="findPassBtn">忘记密码</a></div>\
            </div>\
            </div>\
            </div>\
            </div>\
            <div id="signMask"></div>\
            ');
    
    //应用signContabs插件
    $('#signConTab').signContabs();
    
    function signMask() {
        $('#signMask').width($(document).width()).height($(document).height()).css({
            "position": "fixed"
        });
    }
    
    signMask();
    $(window).resize(function() {
        signMask();
    });
    
    //点击注册按钮
    $('#signBtn').click(function(e) {
        
        $('#findPass').remove();
        $('#resetPass').remove();
        
        if ($('#signConTab').length < 1) {
            $('#signCon').append('<div id=signConTab>\
            <div class="tabBtnGro clearfix">\
            <div class="tabBtn">注册</div>\
    <div class="tabBtn">登录</div>\
    </div>\
    <div class="tabPlane">\
            <div class="signInDialog">\
            <h1>注册以获取个性化服务</h1>\
            <div class="trilateralLogInBtnGro">\
            <a href="WeixinAuthorize.do" class="weixin"></a>\
            <a href="QQAuthorize.do" class="qq"></a>\
            <a href="SinaWeiboAuthorize.do" class="weibo"></a>\
            </div>\
            <div class="or"><span>or</span></div>\
    <form action="registerStep01.jsp" class="signUpForm" id="signUpForm" method = "post">\
            <input type="text" class="form-control" name="signUpDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signUpDialogPassInput" placeholder="密码(6-16位)"/>\
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
    <form action="registerStep01.jsp" class="signUpForm" id="signInForm" method = "post">\
            <input type="text" class="form-control" name="signInDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signInDialogPassInput" placeholder="密码"/>\
            <input type="hidden" class="form-control" name="signInDialogProjectId"/>\
            <input type="submit" name="signInSubmit" value="登录"/>\
    </form><div class="findPass"><a href = "#" class="findPassBtn">忘记密码</a></div>\
            </div>\
            </div>\
            </div>\
            ');
        
        
        };
        
        //应用signContabs插件
        $('#signConTab').signContabs();
        
        
        $('#signCon').show().removeClass("bounceOutDown").addClass('bounceInDown');
        $('#signMask').fadeIn("slow");
        $('body').css({
            "overflow": "hidden"
        });
        signInFormValidate();
        return false;
    });
    
    $('#bs-example-navbar-collapse-1').delegate('#logouted','click',function(e) {
        $('#findPass').remove();
        $('#resetPass').remove();
        if ($('#signConTab').length < 1) {
            $('#signCon').append('<div id=signConTab>\
            <div class="tabBtnGro clearfix">\
            <div class="tabBtn">注册</div>\
    <div class="tabBtn">登录</div>\
    </div>\
    <div class="tabPlane">\
            <div class="signInDialog">\
            <h1>注册以获取个性化服务</h1>\
            <div class="trilateralLogInBtnGro">\
            <a href="WeixinAuthorize.do" class="weixin"></a>\
            <a href="QQAuthorize.do" class="qq"></a>\
            <a href="SinaWeiboAuthorize.do" class="weibo"></a>\
            </div>\
            <div class="or"><span>or</span></div>\
    <form action="registerStep01.jsp" class="signUpForm" id="signUpForm" method = "post">\
            <input type="text" class="form-control" name="signUpDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signUpDialogPassInput" placeholder="密码(6-16位)"/>\
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
    <form action="registerStep01.jsp" class="signUpForm" id="signInForm" method = "post">\
            <input type="text" class="form-control" name="signInDialogNumInput" placeholder="邮箱/手机号"/>\
            <input type="password" class="form-control" name="signInDialogPassInput" placeholder="密码"/>\
            <input type="hidden" class="form-control" name="signInDialogProjectId"/>\
            <input type="submit" name="signInSubmit" value="登录"/>\
    </form><div class="findPass"><a href = "#" class="findPassBtn">忘记密码</a></div>\
            </div>\
            </div>\
            </div>\
            ');
        };
        //应用signContabs插件
        $('#signConTab').signContabs();
        $('#signCon').show().removeClass("bounceOutDown").addClass('bounceInDown');
        $('#signMask').fadeIn("slow");
        $('body').css({
            "overflow": "hidden"
        });
        signInFormValidate();
        return false;
    });

    //定义重新发送验证码全局定时器
    //var reSendCodeTimer;

    //点击关闭按钮
    $('.signConColseBtn').click(function() {
        //关闭重新发送验证码全局定时器

        $('.resetCodeBtn').attr('disabled',false).text('重发验证码');
        window.clearInterval(reSendCodeTimer);
        $('#signMask').fadeOut(3000);
        //window.setTimeout(function(){
        //    $('#signCon').hide();
        //},1500)

        $('#signCon').removeClass("bounceInDown").addClass('bounceOutDown');
        $('body').css({
            "overflow": "auto"
        });
    });




    //调到找回密码框
    $('#signCon').delegate('.findPassBtn', 'click', function() {
        $('#signConTab').remove();
        $('#signCon').append('<div id=findPass>\
                <div class="tabBtnGro clearfix">\
                <div class="tabBtn">找回密码</div>\
                </div>\
                <div class="tabPlane">\
                <div class="signInDialog">\
                <h1>验证码将会发送到您的注册邮箱或手机</h1>\
                <form action="" class="signUpForm" method = "post">\
                <input type="text" class="form-control" name="FindPassDialogNumInput" placeholder="邮箱/手机号"/>\
                <label class="errorTip" style="display:none;"><span class="arrow"></span>请选择领域</label>\
                <button type="button" class="findPassSubmit">获取验证码</button>\
                </form>\
                </div>\
                </div>\
                </div>');
        
        return false;
    });

    //调到重置密码框-------------
    $('#signCon').delegate('.findPassSubmit', 'click', function() {
        
        //表单验证开始------------------------------------------------
        
        var checkMobile = /^1[358][0123456789]\d{8}$/;
        var checkEMail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var Input = $('input[name = "FindPassDialogNumInput"]');
        var InputVal = Input.val();
        
        if (!InputVal) {
            
            Input.next('.errorTip').show().html('<span class="arrow"></span>请输入账号');
        
        } else if (!((checkMobile.test(InputVal)) || (checkEMail.test(InputVal)))) {
            
            Input.next('.errorTip').show().html('<span class="arrow"></span>格式错误');
        
        } else {
            //
            $.ajax({
                type: 'GET',
                url: "getMailboxVerificationCode.do",//getMailboxVerificationCode.do
                data: {
                    targetMailbox: $('input[ name= "FindPassDialogNumInput"]').val()
                },

                //改成success
                success: function(response, status, xhr) {
                    if(response){
                        //格式表单验证成功跳转到重置密码页
                        var FindPassDialogNumInput = $('input[ name= "FindPassDialogNumInput"]').val();
                        $('#findPass').remove();
                        $('#signCon').append('<div id="resetPass">\
                            <div class="tabBtnGro clearfix">\
                            <div class="tabBtn">重设密码</div>\
                            </div>\
                            <div class="tabPlane">\
                            <div class="signInDialog">\
                            <h1>验证码将会发送到您的注册邮箱或手机</h1>\
                            <form action="" class="signUpForm" method = "post">\
                            <input type="text" class="form-control" readonly = "true" name="restPassDialogNumInput" placeholder="邮箱/手机号"/>\
                            <input type="password" class="form-control" name="restPassDialogNewNumInput" placeholder="新密码"/>\
                            <label class="errorTip" style="display:none;"><span class="arrow"></span>请选择领域</label>\
                            <i class="fa fa-eye" id="showPass"></i>\
                            <div class="resetCode">\
                            <input type="text" class="form-control" name = "restPassDialogCodeInput" placeholder="邮箱收到的6位验证码"/>\
                            <label class="errorTip" style="display:none;"><span class="arrow"></span>请选择领域</label>\
                            <button class="resetCodeBtn">重发验证码</button>\
                            </div>\
                            <button class="resetPassBtn">重置密码</button>\
                            </form>\
                            </div>\
                            </div>\
                            </div>');

                        $('input[ name= "restPassDialogNumInput"]').val(FindPassDialogNumInput);


                        //查看新密码-------------------
                        $('#signCon').delegate('#showPass', 'click', function() {
                            $(this).toggleClass('show');
                            if ($(this).hasClass('show')) {
                                $('input[ name= "restPassDialogNewNumInput"]').attr('type', "text");
                            } else {

                                $('input[ name= "restPassDialogNewNumInput"]').attr('type', "password");
                            }
                        });

                        //重新发送验证码-----------------
                        $('#signCon').delegate('.resetCodeBtn', 'click', function() {


                            //ajax发送验证码
                            $.ajax({
                                type: 'GET',
                                url: "getMailboxVerificationCode.do",
                                data: {
                                    targetMailbox: $('input[ name= "restPassDialogNumInput"]').val()
                                },
                                //error: function(response, status, xhr) {
                                //
                                //},
                                //success:function(response, status, xhr){
                                //
                                //}

                            });

                            //按钮倒计时
                            $('.resetCodeBtn').text('25秒后重发');
                            var count = 25;
                            reSendCodeTimer = window.setInterval(function(){
                                --count;
                                $('.resetCodeBtn').attr('disabled',true).text(count+'秒后重发');
                                if(count == 0){
                                    window.clearInterval(reSendCodeTimer);
                                    $('.resetCodeBtn').attr('disabled',false).text('重发验证码');
                                }
                            },1000);
                            return false;
                        });
                    }else {
                        Input.next('.errorTip').show().html('<span class="arrow"></span>未注册');
                    }


                },
                error:function(){

                }
            
            
            
            });
            
            
        
        }
        
        
        //表单验证开始------------------------------------------------
        
        return false;
    });
    
    
    //提交重置密码框=---------------
    $('#signCon').delegate('.resetPassBtn', 'click', function() {
        
        //表单验证开始---------------------------------
        
        var checkMobile = /^1[358][0123456789]\d{8}$/;
        var checkEMail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        
        
        var $restPassDialogNewNumInput = $('input[name="restPassDialogNewNumInput"]');
        var restPassDialogNewNumVal = $restPassDialogNewNumInput.val();
        
        var $restPassDialogCodeInput = $('input[name = "restPassDialogCodeInput"]');
        var restPassDialogCodeInput = $restPassDialogCodeInput.val();
        
        //验证新密码-------------------
        if ((restPassDialogNewNumVal.length < 6) || (restPassDialogNewNumVal.length > 128)) {
            
            $restPassDialogNewNumInput.next('.errorTip').show().html('<span class="arrow"></span>请输入 6-128 位的密码');
            return false;
        }else if(restPassDialogCodeInput == ""){
            $restPassDialogCodeInput.next('.errorTip').show().html('<span class="arrow"></span>请输入验证码');
             return false;
        }else{
            //$('.signConColseBtn').click();

                        //ajax验证验证码是否一致。
                        $.ajax({
                            type: 'GET',
                            url: "compareMailboxVerificationCode.do",
                            data: {
                                mailbox: $('input[ name= "restPassDialogNumInput"]').val(),
                                newPassword:restPassDialogNewNumVal,
                                verificationCode: $('input[ name= "restPassDialogCodeInput"]').val(),

                            },
                            
                            success:function(response, status, xhr){

                                if(response==true){
                                    $('.signConColseBtn').click();
                                    window.clearInterval(reSendCodeTimer);
                                }else {
                                    $restPassDialogCodeInput.next('.errorTip').show().html('<span class="arrow"></span>验证码错误');
                                    window.clearInterval(reSendCodeTimer);
                                }

                            },
                            error: function(response, status, xhr) {
                            }

                        });
            


            return false;
        }
        
        //验证验证码-------------------
        //
        //
        //
        //

    });


    
    
    
    
    
    
    
    //动态弹出框结束
    
    
    //弹出框表单提示验证开始-----------------------------------------
    
    //自定义验证方法
    $.validator.addMethod('Mobile||EMail', function(value, element, param) {
        var checkMobile = /^1[358][0123456789]\d{8}$/;
        var checkEMail = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        return this.optional(element) || (checkMobile.test(value)) || (checkEMail.test(value));
    }, "请输入正确的手机号或邮箱");
    
    //登录函数开始-----------
    function signInFormValidate(){
        $("#signInForm").validate({

            //debug模式
            //debug:true,
            onkeyup: false,
            onfocusout: false,

            //验证成功，祖师默认提交
            submitHandler: function(form) {
                $('.signConColseBtn').click();
                //$('#logouted').hide();
                //$('#logined').show();
                addLoginLogo();
                $('#signUpFrame').hide();
                $('#interestFrame').show();
            },


            //验证成功了
            //success:function(lable){
            //
            //},

            "rules": {
                "signInDialogNumInput": {
                    "required": true,
                },
                "signInDialogPassInput": {
                    "required": true,
                    //用户名单独执行ajax验证
                    "remote": {
                        url: "loginAjax.do",
                        //后台处理程序
                        //type: "post",               //数据发送方式
                        dataType: "json",
                        //接受数据格式
                        data: {
                            //要传递的数据
                            signInDialogNumInput: function() {
                                return $('input[ name= "signInDialogNumInput"]').val();
                            },
                            signInDialogPassInput: function() {
                                return $('input[ name= "signInDialogPassInput"]').val();
                            },
                            projectId: function() {
                                return $('input[ name= "signInDialogProjectId"]').val();
                            },
                        }
                    },
                    dataFilter: function(data) {
                        //判断控制器返回的内容
                        if (data == "true") {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                },
            },
            //必须加逗号


            "messages": {
                "signInDialogNumInput": {
                    "required": '请输入登录账号',
                },
                "signInDialogPassInput": {
                    "required": '请输入登录密码',
                    "remote": "账号或密码错误"
                },


            },
        });
    }
    signInFormValidate();
    //登录函数结束-----------
    
    //注册函数开始-----------
    
    function signUpFormValidate(){
        $("#signUpForm").validate({

            //debug模式
            //debug:true,
            onkeyup: false,
            onfocusout: false,


            //验证成功了
            //success:function(lable){
            //
            //},

            "rules": {
                "signUpDialogNumInput": {
                    "required": true,
                    "Mobile||EMail": true,
                    //用户名单独执行ajax验证
                    "remote": {
                        url: "registerAjax.do",
                        //后台处理程序
                        type: "post",                 //数据发送方式
                        //dataType: "json",           //接受数据格式
                        data: {
                            //要传递的数据
                            signUpDialogNumInput: function() {
                                return $('input[ name= "signUpDialogNumInput"]').val();
                            },
                            signUpDialogPassInput: function() {
                                return $('input[ name= "signUpDialogPassInput"]').val();
                            }
                        }
                    },
                    dataFilter: function(data) {
                        //判断控制器返回的内容
                        if (data == "true") {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                },
                "signUpDialogPassInput": {
                    "required": true,
                    "rangelength": [6, 12],
                },
            },
            //必须加逗号


            "messages": {
                "signUpDialogNumInput": {
                    "required": '请输入账号',
                    "remote": "已经注册"
                },
                "signUpDialogPassInput": {
                    "required": '请输入密码',
                    'rangelength': '6-16位密码',
                },


            },
        });
    }
    signUpFormValidate()
   
    
    
    //注册函数结束-----------




    //表单提示添加箭头开始
    window.setInterval(function() {
        $('label[class="error"]').each(function(index, element) {
            if ($(element).find('span').length == 0) {
                $(element).append("<span></span>");
            }
        });
        //阻止气泡
        if($('label[for="signInDialogNumInput"]').html()== "<span></span>"){
            $('label[for="signInDialogNumInput"]').hide();
        }
    }, 1);
    //表单提示添加箭头结束


    //点击隐藏错误提示
    $(document).click(function() {
        $('label[class="error"]').hide();
        $('label[class="errorTip"]').hide();
        //阻止气泡
        window.setInterval(function() {
            if($('label[for="signInDialogNumInput"]').html()== "<span></span>"){
                $('label[for="signInDialogNumInput"]').hide();
            }
        }, 1);
    });


    //弹出框表单提示验证结束---------------------------------
});
