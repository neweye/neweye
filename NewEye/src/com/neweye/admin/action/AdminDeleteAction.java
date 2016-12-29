package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.action.Action;
import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;

public class AdminDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "adminProductList.ne";
		
		ProductVO productVO = new ProductVO();
		
		
		productVO.setPseq(Integer.parseInt(request.getParameter("pseq")));
		productVO.setKind("0");
		
		
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		
		try {
			productDAO.deleteProduct(productVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return url;
	}

}
