package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.ProductDAO;
import com.neweye.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {

 /* @Override
  public String adminProductUpdateForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "product/productUpdate.jsp";

    String pseq = request.getParameter("pseq").trim();

    ProductDAO productDAO = ProductDAO_JDBC.getInstance();
    ProductDAO productDAO = ProductDAO_iBatis.getInstance();
    ProductVO productVO=null;
	try {
		productVO = productDAO.getProduct(pseq);
	} catch (SQLException e) {
		e.printStackTrace();
	}

    request.setAttribute("productVO", productVO);

    // 상품 리스트(product_list.jsp) 페이지에서 쿼리 스트링으로 넘겨준 현재 페이지를 얻어온다.
    String tpage = "1";
    if (request.getParameter("tpage") != null) {
      tpage = request.getParameter("tpage");
    }
    request.setAttribute("tpage", tpage);
    
    String kindList[] = { "DSLR", "LENDS", "ACCESSORY"};    
    request.setAttribute("kindList", kindList);
    
    return url;
  }*/
}
