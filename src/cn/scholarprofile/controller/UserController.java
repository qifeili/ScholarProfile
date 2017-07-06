package cn.scholarprofile.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.scholarprofile.bean.User;
import cn.scholarprofile.service.UserService;
import cn.scholarprofile.util.MD5andKL;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
// @RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 添加操作
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 * @param rep
	 *            响应
	 * @throws Exception
	 */
	@RequestMapping("/add1.do")
	public String add(User user, HttpServletResponse response) throws Exception {

		userService.add(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/update.do")
	public String update(User user, HttpServletResponse response) throws Exception {
		System.out.println("------>" + user.getId() + user.getUsername() + user.getPassword());
		userService.update(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/toUpdate.do")
	public String toUpdate(int id, HttpServletResponse response, Model model) throws Exception {

		User user = userService.get(id);
		model.addAttribute(user);
		return "update";
	}

	@RequestMapping("/delete.do")
	public String delete(int id, HttpServletResponse response) throws Exception {

		userService.deleteById(id);
		;
		return "redirect:/user/list.do";
	}

	@RequestMapping("/list.do")
	public String list(HttpServletResponse response, ModelMap modelMap) throws Exception {

		List<User> users = userService.listAll();
		modelMap.put("users", users);
		return "registerStep01";
	}

	@ResponseBody
	@RequestMapping(value = "/getUsersAjax.do", produces = "application/json;charset=UTF-8")
	public String getUser(@RequestBody String username) {

		System.out.println(username);
		return "{\"username\": \"张三\"}";
	}

	// 测试头像的上传和显示
	// 上传文件方法
	@RequestMapping(value = "profile/uploadBasicHead", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String ajaxUpload(HttpServletRequest request) throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String fileName = "";
		String uploadPath = "uploadFile/head/";
		String path = request.getSession().getServletContext().getRealPath("/") + uploadPath;
		System.out.println("path--->" + path);
		/*
		 * File uploadPathFile = new File(path); if (!uploadPathFile.exists()) {
		 * uploadPathFile.mkdir(); }
		 */
		String realPath = "";
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			MultipartFile mulfile = multipartRequest.getFile(key);
			fileName = mulfile.getOriginalFilename();
			System.out.println("fileName----->" + fileName);
			fileName = handlerFileName(fileName);
			// File file = new File(path + retFileName);
			File file = new File(path + fileName);
			System.out.println("path + fileName --->" + path + fileName);
			mulfile.transferTo(file);
		}
		realPath = "{\"imagePath\":\"" + uploadPath + fileName + "\"}";
		System.out.println("realPath---->" + realPath);
		return realPath;
	}

	// 文件名称处理
	private String handlerFileName(String fileName) {
		// 处理名称start
		fileName = (new Date()).getTime() + "_" + fileName;
		// 时间戳+文件名，防止覆盖重名文件
		String pre = StringUtils.substringBeforeLast(fileName, ".");
		String end = StringUtils.substringAfterLast(fileName, ".");
		// fileName = Digests.encodeByMd5(pre)+"."+end;//用MD5编码文件名，解析附件名称
		fileName = MD5andKL.MD5(pre) + "." + end;// 用MD5编码文件名，解析附件名称
		// 处理名称end
		return fileName;
	}

	// 预览，获取图片流
	@RequestMapping(value = "profile/readImage", produces = "text/plain;charset=UTF-8")
	public void readImage(HttpServletRequest request, HttpServletResponse response) {
		String imagePath = request.getSession().getServletContext().getRealPath("/")
				+ request.getParameter("imagePath");
		try {
			File file = new File(imagePath);
			if (file.exists()) {
				DataOutputStream temps = new DataOutputStream(response.getOutputStream());
				DataInputStream in = new DataInputStream(new FileInputStream(imagePath));
				byte[] b = new byte[2048];
				while ((in.read(b)) != -1) {
					temps.write(b);
					temps.flush();
				}
				in.close();
				temps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
