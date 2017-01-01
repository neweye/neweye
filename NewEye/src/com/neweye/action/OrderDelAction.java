package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.OrderVO;

public class OrderDelAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = "orderDetail.ne?oseq="+request.getParameter("oseq");
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOseq(Integer.parseInt(request.getParameter("oseq")));
		/*
		1 : 입금대기
		2 : 입금확인
		3 : 배송중
		4 : 배송완료
		5 : 주문취소
		6 : 반품중
		7 : 환불완료
		*/
		if(Integer.parseInt(request.getParameter("result"))<3){
			//주문취소
			orderVO.setResult("5");
		}else if(Integer.parseInt(request.getParameter("result"))<5){
			//반품중
			orderVO.setResult("6");
			orderVO.setDeliback(request.getParameter("deliveryBack")); //택배사
			orderVO.setDelibacknum(request.getParameter("deliveryBackNum")); //운송장번호
			orderVO.setPayback(request.getParameter("payback")); //환불계좌
		}
		OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
		try {
			orderDAO.updateOrderResult(orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

}
