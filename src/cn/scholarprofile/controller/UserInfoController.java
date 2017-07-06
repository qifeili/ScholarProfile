package cn.scholarprofile.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scholarprofile.dto.UserIndexAccount;
import cn.scholarprofile.dto.UserInfoRegistStep01;
import cn.scholarprofile.dto.UserInfoRegistStep02;
import cn.scholarprofile.service.UserInfoService;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class UserInfoController {

	private UserInfoService userInfoService;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	@Resource
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@RequestMapping("/register.do")
	public String register(HttpServletResponse response,
			HttpServletRequest request, String emailOrNumber, String password)
			throws Exception {

		if(emailOrNumber == null || "".equals(emailOrNumber) || password == null || "".equals(password)) {
			
			request.setAttribute("registerFail", "请同时输入用户名和密码");
			return "redirect:/index";
		}
		
		int userInfoId = userInfoService.register(emailOrNumber, password);
		if (userInfoId == -1) {// 注册不成功，提示用户用户名重复

			request.setAttribute("registerFail", "用户名已存在");
			return "redirect:/index";
		}

		String username = userInfoService.getUsernameById(userInfoId);

		// 注册成功后，将用户id和用户名保存在session中,便于以后使用
		request.getSession().setAttribute("userInfoId", userInfoId);
		request.getSession().setAttribute("username", username);

		return "registerStep01";
	}

	@RequestMapping("/registerStep01.do")
	public String registerStep01(HttpServletResponse response,
			HttpServletRequest request, UserInfoRegistStep01 info)
			throws Exception {

		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {
			System.out.println("用户未登录");
		}else {
			userInfoService.completeInfoStep01(userInfoId, info);		
		}
		return "registerStep02";
	}

	@RequestMapping("/registerStep02.do")
	public String registerStep02(HttpServletResponse response,
			HttpServletRequest request, UserInfoRegistStep02 info)
			throws Exception {
		
		if(info == null) {
			return "redirect:/index";
		}
		
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {
			System.out.println("用户未登录");
		}else {
			userInfoService.completeInfoStep02(userInfoId, info);
		}
		return "redirect:/index";
	}

	@RequestMapping("/QQAuthorize.do")
	public void QQAuthorize(HttpServletResponse response,
			HttpServletRequest request) {

		try {

			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (IOException e) {

			e.printStackTrace();
		} catch (QQConnectException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping("/AfterQQLoginRedirect.do")
	public String afterQQLoginRedirect(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		try {
			AccessToken accessTokenObj = (new Oauth())
					.getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				System.out.print("没有获取到响应参数");
			} else {
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				request.getSession().setAttribute("access_token", accessToken);
				request.getSession().setAttribute("token_expirein",
						String.valueOf(tokenExpireIn));

				// 利用获取到的accessToken 去获取当前用的openid -------- start
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				// out.println("欢迎你，代号为 " + openID + " 的用户!");
				request.getSession().setAttribute("openid", openID);
				// 利用获取到的accessToken 去获取当前用户的openid --------- end

				// openID跟QQ用户一一对应，所以用openID作为QQ用户登录的唯一标识
				int userInfoId = userInfoService
						.registerInThirdParty(openID, 1);

				// 处理登录申请发出后的事情
				if (userInfoId == -1) {// 注册不成功，提示用户用户名重复

					request.setAttribute("registerFail", "用户名已存在");
					return "redirect:/index";
				}

				String username = userInfoService
						.getThirdPartyUsernameById(userInfoId);

				// 注册成功后，将用户id和用户名保存在session中,便于以后使用
				request.getSession().setAttribute("userInfoId", userInfoId);
				request.getSession().setAttribute("username", username);

			}
		} catch (QQConnectException e) {
		}
		return null;
	}
	
	@RequestMapping("/userIndexAccount.do")
	public String userIndexAccount(HttpServletResponse response,
			HttpServletRequest request)
			throws Exception {	
		
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {
			System.out.println("用户未登录");
			return "userIndexAccount";
		}else {
			UserIndexAccount userIndexAccount = userInfoService.userIndexAccount(userInfoId);
			request.setAttribute("userIndexAccount", userIndexAccount);
		}
		return "userIndexAccount";
	}

	@ResponseBody
	@RequestMapping(value = "/reLoginAjax.do")
	// 小窗口的登录，返回普通的字符串
	// args:dl 表示浏览器中用户正在访问的页面
	public String reLoginAjax(HttpServletRequest request,
			String signInDialogNumInput, String signInDialogPassInput, Integer projectId)
			throws Exception {
		if (signInDialogNumInput == null || "".equals(signInDialogNumInput)
				|| signInDialogPassInput == null
				|| "".equals(signInDialogPassInput)) {

			return "false";
		}
		int userInfoId = userInfoService.login(signInDialogNumInput,
				signInDialogPassInput);
		if (userInfoId == -1) {// 用户未注册

			return "false";
		}
		String username = userInfoService.getUsernameById(userInfoId);
		// 登录成功后，将用户id和用户名保存在session中,便于以后使用
		request.getSession().setAttribute("userInfoId", userInfoId);
		request.getSession().setAttribute("username", username);
		// 判断是否是项目发布过程中出现了session失效，约定session失效情况下，前台传回projectId
		if(projectId != null || ! "".equals(projectId)) {//session中途失效情况
			request.getSession().setAttribute("projectId", projectId);
		}
		return "true";
	}
	@ResponseBody
	@RequestMapping(value = "/loginAjax.do")
	// 小窗口的登录，返回普通的字符串
	public String loginAjax(HttpServletRequest request,
			String signInDialogNumInput, String signInDialogPassInput, Integer projectId)
					throws Exception {
		if (signInDialogNumInput == null || "".equals(signInDialogNumInput)
				|| signInDialogPassInput == null
				|| "".equals(signInDialogPassInput)) {
			
			return "false";
		}
		int userInfoId = userInfoService.login(signInDialogNumInput,
				signInDialogPassInput);
		if (userInfoId == -1) {// 用户未注册
			
			return "false";
		}
		String username = userInfoService.getUsernameById(userInfoId);
		// 登录成功后，将用户id和用户名保存在session中,便于以后使用
		request.getSession().setAttribute("userInfoId", userInfoId);
		request.getSession().setAttribute("username", username);
		// 判断是否是项目发布过程中出现了session失效，约定session失效情况下，前台传回projectId
		if(projectId != null || ! "".equals(projectId)) {//session中途失效情况
			request.getSession().setAttribute("projectId", projectId);
		}
		return "true";
	}
	
	@ResponseBody
	@RequestMapping(value = "/isloginAjax.do")
	// 判断用户是否登录的ajax接口
	public String isloginAjax(HttpServletRequest request) throws Exception {
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		//用户未登录,session已失效
		if(userInfoId == null) {
			return "false";
		}
		return "true";
	}
	
	@ResponseBody
	@RequestMapping(value = "/logoutAjax.do")
	// 小窗口的登录，返回普通的字符串
	public String logoutAjax(HttpServletRequest request
			) throws Exception {
		
		HttpSession session = request.getSession();
		//System.out.println(session.getAttribute("userInfoId"));
		if(session.getAttribute("userInfoId") != null) {
			session.removeAttribute("userInfoId");
			System.out.println("---->" +  session.getAttribute("userInfoId"));
			return "true";
		}
		return "false";
	}

	@ResponseBody
	@RequestMapping(value = "/registerAjax.do")
	// 小窗口注册，返回普通的字符串
	public String registerAjax(HttpServletRequest request,
			String signUpDialogNumInput, String signUpDialogPassInput)
			throws Exception {

		if (signUpDialogNumInput == null || "".equals(signUpDialogPassInput)
				|| signUpDialogPassInput == null
				|| "".equals(signUpDialogPassInput)) {

			return "false";
		}

		int userInfoId = userInfoService.register(signUpDialogNumInput,
				signUpDialogPassInput);
		if (userInfoId == -1) {// 注册不成功，提示用户用户名重复

			request.setAttribute("registerFail", "用户名已存在");
			return "false";
		}

		String username = userInfoService.getUsernameById(userInfoId);

		// 注册成功后，将用户id和用户名保存在session中,便于以后使用
		request.getSession().setAttribute("userInfoId", userInfoId);
		request.getSession().setAttribute("username", username);

		return "true";
	}

	@ResponseBody
	@RequestMapping(value = "/getMailboxVerificationCode.do")
	// 小窗口注册，返回普通的字符串
	public String getMailboxVerificationCode(HttpServletRequest request,
			String targetMailbox) throws Exception {

		if (targetMailbox == null) {
			return "false";
		}
		Boolean result = userInfoService
				.getMailboxVerificationCode(targetMailbox);

		return result.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "/compareMailboxVerificationCode.do")
	// 小窗口注册，返回普通的字符串
	public String compareMailboxVerificationCode(HttpServletRequest request, String mailbox, String verificationCode,
			String newPassword) throws Exception {

		if (mailbox == null || verificationCode == null || newPassword == null) {
			return "false";
		}
		Boolean result = userInfoService.compareMailboxVerificationCode(mailbox, verificationCode, newPassword);

		return result.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/changePasswordAjax.do")
	// 小窗口注册，返回普通的字符串
	public String changePasswordAjax(HttpServletRequest request,
		    String oldPassword, String newPassword)
			throws Exception {

		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		//用户没登陆，直接返回false
		if(userInfoId == null) {
			return "false";
		}
		Boolean result = userInfoService.changePassword(userInfoId, oldPassword, newPassword);
		return result.toString();
	}
	
}
