package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="product/product_detail.jsp";
		
		String pseq=request.getParameter("pseq").trim();
		
		/*ProductDAO productDAO=ProductDAO_JDBC.getInstance();*/
		ProductDAO productDAO=ProductDAO_iBatis.getInstance();
		ProductVO productVO=null;
		HttpSession session = request.getSession();
		try {
			//productDAO.increaseReadCount(pseq);//////////////
			productVO= productDAO.getProduct(pseq);
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		request.setAttribute("productVO", productVO);
		
		return url;
	}
	
	
	/*
	
	// ////////////////////////////////////////////////////////////////
		private ProductVO selectArticle(int pseq, boolean increaseCount)
				throws SQLException {
			ProductVO productVO = ProductDAO.selectById(product);
			if (productVO == null) {
				throw new Exception("상품 없음: " + pseq);
			}
			if (increaseCount) {
				productVO.increaseReadCount(pseq);
				productVO.setReadCount(productVO.getReadCount() + 1);
			}
		}
	
	
	*/

}
