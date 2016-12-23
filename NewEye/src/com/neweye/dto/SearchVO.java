package com.neweye.dto;

public class SearchVO {
	private String column;
	private String orderby;
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	@Override
	public String toString() {
		return "SearchVO [column=" + column + ", orderby=" + orderby + "]";
	}
	
}
