package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.CartVO;
import kr.co.neweye.dto.MemberVO;
import kr.co.neweye.dto.OrderVO;
import kr.co.neweye.dto.ProductVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.CartDAO;
import co.kr.neweye.dao.OrderDAO;
import co.kr.neweye.dao.ProductDAO;
import co.kr.neweye.ibatis.CartDAO_iBatis;
import co.kr.neweye.ibatis.OrderDAO_iBatis;
import co.kr.neweye.ibatis.ProductDAO_iBatis;



@Controller
public class OrderController {

	@RequestMapping("/orderAll")
	public String orderAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

			try {
				ArrayList<Integer> oseqList = orderDAO.selectSeqOrderTotal(loginUser.getId());
				for (int oseq : oseqList) {
					ArrayList<OrderVO> orderListIng = orderDAO.listOrderById(loginUser.getId(), "%", oseq);

					OrderVO orderVO = orderListIng.get(0);
					orderVO.setPname(orderVO.getPname() + " 외 " + orderListIng.size() + "건");

					int totalPrice = 0;
					for (OrderVO ovo : orderListIng) {
						totalPrice += ovo.getPrice() * ovo.getQuantity();
					}
					orderVO.setPrice(totalPrice);
					orderList.add(orderVO);
				}
				request.setAttribute("title", "총 주문 내역");
				request.setAttribute("orderList", orderList);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		return url;
	}
	
	@RequestMapping("/orderInsert")
	public String orderInsert(HttpServletRequest request,
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
	
	@RequestMapping("/orderDirectInsert")
	public String orderDirectInsert(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderInsert";
		
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
	}
	
	
	
	
	
	
	
	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderDetail";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			ArrayList<OrderVO> orderList = null;
			try {
				orderList = orderDAO.listOrderById(loginUser.getId(), "%", oseq);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			int totalPrice = 0;
			for (OrderVO ovo : orderList) {
				totalPrice += ovo.getPrice() * ovo.getQuantity();
			}
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
		
		return url;
	}
	
	
	@RequestMapping("/orderDelete")
	public String orderDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = "redirect:orderDetail?oseq="+request.getParameter("oseq");
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOseq(Integer.parseInt(request.getParameter("oseq")));
		/*
		1 : 입금대기
		2 : 입금확인
		3 : 배송중
		4 : 배송완료
		5 : 주문취소
		6 : 반품중
		7 : 환불완료
		*/
		if(Integer.parseInt(request.getParameter("result"))<3){
			//주문취소
			orderVO.setResult("5");
		}else if(Integer.parseInt(request.getParameter("result"))<5){
			//반품중
			orderVO.setResult("6");
			orderVO.setDeliback(request.getParameter("deliveryBack")); //택배사
			orderVO.setDelibacknum(request.getParameter("deliveryBackNum")); //운송장번호
			orderVO.setPayback(request.getParameter("payback")); //환불계좌
		}
		OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
		try {
			orderDAO.updateOrderResult(orderVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	
	
	
	
}
