package cn.scholarprofile.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile {
	/**
	 * 下载文件,file 为文件位置
	 */
	public static void downloadFile(String file, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			File tempFile = new File(file.trim());
			String fileName = tempFile.getName();
			InputStream is = new FileInputStream(file);
			response.reset(); // 必要地清除response中的缓存信息
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-disposition", 
			                   "attachment;" + UserAgentUtil.encodeFileName(request, fileName));
			//response.setHeader("Content-Length", String.valueOf(fileLength));
			/*response.setHeader("Content-Disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(fileName, "UTF-8"));*/
			javax.servlet.ServletOutputStream out = response.getOutputStream();
			byte[] content = new byte[1024];
			int length = 0;
			while ((length = is.read(content)) != -1) {
				out.write(content, 0, length);
			}
			out.flush();
			out.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
