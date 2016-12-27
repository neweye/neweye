package com.neweye.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;

public class ProductKindAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "product/product_list.jsp";

		// String kind = request.getParameter("kind").trim();

		String kind = "5";

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		ArrayList<ProductVO> productKindList = null;
		try {
			productKindList = productDAO.listKindProduct(1,kind);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("productKindList", productKindList);

		return url;

	}

	

}
