package cn.scholarprofile.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.scholarprofile.bean.UserInfo;
/**
 * @author 李齐飞 
 * @date : 2016年07月24日 
 * @Email:  716716fei@sina.com
 */

public interface Auserservice {

	public void addUser(UserInfo user);  //增加

	public List<UserInfo>  getalluser();    //获取全部

    public UserInfo getuser(String id);    //获取单个信息
	
	public boolean deluser(String id);     //删除信息
	
	public boolean  update(UserInfo user);//更新信息

	public boolean login(String keeper, String password);//验证登陆

	public boolean mima(String keeper, String oldpassword, String newpassword);

	public void pl();


}
