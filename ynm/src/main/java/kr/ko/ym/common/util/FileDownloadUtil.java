package kr.ko.ym.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class FileDownloadUtil {
	private static final String filePath = "C:\\ymnProject\\upload\\"; // 파일이 저장될 위치
	public void downloadFile(Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) throws Exception {
          
        String storedFileName = (String) param.get("STORED_FILE_NAME");
        String originalFileName     = (String) param.get("ORG_FILE_NAME");   
       // String file_size = (String) param.get("FILE_SIZE");
        
        File file = new File(storedFileName);
        // 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
        byte[] fileByte = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\ymnProject\\upload\\"+storedFileName));
 		
		response.setHeader("Content-Disposition","attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transter-Encoding", "binary");
		response.setHeader("Content-Type", "application/octet-stream");
		//response.setHeader("Content-Length",(int)file.length() );
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");
 		 //response.setContentType("application/download; utf-8");
 		
 		
 		 OutputStream out = response.getOutputStream();
 		 FileInputStream fis = new FileInputStream(filePath + storedFileName);
 		 
 		 int readCount = 0;
 		 byte[] buffer = new byte[1024];
 		  
 		try {
           // FileCopyUtils.copy(fis, out);
           // int readCount = 0;
           // byte[] buffer = new byte[1024];
            // 파일 읽을 만큼 크기의 buffer를 생성한 후 
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
        }
 		
 		/*response.getOutputStream().write(fileByte);
 		response.getOutputStream().flush();
 		response.getOutputStream().close();*/
    }
}
