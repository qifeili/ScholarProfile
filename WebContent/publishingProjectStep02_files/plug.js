// JavaScript Document
(function () {

    //创建返回顶端插件
    $.fn.toTop = function () {
        var $that =$(this).parents('.topBtnGroup');
        $that.hide();
        $(document).scroll(function(){
            if($(window).scrollTop()>200){
                $that.show();
            }else{
                $that.hide();
            }

        });
        $(this).click(function () {
            $('html,body').animate({scrollTop: 0}, 700);
        });

    }


    //手风琴效果插件
    $.fn.accordion = function () {
        $(this).find("i").click(function () {
            //if($(this).next(".plane").css("display") == 'none'){
            //$(".plane").slideUp();
            $(this).css({
                "transform": "rotate(180deg)",
            });
            //}
            $(this).parent(".btn").next(".plane").slideToggle("fast", function () {
                if ($(this).css('display') == "none") {
                    $(this).parent().find('i').css({
                        "transform": "rotate(0deg)",
                    });
                }
            });
        });
    };


    //创建tab插件
    $.fn.tabs = function () {

        $(this).each(function () {
            $(this).find('.tabPlane').css({"display": "none"})
            $(this).find('.tabPlane').eq(0).css({"display": "block"});
            $(this).find(".tabBtn").click(function () {

                $(this).parent().find(".tabBtn").css({"background": "#f7f7f7", "border-left": "5px solid #f7f7f7"})
                $(this).css({"background": "#FFF", "border-left": "5px solid #2c84cc"});

                $(this).parent('.tabBtnGro').parent().find('.tabPlane').css({"display": "none"});
                $(this).parent('.tabBtnGro').parent().find('.tabPlane').eq($(this).index()).css({"display": "block"})
            })
        })

    }


    //创建动态sreach插件
    $.fn.dySearchBox = function (obj) {
        //初始单个大小
        $('.searchInput01').css("width", obj.closeWidth);
        var startInputWidth = $('.searchInput01').css("width");
        //展开单个大小
        $('.searchGroup').css("width", obj.openWdith);
        var startWidth = $('.searchGroup').css("width");


        $('.searchGroupWraper').css({'width': parseInt($(".searchGroup").css("width")) * 2});

        //展开单个大小
//        var endInputWidth = $('input:first-child').css("width");


        $(".searchInput01").click(function () {

            $('.navbar-nav .floatLelt').fadeOut();

            $('.searchGroupWraper').css({"z-index": "10"})

            //当searchGroup的宽度为初始大小时，才会执行
            if ($('.searchInput01').css("width") == startInputWidth) {


                $(this).css({"backgroundImage": "none", "border-radius":"0"}).stop().animate({"paddingLeft": "5px"}, 500, function () {
                    $(this).attr({
                        "placeholder": "搜索项目关键词",
                    })
                });

                //input02显示
                $('.searchInput02').show();

                //表单大小变为之前的一半,改变颜色
                $('.searchInput').css({"width": "25%", "background": "#fff"});

                //当searchGroup的宽度变为之前的2倍
                $(".searchGroup").animate({
                    "width": $(".searchGroup").width() * 2,
                }, 500, function () {

                })
                window.setTimeout(function () {
                    //显示提交按钮
                    $('.searchGroupSubmit').fadeIn();
                }, 400);

                //显示关闭按钮
                $('.searchGroupClose').fadeIn();

            }


        })


/*        $('.searchInput02').focus(function () {
            //显示下拉菜单
            $('.searchGroupMenu').show();
            $('.searchGroupMenu li').click(function () {
                //alert()
                $('.searchInput02').attr({'placeholder':$(this).text()});

            })
        }).blur(function () {
            //隐藏下拉菜单
            window.setTimeout(function () {
                $('.searchGroupMenu').hide();
            },100)

        });*/


        $('.searchInput02Wraper').hover(
            function(){
                if($('.searchInput02').val() == '领域专家'){
                    //alert();
                    $('.searchGroupMenu li').text('项目需求');
                }else{
                    $('.searchGroupMenu li').text('领域专家');
                }

                $('.searchGroupMenu').show();
                $('.searchGroupMenu li').click(function () {
                    $('.searchInput01').attr({'placeholder':'搜索'+ ($(this).text().substring(0,2))+'关键词'});
                    $('.searchInput02').val($(this).text());
                    $('.searchGroupMenu').hide();
                })

        },
            function () {
                $('.searchGroupMenu').hide();
            }
        );

        //防止聚焦
        $('.searchInput02').focus(function () {
                //alert()
                $(this).blur();
            });



        $('.searchGroupClose').click(function () {

            $('.navbar-nav .floatLelt').fadeIn();

            if (startWidth == $('.searchInput01').css("width")) {


                $('.searchGroupWraper').css({"z-index": "0"})

                //searchGroup回复初始大小
                $(".searchGroup").animate({
                    "width": $(".searchGroup").width() / 2,
                }, 500)

                //表单回复初始大小
                $('.searchInput').css({"width": "50%"});
                $('.searchInput01').animate({
                    "width": startInputWidth,
                    "paddingLeft": "28px"
                }, 500, function () {
                    $(this).css({"background": "#dcdcdc url('images/icon-submit.png') no-repeat scroll 5px center", "border-radius":"3px"})
                }).attr({
                    "placeholder": "搜索...",
                });

                //隐藏关闭按钮
                $(this).fadeOut();
                //隐藏提交按钮
                $('.searchGroupSubmit').hide();
                //隐藏下拉菜单
                $('.searchGroupMenu').hide();

                //隐藏input02
                $('.searchInput02').hide();
            }


        })
    }



    //创建带下拉选项的自动完成搜索框插件
    $.fn.autoCompleteSreachBox = function () {
        var dataArr = ['大数据01', '大数据02', '大数据03', '大数据04', '大数据05', '大数据06', '大数据07', '大数据08', '大数据09', '大数据10'];

        //执行初始化显示下拉选项函数
        (function startItem() {
            $('#autoComplete-list').text("");
            for (var i = 0; i < dataArr.length; i++) {
                if($('.autoComplete-list li').length<5){
                    $('<li>' + dataArr[i] + '</li>').appendTo("#autoComplete-list");
                    $('.autoComplete-list li').eq(0).addClass("active")
                }
            }
        })();

        //重新筛选下拉选项


        //点击下拉按钮显示下拉选项
        $('#autoComplete-downBtn').get(0).addEventListener('click', function () {
            if ($('#autoComplete-input').val() == "") {
                $('#autoComplete-list').show();
            } else {
                $('#autoComplete-list').show().text("");

                var str = $('#autoComplete-input').val();
                //indexOf("input输入内容")
                for (var i = 0; i < dataArr.length; i++) {
                    if (dataArr[i].indexOf(str) >= 0) {
                        if($('.autoComplete-list li').length<5) {
                            $('<li>' + dataArr[i] + '</li>').appendTo("#autoComplete-list");
                            $('.autoComplete-list li').eq(0).addClass("active");
                        }
                    }
                }
            }
        }, true);

        //点击下拉按钮隐藏下拉选项
        $(document).get(0).addEventListener('click', function () {
            $('#autoComplete-list').hide();
        }, true)



        //输入框keyup
        $('#autoComplete-input').keyup(function (e) {
            //如果不是按得向下按钮和回车就执行动态加载
            if (e.keyCode != 40 && e.keyCode != 13) {
                $('#autoComplete-list').show().text("");
                var str = $('#autoComplete-input').val();
                //indexOf("input输入内容")
                for (var i = 0; i < dataArr.length; i++) {
                    if (dataArr[i].indexOf(str) >= 0) {

                        if($('.autoComplete-list li').length<5) {
                            $('<li>' + dataArr[i] + '</li>').appendTo("#autoComplete-list");
                            if (e.keyCode != 13) {
                                $('.autoComplete-list li').eq(0).addClass("active");
                            } else {
                                $('#autoComplete-list').hide();
                            }
                        }

                    }
                }
            }
        });



        //选择下拉选项和确定下拉选项
        $(document).keyup(function (e) {
            //如果按下回车
            if (e.keyCode == 13) {
                $('#autoComplete-input').val($('.autoComplete-list li.active').text());
                $('#autoComplete-list').hide();
            }
            //如果按下向下箭头
            if (e.keyCode == 40) {
                if ($('.autoComplete-list li.active').index() + 1 == $('.autoComplete-list li').length) {
                    $('.autoComplete-list li.active').removeClass("active");
                    $('.autoComplete-list li').eq(0).addClass("active");
                    //alert(0);
                } else {
                    $('.autoComplete-list li.active').removeClass("active").next('li').addClass("active");
                    //alert(1);
                }
            }
        });

        //为动态创建的下拉选项添加时间代理
        $(document).delegate(".autoComplete-list li", "click", function () {
            $('#autoComplete-input').val($(this).text());
            $('.autoComplete-list li').removeClass('active');
            $(this).addClass('active');
            $('#autoComplete-list').hide();
        });




//$('#txt_value').keyup(function (e) {
//    alert(e.keyCode)
//})

//上38


    }


    //创建signContabs插件
    $.fn.signContabs = function () {

        $(this).each(function () {
            $(this).children('.tabPlane').css({"display": "none"});
            $(this).children('.tabPlane').eq(1).css({"display": "block"});
            $(this).children().children(".tabBtn").click(function () {

                $(this).parent().find(".tabBtn").css({"background": "url('images/signConTabBtn.png')","color":"#2c84cc"});
                $(this).css({"background": "#FFF","color":"#000"});

                $(this).parent('.tabBtnGro').parent().children('.tabPlane').css({"display": "none"});
                $(this).parent('.tabBtnGro').parent().children('.tabPlane').eq($(this).index()).css({"display": "block"})
            })
        })

    };



    //详情页创建tab插件
    $.fn.projectInfoTabs = function () {

        $(this).each(function () {
            $(this).children('.tabPlane').css({"display": "none"})
            $(this).children('.tabPlane').eq(0).css({"display": "block"});
            $(this).children().children(".tabBtn").mouseover(function () {

                $(this).parent().find(".tabBtn").css({"background": "#f6f6f6","color":"#666","borderBottom":"1px solid #ccc","borderTop":"1px solid #ccc"})
                $(this).css({"background": "#FFF","color":"#2c84cc","borderBottom":"none","borderTop":"2px solid #2c84cc"});

                $(this).parent('.tabBtnGro').parent().children('.tabPlane').css({"display": "none"});
                $(this).parent('.tabBtnGro').parent().children('.tabPlane').eq($(this).index()).css({"display": "block"})
            })
        })

    };




})();