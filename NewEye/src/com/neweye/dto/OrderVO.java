package com.neweye.dto;

import java.sql.Timestamp;

public class OrderVO {
	private int odseq; // 시퀀스
	private int oseq; // 주문번호 - orders
	private Timestamp indate; // 주문날짜 - orders
	private String id; // 주문 아이디 - orders
	private int pseq; // 상품번호
	private String pname; // 상품이름
	private int quantity; // 수량
	private int price; // 가격
	private String result; // 진행상황
	
	private String name; // 주문한 사람 이름
	
	private String mname; // 받는 사람 이름
	private String zipNum; // 받는 사람 우편번호
	private String address; // 받는 사람 주소
	private String phone; // 받는 사람 연락처

	private String sname; // 보내는 사람 이름
	private String sphone; // 보내는 사람 연락처

	private String pay; // 지불방법
	private String payyn; // 지불여부
	private String delivery; // 택배사
	private String deliverynum; // 운송장번호
	private String deliback; // 반송 택배사
	private String delibacknum; // 반송 운송장
	private String payback; // 환불계좌

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getPayyn() {
		return payyn;
	}

	public void setPayyn(String payyn) {
		this.payyn = payyn;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDeliverynum() {
		return deliverynum;
	}

	public void setDeliverynum(String deliverynum) {
		this.deliverynum = deliverynum;
	}

	public String getDeliback() {
		return deliback;
	}

	public void setDeliback(String deliback) {
		this.deliback = deliback;
	}

	public String getDelibacknum() {
		return delibacknum;
	}

	public void setDelibacknum(String delibacknum) {
		this.delibacknum = delibacknum;
	}

	public String getPayback() {
		return payback;
	}

	public void setPayback(String payback) {
		this.payback = payback;
	}

	public int getOdseq() {
		return odseq;
	}

	public void setOdseq(int odseq) {
		this.odseq = odseq;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOseq() {
		return oseq;
	}

	public void setOseq(int oseq) {
		this.oseq = oseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getZipNum() {
		return zipNum;
	}

	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getIndate() {
		return indate;
	}

	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "OrderVO [odseq=" + odseq + ", oseq=" + oseq + ", indate="
				+ indate + ", id=" + id + ", pseq=" + pseq + ", pname=" + pname
				+ ", quantity=" + quantity + ", price=" + price + ", result="
				+ result + ", name=" + name + ", mname=" + mname + ", zipNum="
				+ zipNum + ", address=" + address + ", phone=" + phone
				+ ", sname=" + sname + ", sphone=" + sphone + ", pay=" + pay
				+ ", payyn=" + payyn + ", delivery=" + delivery
				+ ", deliverynum=" + deliverynum + ", deliback=" + deliback
				+ ", delibacknum=" + delibacknum + ", payback=" + payback + "]";
	}
}
