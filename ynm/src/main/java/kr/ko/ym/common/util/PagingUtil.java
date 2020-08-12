package kr.ko.ym.common.util;

import java.util.List;

public class PagingUtil {
	
	private int pageIndex; 
	
	private int startRow; 
	
	private int endRow;
	
	private int pageSize; 
	
	private List<?> resultList;
	
	private int totalCount;
	
	public int getPageIndex() {
	    return pageIndex;
	}
	
	public int getStartRow() {
	    return startRow;
	}
	
	public int getEndRow() {
	    return endRow;
	}
	
	public int getPageSize() {
	    return pageSize;
	}
	
	public List<?> getResultList() {
	    return resultList;
	}
	
	public int getTotalCount() {
	    return totalCount;
	}
	
	//pageIndex : 페이지 인덱스
	//pageSize : 몇 줄까지 보여줄지..
	public void countPaging(int pageIndex, int pageSize) {
		this.pageIndex = this.pageIndex < 1 ? 1 : this.pageIndex;
		this.pageSize = pageSize;
		this.startRow = (pageIndex-1)*pageIndex;
		this.endRow = startRow + pageSize;		
	}
	
	//결과값 담기
	public void countPagingList(List<?>resultList, int totalCount) {
		this.resultList = resultList;
		this.totalCount = totalCount;
	
	}

}
