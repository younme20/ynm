package kr.ko.ym.board.service;

import kr.ko.ym.common.dao.CommonDao;
import kr.ko.ym.common.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private CommonDao commonDao;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectBoard(Map<String, Object> param) throws Exception {
		PagingUtil paging = new PagingUtil();
		int index = 1;
		if(param.containsKey("pageIndex")) {
 			index = Integer.parseInt(param.get("pageIndex").toString());
 			paging.setPageIndex(index);
			
		}
		paging.countPaging(index, 5);
		param.put("page",paging);

		return commonDao.selectList("board.selectBoard", param);
	}

	@Override
	public Map<String, Object> selectDetail(Map<String, Object> param) throws Exception {
	
		return commonDao.selectOne("board.detailBoard",param);
	}

	@Override
	public Integer insertBoard(Map<String, Object> param) throws Exception {
		return (int)commonDao.insert("board.insertBoard",param);
	}

	@Override
	public void updateCount(Map<String, Object> param) throws Exception {
		commonDao.update("board.updateCount",param);
	}

	@Override
	public void updateBoard(Map<String, Object> param) throws Exception {
		commonDao.update("board.updateBoard",param);
	}

	@Override
	public void deleteBoard(Map<String, Object> param) throws Exception {
		commonDao.delete("board.deleteBoard", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Map<String, Object> selectMaxIdx() throws Exception {
		return commonDao.selectOne("board.selectMaxIdx");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> serchBoard(Map<String, Object> param) throws Exception {
		return commonDao.selectList("board.selectBoard", param);
	}
	
	
	@Override
	public Map<String, Object> selectCount(Map<String, Object> param) throws Exception {
		return commonDao.selectOne("board.selectCount", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectLastComment() throws Exception {
	
		return commonDao.selectList("board.selectLastComment");
	}

	@Override
	public List<Map<String, Object>> selectCategory() throws Exception {
		return commonDao.selectList("board.selectCategory");
	}


}
