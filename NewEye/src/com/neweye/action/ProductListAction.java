package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;
import com.neweye.dto.SearchVO;

public class ProductListAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "product/product_list.jsp";
		
		SearchVO searchVO = new SearchVO();
		searchVO.setOrderby("desc");
		searchVO.setColumn("indate");
		
		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		
		ArrayList<ProductVO> productList = null;
		try {
			productList = productDAO.listSelProduct(searchVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("productKindList", productList);

		return url;
	}
}
