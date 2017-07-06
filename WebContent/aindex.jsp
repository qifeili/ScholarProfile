<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%    String path = request.getContextPath();
     String basePath = request.getScheme() + "://"
             + request.getServerName() + ":" + request.getServerPort()
             + path + "/";
%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>UserInfo-用户信息管理主页</title>    
 <link href="css/aone" rel="stylesheet">
<style>
form{backgroud-color:blue}
.one{background-color: #008CBA;  border:none; color:white; padding:10px 15px;
text-decoration:none; display:inline-block; font-size:15px;margin:4px 10px; cursor:pointer;}
table.main{font-family:verdana,arial,sans-serif; font-size:11px; border-corlor:#999999;border-right:1px solid #804040;border-bottom:1px solid blue; border-collapse:collapse;}
table.main th{ background:#b5cfd2 ; border-width:1px; padding:8px;border-left:1px solid  gray;border-top:1px solid  gray;}
table.main td{ background:#dcddc0; border-width:1px;  padding:8px;border-left:1px solid gray;border-top:1px solid gray;}
</style>
<!-- 导入jQuery的jar包 -->
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/messages_cn.js"></script>
<script type="text/javascript" src="js/build/dist/echarts.js"></script>
<script>//1.ajax方法
/*   function shanchu(id){   //这样写是为了防止文档在完全加载好之前运行代码。
	 $.ajax({                                            //$("")有元素选择器，id选择器、class选择器。
			type:"post",
			url:"/scholarprofile/deluser.do?id="+id,			
			contentType: "application/json; charset=utf-8",                
			success:function(data){
	     		 $("#"+id).html(data);
	     	 }		})  	} ;  */
	// 2.load方法。
 	/*  function shanchu(id){ 
		$("#"+id).load("/scholarprofile/deluser.do?id="+id);
	};   */
  //3.get方法
/*      function shanchu(id){
	   $.get("/scholarprofile/deluser.do?id="+id,function(data){
		   $("#"+id).empty().append(data);
	   })		
	};  */
//4.post方法
    function shanchu(id){
		$.post("/scholarprofile/deluser.do",{"id":id},function(data){		
/*  			var dat=eval("("+data+")");
			var one=dat.on;
			var two=dat.alert; 
			if(on.equals("2")){
				alert(on);
			$("#"+id).empty().append(two);  }   
			else  */
				$("#"+id).empty().append(data);
	});    	}  ;
</script>
</head>  
<body>
  <ol >
    <a  href="/scholarprofile/toadd.do" ><button class="one"  text-align:center><b>添加新用户</b> </button></a>
    <a href="/scholarprofile/tokeep.do"><button class="one"  text-align:center> <b>修改管理员密码</b></button></a>
      <%--  <h3>${errordel}</h3> --%>
       <font id="del" color="red" font-size="medium"></font>
  </ol>
   <table  class="main">   
        <tbody>  
            <tr>  
               <th>用户名</th>  
               <th>登录密码</th>  
               <th>电子邮箱</th>  
                <th>真实姓名</th> 
               <th>出生日期</th>
               <th>性别</th>
                <th>最高学历</th>
               <th>工作年限</th>
               <th>工作地点</th>
               <th>当前行业与职能</th>
               <th>公司名</th>
               <th>职位</th>
               <th>电话号码</th>
               <th>感兴趣的领域</th>
               <th>注册的手机号</th>
               <th>注册类型</th>
               <th>第三方登录名</th>
               <th>用户创建的项目</th>
               <th>用户关注数</th>
               <th>用户信息管理</th>
            </tr>  
            <c:if test="${!empty userList }">  
                <c:forEach items="${userList }"   var="user" >      
                    <tr id="${user.id}">  
                         <td>${user.username }</td>  
                        <td>${user.password }</td>  
                        <td>${user.email}    </td>
                        <td>${user.realName}    </td>
                        <td>${user.birthday}   </td>
                        <td>${user.sex}    </td>
                        <td> ${user.maxDegree}  </td>
                        <td>${user.worklife}   </td>
                        <td>${user.workPlace}   </td>
                        <td> ${user.industryAndFunctional}  </td>
                         <td>${user.companyName}</td>
                         <td>${user.curPosition}</td>
                         <td>${user.phone}</td>
                         <td>${user.interestField}</td>
                         <td>${user.registerNumber}</td>
                         <td>${user.registerType}</td>
                         <td>${user.thirdPartyUsername} </td>
                         <td> <c:forEach     items="${user.projects}" var="project" >  ${project.title}   </c:forEach> </td>  
                         <td>${user.focuses}</td>
                        <td>  <form   action="/scholarprofile/getuser.do?id=${user.id}" method=post>
                                                     <input  color="green" type="submit"  value="编辑">        </form>                       
                               <button type="button"   onclick="shanchu(${user.id})">删除</button>
                            </td></tr>              
                </c:forEach>  
            </c:if>     
        </tbody>  
    </table>  
    </div>
     <div>  <h1 id="test">COME ON!YOU ARE BEST!</h1></div>
</body>  
</html> 