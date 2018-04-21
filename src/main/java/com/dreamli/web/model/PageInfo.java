package com.dreamli.web.model;

import java.util.List;

import com.dreamli.domain.Customer;

public class PageInfo {
	private int currentPage;// 当前页
	private int prePage; // 上一页
	private int nextPage;// 下一页
	private int firstPage;// 分页栏显示的第一个页码
	private int lastPage;// 分页栏显示的最后一个页码
	private int pageRows;// 每页显示多少行
	private int rowCount;// 总共有多少个客户
	private int pageCount;// 总共有多少页
	private List<Customer> pageCusts;// 当前页面显示的客户

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public List<Customer> getPageCusts() {
		return pageCusts;
	}

	public void setPageCusts(List<Customer> pageCusts) {
		this.pageCusts = pageCusts;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", prePage=" + prePage + ", nextPage=" + nextPage
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", pageRows=" + pageRows + ", rowCount="
				+ rowCount + ", pageCount=" + pageCount + ", pageCusts=" + pageCusts + "]";
	}
}
