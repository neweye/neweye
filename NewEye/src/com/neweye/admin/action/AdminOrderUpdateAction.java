package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.action.Action;
import com.neweye.dao.OrderDAO;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dto.OrderVO;

public class AdminOrderUpdateAction implements Action {
	/*@Override
	public String adminOrderUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = "adminOrderDetail.ne?oseq="+request.getParameter("oseq");
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOseq(Integer.parseInt(request.getParameter("oseq")));
		
		if(request.getParameter("result")!=null && !request.getParameter("result").isEmpty()) 
			orderVO.setResult(request.getParameter("result"));
		if(request.getParameter("payyn")!=null && !request.getParameter("payyn").isEmpty()) 
			orderVO.setPayyn(request.getParameter("payyn"));
		if(request.getParameter("delivery")!=null && !request.getParameter("delivery").isEmpty()) 
			orderVO.setDelivery(request.getParameter("delivery"));
		if(request.getParameter("deliverynum")!=null && !request.getParameter("deliverynum").isEmpty()) 
			orderVO.setDeliverynum(request.getParameter("deliverynum"));
		if(request.getParameter("mname")!=null && !request.getParameter("mname").isEmpty()) 
			orderVO.setMname(request.getParameter("mname"));
		if(request.getParameter("zipnum")!=null && !request.getParameter("zipnum").isEmpty()) 
			orderVO.setZipNum(request.getParameter("zipnum"));
		if(request.getParameter("address")!=null && !request.getParameter("address").isEmpty()) 
			orderVO.setAddress(request.getParameter("address"));
		if(request.getParameter("phone")!=null && !request.getParameter("phone").isEmpty()) 
			orderVO.setPhone(request.getParameter("phone"));
		if(request.getParameter("sname")!=null && !request.getParameter("sname").isEmpty()) 
			orderVO.setSname(request.getParameter("sname"));
		if(request.getParameter("sphone")!=null && !request.getParameter("sphone").isEmpty()) 
			orderVO.setSphone(request.getParameter("sphone"));

		OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
		try {
			orderDAO.updateOrderAdmin(orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}*/

}
