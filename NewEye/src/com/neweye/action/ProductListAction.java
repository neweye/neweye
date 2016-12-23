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

		if (request.getParameter("category") != null) {
			category(request, response);
		} else if (request.getParameter("kind") != null) {
			kind(request, response);
		} else {
			all(request, response);
		}
		return url;
	}

	private void all(HttpServletRequest request, HttpServletResponse response) {

		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);

		SearchVO searchVO = new SearchVO();
		searchVO.setOrderby("desc");
		searchVO.setColumn("indate");

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();

		ArrayList<ProductVO> productList = null;
		String paging = null;

		try {
			productList = productDAO.listSelProduct(searchVO);
			paging = productDAO.pageNumber(Integer.parseInt(tpage), key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productList);
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
	}

	private void kind(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind").trim();

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		ArrayList<ProductVO> productKindList = null;
		try {
			productKindList = productDAO.listKindProduct(kind);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productKindList);

	}

	private void category(HttpServletRequest request,
			HttpServletResponse response) {
		String category = request.getParameter("category").trim().toUpperCase();
		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		ArrayList<ProductVO> productKindList = null;
		try {
			productKindList = productDAO.listCategoryProduct(category);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productKindList);
	}
}
