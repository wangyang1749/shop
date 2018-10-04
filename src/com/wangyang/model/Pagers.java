package com.wangyang.model;

import java.util.List;

public class Pagers<E> {
	//�ڼ�ҳ
	private int pageIndex;
	//ÿҳ��ʾ������
	private int pageSize;
	//��ҳ�Ŀ�ʼ
	private int pageOffset;
	//�ܹ��ж�������¼
	private int totalRecord;
	//һ������ҳ
	private int totalPage;
	
	private List<E> list;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}
	
	
}
