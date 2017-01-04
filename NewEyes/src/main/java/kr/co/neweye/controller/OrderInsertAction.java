package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.neweye.dto.CartVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.CartDAO;
import co.kr.neweye.ibatis.CartDAO_iBatis;



@Controller
public class OrderInsertAction {

	@RequestMapping("/orderInsert")
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderInsert";

		CartDAO cartDAO = CartDAO_iBatis.getInstance();
		String[] cseqArr = request.getParameterValues("cseq");
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		int totalPrice = 0;
		try {
			for (String cseq : cseqArr) {
				CartVO cartVO = cartDAO.getCart(cseq);
				cartList.add(cartVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (CartVO c : cartList) {
			totalPrice += c.getPrice() * c.getQuantity();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartList", cartList);
		
		return url;
	}
}
