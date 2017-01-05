package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.neweye.dto.OrderVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.OrderDAO;
import co.kr.neweye.ibatis.OrderDAO_iBatis;



@Controller
@RequestMapping("/admin")
public class AdminOrderController {
	
	  @RequestMapping("/adminOrderList")
	  public String adminOrderList(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/order/orderList";
	    String key = "";
	    if (request.getParameter("key") != null) {
	      key = request.getParameter("key");
	    }

	    /*OrderDAO orderDAO = OrderDAO_JDBC.getInstance();*/
	    OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
	    ArrayList<OrderVO> orderList=null;
		try {
			orderList = orderDAO.listOrder(key);
		} catch (SQLException e) {	
			e.printStackTrace();
		}

	    request.setAttribute("orderList", orderList);

	    return url;
	  }
	  
	  @RequestMapping("/adminOrderDetail")
	  public String adminOrderDetail(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String url = "admin/order/orderDetail";

			int oseq = Integer.parseInt(request.getParameter("oseq"));
			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			ArrayList<OrderVO> orderList = null;
			try {
				orderList = orderDAO.listOrderByOseq(oseq);
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

}
