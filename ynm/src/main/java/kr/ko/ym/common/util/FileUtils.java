package kr.ko.ym.common.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils{
	
	private static final String filePath = "C:\\ymnProject\\upload"; // 파일이 저장될 위치

	public Map<String, Object> uploadFile(List<MultipartFile> fileList, Map<String, Object> param) {
	
    	File fileDir = new File(filePath); 
    	if (!fileDir.exists()) { 
    		fileDir.mkdirs(); 
    	} 
    	
    	long time = System.currentTimeMillis(); 
    	
    	for (MultipartFile mf : fileList) { 
    		
    		String originalFileName = mf.getOriginalFilename();
    		// 원본 파일 명
    		String storedFileName = String.format("%d_%s", time, originalFileName); 
    		try { 
    			// 파일생성
    			mf.transferTo(new File(filePath, storedFileName)); 
    			param.put("FILE_GROUP", param.get("FILE_GROUP"));
    			param.put("MENU_CODE", param.get("MENU_CODE"));
    			param.put("ORG_FILE_NAME", originalFileName);
    			param.put("STORED_FILE_NAME", storedFileName);
    			param.put("FILE_SIZE", mf.getSize());
				
    		} catch (Exception e) { 
    			e.printStackTrace(); 
    		} 
    		
    	} 
    	return param;
	}

}