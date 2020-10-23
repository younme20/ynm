package kr.ko.ym.common.util;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


public class FileDownloadUtil {
	
	public void downloadFile(HttpServletResponse request, HttpServletResponse response, Map<String, Object> file) {
		  String storedFileName = (String) file.get("STORED_FILE_NAME");
	      String originalFileName     = (String) file.get("ORG_FILE_NAME");   
		
	       byte[] fileByte = null;
		try {
			fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\ymnProject\\upload\\"+storedFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	       
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		try {
			response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
	}

}
