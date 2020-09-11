package kr.ko.ym.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileUploadService {

	Map<String, Object> selectMaxGroup()throws Exception;

	Map<String, Object> insertAttachFile(List<MultipartFile> fileList, Map<String, Object> param) throws Exception;
	
	List<Map<String,Object>>selectAttachFileListByIDX(Map<String, Object> param) throws Exception;
	
	List<Map<String,Object>>selectAttachFileListByGroup(Map<String, Object> param) throws Exception;
	
	void deleteAttachFile(Map<String, Object> param) throws Exception;
	
	void selectAttachFileDownload(Map<String, Object> param) throws Exception;
}
