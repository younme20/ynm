package kr.ko.ym.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ko.ym.common.dao.CommonDao;
import kr.ko.ym.common.util.FileUtils;

@Service("FileUploadService")
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
	private CommonDao commonDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectMaxGroup() throws Exception {
	
		return commonDao.selectOne("attach.selectMaxGrp");
	}
	
	@Override
	public Map<String, Object> insertAttachFile(List<MultipartFile> fileList, Map<String, Object> param)
			throws Exception {	

		if("".equals(param.get("FILE_GROUP"))){
			commonDao.insert("attach.insertAttachFileGroup",param);
		}
		
		@SuppressWarnings("unchecked")
		Map<String,Object>map = commonDao.selectOne("attach.selectMaxGrp");
		param.put("FILE_GROUP", map.get("FILE_GROUP"));
		
		FileUtils file = new FileUtils();
		
		Map<String, Object> data = file.uploadFile(fileList,param);
		commonDao.insert("attach.insertAttachFile", data);
		
		return param;
		
	}

	
	

}
