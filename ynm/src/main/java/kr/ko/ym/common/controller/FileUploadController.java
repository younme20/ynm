package kr.ko.ym.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	 
	/*
   	 * upload file list
   	 * */
   	@RequestMapping(value="/attach/list/{group}" , method = RequestMethod.GET)
   	@ResponseBody
   	public List<Map<String, Object>> list(HttpServletRequest request, @PathVariable String group) throws Exception {
   		Map<String,Object>param = new HashMap<String,Object>();
		param.put("FILE_GROUP", group);	
   		List<Map<String,Object>> list = fileuploadService.selectAttachFileListByGroup(param);
   		
   		return list;
   	}	
   	
	 /*
	 * upload file
	 * */
    @RequestMapping(value = "/attach/upload", method = RequestMethod.POST)    
    @ResponseBody
    public List<Map<String, Object>> upload(MultipartHttpServletRequest request, @RequestParam Map<String,Object> param) throws Exception { 
    	
    	List<MultipartFile> fileList = request.getFiles("uploadFile");
    	fileuploadService.insertAttachFile(fileList, param);
    	List<Map<String,Object>> list  = fileuploadService.selectAttachFileListByGroup(param);
    	return list;
    	//String group = String.valueOf(param.get("FILE_GROUP"));
    	//return "redirect:/attach/list/"+group; 
    }
   	
    /*
	 * upload file delete
	 * */
	@RequestMapping(value="/attach/delete" , method = RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,  @RequestParam Map<String,Object> param) throws Exception {
		
		fileuploadService.deleteAttachFile(param);
		String group = String.valueOf( param.get("FILE_GROUP"));
		return "redirect:/attach/list/"+group;
	}	
	
	 /*
	 * upload file download
	 * */
	@RequestMapping(value="/attach/download")
	public void download(HttpServletResponse response, @RequestParam Map<String,Object>param) throws Exception{
		
		fileuploadService.selectAttachFileDownload(param);
		
	}
}
