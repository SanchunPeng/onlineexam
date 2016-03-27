package cn.zjlg.onlineexam.student.domain;

import java.util.List;


public class PageBean<T> {
	private int page;//当前页码
	//private int totalPages;//总页数，可由计算得出
	private int totalRecord;//总记录数
	private int rows;//每页记录数
	private List<T> beanList;//当前页的记录
	private String url;//它就是URL后的条件
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * 计算总页数
	 */
	public int getTotalPages() {
		int totalPages=totalRecord/page;
		return totalRecord%page==0 ? totalPages:totalPages+1;
	}
//	public void setTotalPages(int totalPages) {
//		this.totalPages = totalPages;
//	}
	

	

}
