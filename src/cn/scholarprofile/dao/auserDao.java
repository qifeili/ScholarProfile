package cn.scholarprofile.dao;
/**
 * @author 李齐飞 
 * @date : 2016年07月24日 
 * @Email:  716716fei@sina.com
 */
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.scholarprofile.bean.Administrators;
import cn.scholarprofile.bean.UserInfo;

public interface auserDao {

	public void addUser(UserInfo user);

	public List<UserInfo> getAlluser();

	public UserInfo getUser(String id);

	public boolean del(String id);

	public boolean update(UserInfo user);

	public Boolean login(String keeper, String password);  //管理员登录验证

	public String oldmima(String keeper);                           //管理员修改密码前验证旧密码
	
	public void newmima(String newpassword,String keeper);//管理员验证密码后更新新的密码

	public String paperlist();    //
}
