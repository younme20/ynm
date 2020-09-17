package kr.ko.ym.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileDownloadUtil {
	
	public void downloadFile(Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uploadPath = "C:\\ymnProject\\upload\\"; // 파일이 저장될 위치
	    String storedFileName = (String) param.get("STORED_FILE_NAME");
        String originalFileName     = (String) param.get("ORG_FILE_NAME");   
		File uFile = new File(uploadPath, storedFileName);
		int fSize = (int) uFile.length();
 
		if (fSize > 0) {
 
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(uFile));
			// String mimetype = servletContext.getMimeType(requestedFile);
			String mimetype = "text/html";
 
			response.setBufferSize(fSize);
			response.setContentType("application/octer-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ originalFileName + "\"");
			response.setContentLength(fSize);
 
			FileCopyUtils.copy(in, response.getOutputStream());
			in.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} else {
			//setContentType을 프로젝트 환경에 맞추어 변경
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<br><br><br><h2>Could not get file name:<br>"
					+ originalFileName + "</h2>");
			printwriter
					.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		request.setCharacterEncoding("UTF-8");
	
	try{
			boolean skip = false;
			String client = "";
	        String storedFileName = (String) param.get("STORED_FILE_NAME");
	        String originalFileName     = (String) param.get("ORG_FILE_NAME");   
	       
	        File file = new File(filePath, storedFileName);
	       
	        byte[] fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\ymnProject\\upload\\"+storedFileName));
	        
	        response.reset();
	        response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
			response.setHeader("Content-Transter-Encoding", "binary");
			//response.setHeader("Content-Type", "application/octet-stream");
			response.setHeader("Pragma", "no-cache;");
			response.setHeader("Expires", "-1;");
	 		
			OutputStream out = null;
			FileInputStream fis = null;
 		 
 		try {
	 		fis = new FileInputStream(file);
	 	}catch (FileNotFoundException  e) {
	 		skip = true;
		}
 		
 		client = request.getHeader("User-Agent");
 		
 		if(!skip){
 			
 			 if (client.indexOf("MSIE") != -1) {
                 response.setHeader("Content-Disposition", "attachment; filename=\""
                         + java.net.URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
                 // IE 11 이상.
             } else if (client.indexOf("Trident") != -1) {
                 response.setHeader("Content-Disposition", "attachment; filename=\""
                         + java.net.URLEncoder.encode(originalFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
             } else {
                 // 한글 파일명 처리
                 response.setHeader("Content-Disposition",
                         "attachment; filename=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
                 response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
             }
             response.setHeader("Content-Length", "" + file.length());
             out = response.getOutputStream();
             byte b[] = new byte[(int) file.length()];
             int leng = 0;
             while ((leng = fis.read(b)) > 0) {
                 out.write(b, 0, leng);
             }
         } else {
             response.setContentType("text/html;charset=UTF-8");
             System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
         }
 		fis.close();
 		out.close();
     } catch (Exception e) {
         System.out.println("ERROR : " + e.getMessage());
     }*/

/*
 * 	 int readCount = 0;
 		 byte[] buffer = new byte[1024];
 		try {	
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
                // outputStream에 씌워준다
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            out.flush();
        }*/
 		
 		/*response.getOutputStream().write(fileByte);
 		response.getOutputStream().flush();
 		response.getOutputStream().close();*/
    }
}
