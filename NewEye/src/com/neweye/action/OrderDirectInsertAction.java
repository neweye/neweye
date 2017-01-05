package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.CartDAO;
import com.neweye.dao.OrderDAO;
import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.CartDAO_iBatis;
import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.CartVO;
import com.neweye.dto.MemberVO;
import com.neweye.dto.ProductVO;

public class OrderDirectInsertAction implements Action {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderInsert.jsp";
		
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		
		ProductDAO productDAO=ProductDAO_iBatis.getInstance();
		ProductVO productVO=null;
		CartVO cartVO = new CartVO();
		
		try {
			productVO= productDAO.getProduct(request.getParameter("pseq"));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		cartVO.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		cartVO.setPseq(productVO.getPseq());
		cartVO.setPname(productVO.getName());
		cartVO.setPrice(productVO.getPrice());
		cartVO.setIndate(new Timestamp(System.currentTimeMillis()));
		cartList.add(cartVO);
		
		request.setAttribute("totalPrice", cartVO.getPrice());
		request.setAttribute("cartList", cartList);
		
		return url;
	}*/
}
