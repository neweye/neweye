package com.neweye.dto;

public class DetailSearchVO {
	private String column;
	private String orderby;
	private int min;
	private int max;
	
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
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	@Override
	public String toString() {
		return "DetailSearchVO [column=" + column + ", orderby=" + orderby
				+ ", min=" + min + ", max=" + max + "]";
	}
	
	
	
	
	
	
}
