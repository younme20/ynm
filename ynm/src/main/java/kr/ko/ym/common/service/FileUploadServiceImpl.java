package kr.ko.ym.common.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ko.ym.common.dao.CommonDao;
//import kr.ko.ym.common.util.FileDownloadUtil;
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
		//�뾽濡쒕뱶 �뙆�씪 洹몃９ �깮�꽦
		if("".equals(param.get("FILE_GROUP"))){
			commonDao.insert("attach.insertAttachFileGroup",param);
			@SuppressWarnings("unchecked")
			Map<String,Object>map = commonDao.selectOne("attach.selectMaxGrp");
			param.put("FILE_GROUP", map.get("FILE_GROUP"));
		}
		
		
		
		FileUtils file = new FileUtils();
		//�뙆�씪 �뾽濡쒕뱶
		Map<String, Object> data = file.uploadFile(fileList,param);
		commonDao.insert("attach.insertAttachFile", data);
		
		//�뾽濡쒕뱶�맂 �뙆�씪 紐⑸줉
		@SuppressWarnings("unchecked")
		Map<String, Object> files = commonDao.selectOne("attach.selectAttachFileListByGroup");
		return files;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectAttachFileListByIDX(Map<String, Object> param) throws Exception {
		
		return commonDao.selectList("attach.selectAttachFileListByIDX",param);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectAttachFileListByGroup(Map<String, Object> param) throws Exception {
		return commonDao.selectList("attach.selectAttachFileListByGroup",param);
	}
	
	@Override
	public void deleteAttachFile(Map<String, Object> param) throws Exception {
		commonDao.delete("attach.deleteAttachFile",param);
	}

	@Override
	public void selectAttachFileDownload(Map<String, Object> param) throws Exception {
		
	
		Map<String, Object> file = commonDao.selectOne("attach.selectAttachFileDownload",param);
		//FileDownloadUtil down = new FileDownloadUtil();
		//down.downloadFile(param, null, null);
	
	}

	

	

}
