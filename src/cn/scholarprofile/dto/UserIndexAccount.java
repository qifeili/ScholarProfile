package cn.scholarprofile.dto;

/**
 * @author  作者名 E-mail: 作者邮箱
 * @date : 2016年3月8日 上午9:16:35
 * @Description :用户帐号信息类页面数据装载类
 * @version 1.0
 */
public class UserIndexAccount {

	// 当前帐号, 数据取自用户注册时使用的字段
	private String userAccount;
	// 微信是否已经绑定
	private String WeixinStatus = "未绑定";
	// QQ是否已经绑定
	private String QQStatus = "未绑定";
	// 新浪微博是否已经绑定
	private String WeiboStatus = "未绑定";

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getWeixinStatus() {
		return WeixinStatus;
	}

	public void setWeixinStatus(String weixinStatus) {
		WeixinStatus = weixinStatus;
	}

	public String getQQStatus() {
		return QQStatus;
	}

	public void setQQStatus(String qQStatus) {
		QQStatus = qQStatus;
	}

	public String getWeiboStatus() {
		return WeiboStatus;
	}

	public void setWeiboStatus(String weiboStatus) {
		WeiboStatus = weiboStatus;
	}

}
