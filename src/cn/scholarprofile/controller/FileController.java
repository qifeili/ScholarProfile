package cn.scholarprofile.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.scholarprofile.service.FileService;
import cn.scholarprofile.util.DownloadFile;
import cn.scholarprofile.util.FileBasePathUtil;



/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class FileController {

	@Resource
	private FileService fileService;

	// 单文件上传
	@RequestMapping(value = "/upload.do")
	public String queryFileData(@RequestParam("uploadfile") CommonsMultipartFile file, HttpServletRequest request)
			throws Exception {
		// MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数(数组)
		// 此处应该从Session中取出用户名
		// String username = (String)
		// request.getSession().getAttribute("username");
		String username = "zhangsan";
		if (!file.isEmpty()) {
			String type = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));// 取文件格式后缀名
			String filename = username + "_" + System.currentTimeMillis() + type;// 取当前时间戳作为文件名
			/*String path = request.getSession().getServletContext().getRealPath("/upload/" + username + "/" + filename);// 存放位置
*/			String path = FileBasePathUtil.getFileBasePath() + username + "/" + filename;// 存放位置
			File destFile = new File(path);
			try {
				// 如果文件不存在，则创建目录和所需的所有上级目录
				if (!destFile.exists()) {
					destFile.mkdirs();
				}
				file.transferTo(destFile);
				//UploadInfo info = new UploadInfo(path, username);
				//fileService.add(info);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "uploadSuccess";
		} else {
			return "uploadFailure";
		}
	}

	// 多文件上传
	@RequestMapping(value = "/uploads.do")
	public String queryFileDatas(@RequestParam("uploadfile") CommonsMultipartFile[] files, HttpServletRequest request)
			throws Exception {
		// 此处应该从Session中取出用户名
		// String username = (String)
		// request.getSession().getAttribute("username");
		String username = "zhangsan";
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().indexOf("."));// 取文件格式后缀名
				String filename = username + "_" + System.currentTimeMillis() + type;// 取当前时间戳作为文件名
				String path = request.getSession().getServletContext()
						.getRealPath("/upload/" + username + "/" + filename);// 存放位置
				File destFile = new File(path);
				try {
					// 如果文件不存在，则创建目录和所需的所有上级目录
					if (!destFile.exists()) {
						destFile.mkdirs();
					}
					files[i].transferTo(destFile);
				//	UploadInfo info = new UploadInfo(path, username);
				//	fileService.add(info);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return "uploadSuccess";
		} else {
			return "uploadFailure";
		}
	}

//	@RequestMapping(value = "/download.do")	
//	public void downloadDetailPrice(//@RequestParam String id, 
//			HttpServletRequest request, HttpServletResponse response) {
//		String file = "D:\\a.txt";
//		DownloadFile.downloadFile(file,request,response);//有异常但是不影响任何操作		
//		//response.reset();		
//	} 
	
	@RequestMapping(value = "/download.do")	
	public void downloadProjectEnclosureOrDataSet(@RequestParam String id, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(id == null || "".equals(id)) {
			return;
		}
		//String file = "D:\\a.txt";
		//根据文件id找到服务器上文件所在的地址
		String file = fileService.getUploadPathById(id);	
		if(file == null) {
			return;
		} 
		DownloadFile.downloadFile(file,request,response);//有异常但是不影响任何操作		
		//response.reset();	
			
	} 
}
