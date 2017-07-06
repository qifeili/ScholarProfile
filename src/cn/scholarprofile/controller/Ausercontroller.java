package cn.scholarprofile.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.service.Auserservice;
/**
 * @author 李齐飞 
 * @date : 2016年07月24日 
 * @Email:  716716fei@sina.com
 */
@Controller  
public class Ausercontroller {
	
    @Resource  
    private Auserservice auserservice;  	
    
    //管理员登陆操作
@RequestMapping("/login.do")
 public String handleRequest(String keeper,String password,HttpServletRequest request) throws Exception {

	     if( auserservice.login(keeper, password)){	      
	    	 request.getSession().setAttribute("keep", keeper);
	      return "redirect:/getall.do";
	      }
	     else{
	     return "/alogin";
	     }
 }

//1.跳转到管理员修改密码的操作页面
@RequestMapping("/tokeep.do")
public String getowner(HttpServletRequest request){
	String keep=(String)request.getSession().getAttribute("keep");
	if(keep!=null){
	return "administrators";  }
	else  return"/alogin";
}//2.管理员修改密码操作
@RequestMapping("/mima.do")
public String mima(String keeper,String oldpassword,String newpassword,String newpassword2,HttpServletRequest request){
	if(newpassword.equals(newpassword2)){
	if(auserservice.mima(keeper,oldpassword,newpassword)){
		return "alogin";
	}
	else
		request.setAttribute("news","原密码输入错误！" ); 
    	return "administrators";
	}
	else 
		request.setAttribute("news","两次输入的新密码不一致!" ); 
		return "administrators";
	}

     //查询全部信息
    @RequestMapping("/getall.do")
    public String getall(HttpServletRequest request ){  	
    	String keep=(String)request.getSession().getAttribute("keep");
    	if(keep!=null){
    	request.setAttribute("userList",auserservice.getalluser());
    	return "/aindex";}
    	else return"/alogin";
    }
    //获取单个用户信息
    @RequestMapping("/getuser.do")
    public String getUser(String id,HttpServletRequest request){
    	String keep=(String)request.getSession().getAttribute("keep");
    	if(keep!=null){
    		request.setAttribute("user",auserservice.getuser(id));   	
    		return "/aedit";   }
    	else return"/alogin";
    }  
    
    //增加用户信息 1.跳转到增加页面
    @RequestMapping("/toadd.do")  
    public String toAdd(HttpServletRequest request){  
    	String keep=(String)request.getSession().getAttribute("keep");
    	if(keep!=null){
    	return "aadd";  }
    	else return"/alogin";
    }                          //2.提交增加信息
    @RequestMapping("/adduser.do")  
    public String addUser(UserInfo user,HttpServletRequest request){  
    	String keep=(String)request.getSession().getAttribute("keep");
    	if(keep!=null){
    	auserservice.addUser(user);    	
    	return "redirect:/getall.do";}
    	else return"/alogin";
}
       
      //删除用户信息
    @RequestMapping("/deluser.do")  
    //@ResponseBody   //此注解不能省略，否则ajax无法接收返回值。
    public  String delUser(String id,HttpServletResponse response,HttpServletRequest request) throws JSONException {                         
    	String delinfo="该用户注册了项目，无法删除";
    	String keep=(String)request.getSession().getAttribute("keep"); 	
    	if(keep!=null){
    	if(auserservice.deluser(id)){ 
    		
				try {
					response.setCharacterEncoding("utf-8");
					response.getWriter().write("");//或者写response.getWriter().print(result);
					response.getWriter().flush();	
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();	} 
				return null;
//        return m; //这个地方该返回什么，可以让前台相应的区域消失。
    } else {
			try {
/*			JSONObject obj=new JSONObject();
				obj.put("alert", "<script>alert('该用户已创建项目，无法删除！');</script>"); 
			    obj.put("on", "2");*/
				response.setCharacterEncoding("utf-8");
   			    response.getWriter().write("<script>alert('该用户已创建项目，无法删除！');</script>");
				response.getWriter().flush();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 	
    	return null;    }
    	}
 else return"/alogin";  
        }
    
      //更新用户信息
	@RequestMapping("/updateuser.do")  
    public String updateUser(UserInfo user,HttpServletRequest request){  
          
        if(auserservice.update(user)){  
            return "redirect:/getall.do";  
        }else{  
            return "/aerror";  
        }  
    }
	//导入paperlist数据
	@RequestMapping("/paperlist.do")
	public String paperlist(){
		auserservice.pl();
		return "/aadd";
	}
	
    }