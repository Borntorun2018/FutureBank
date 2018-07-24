package com.eBusiness.pagination;

import java.io.Serializable;

public class Pagination implements Serializable{
	
	private static final long serialVersionUID = -7888619177798444712L;
	
	private  Integer numPerPage;
	private  Integer currentPage;
	//private  String sort;
	private  String sortKey;
	private boolean reverse;
	
	public boolean isReverse() {
		return reverse;
	}
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
	public String getSortKey() {
		return sortKey;
	}
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}
	/**
    public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	**/
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}
}
