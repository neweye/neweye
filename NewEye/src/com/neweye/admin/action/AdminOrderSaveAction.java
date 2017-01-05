package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.OrderDAO;
import com.neweye.dto.OrderVO;

public class AdminOrderSaveAction implements Action {

	/*@Override
	public String adminOrderSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "adminOrderList.ne";

		String[] resultArr = request.getParameterValues("result");
		String[] codeArr = request.getParameterValues("code");
		
		
		
		for (int i = 0; i < resultArr.length; i++) {
			
			OrderVO orderVO = new OrderVO();
			orderVO.setOdseq(Integer.parseInt(codeArr[i]));
			orderVO.setResult(resultArr[i]);
			
			OrderDAO orderDAO = OrderDAO_JDBC.getInstance();
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			try {
				orderDAO.updateOrderResult(orderVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return url;
	}*/
}
