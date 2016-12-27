package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;
import com.neweye.dto.SearchVO;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/index.jsp";

		/* 데이터베이스에서 상품 정보를 얻어오는 비지니스로직 */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		
		//신상품
		SearchVO searchNew = new SearchVO();
		searchNew.setOrderby("desc");
		searchNew.setColumn("indate");
		
		//베스트
		SearchVO searchBest = new SearchVO();
		searchBest.setOrderby("desc");
		searchBest.setColumn("read_count");
		
		ArrayList<ProductVO> newProductList=null;
		ArrayList<ProductVO> bestProductList =null;
		try {
			newProductList = productDAO.listSelProduct(1,searchNew);
			bestProductList = productDAO.listSelProduct(1,searchBest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		return url;
	}

}



