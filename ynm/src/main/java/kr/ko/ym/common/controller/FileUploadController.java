package kr.ko.ym.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ko.ym.common.service.FileUploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileuploadService;
    
    @RequestMapping(value = "/attach/multipartUpload", method = RequestMethod.POST)
    @ResponseBody
    public Object multipartUpload(MultipartHttpServletRequest request, @RequestParam Map<String,Object>param) throws Exception { 
    	
    	List<MultipartFile> fileList = request.getFiles("uploadFile");
    	Map<String,Object>map = fileuploadService.insertAttachFile(fileList, param);
    	
    	return map.get("FILE_GROUP");
    }
}
