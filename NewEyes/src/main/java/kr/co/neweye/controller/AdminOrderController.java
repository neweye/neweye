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
	  
	   @RequestMapping("/adminOrderUpdate")
		public String adminOrderUpdate(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String url = "redirect:adminOrderDetail?oseq="+request.getParameter("oseq");
			
			OrderVO orderVO = new OrderVO();
			orderVO.setOseq(Integer.parseInt(request.getParameter("oseq")));
			
			if(request.getParameter("result")!=null && !request.getParameter("result").isEmpty()) 
				orderVO.setResult(request.getParameter("result"));
			if(request.getParameter("payyn")!=null && !request.getParameter("payyn").isEmpty()) 
				orderVO.setPayyn(request.getParameter("payyn"));
			if(request.getParameter("delivery")!=null && !request.getParameter("delivery").isEmpty()) 
				orderVO.setDelivery(request.getParameter("delivery"));
			if(request.getParameter("deliverynum")!=null && !request.getParameter("deliverynum").isEmpty()) 
				orderVO.setDeliverynum(request.getParameter("deliverynum"));
			if(request.getParameter("mname")!=null && !request.getParameter("mname").isEmpty()) 
				orderVO.setMname(request.getParameter("mname"));
			if(request.getParameter("zipnum")!=null && !request.getParameter("zipnum").isEmpty()) 
				orderVO.setZipNum(request.getParameter("zipnum"));
			if(request.getParameter("address")!=null && !request.getParameter("address").isEmpty()) 
				orderVO.setAddress(request.getParameter("address"));
			if(request.getParameter("phone")!=null && !request.getParameter("phone").isEmpty()) 
				orderVO.setPhone(request.getParameter("phone"));
			if(request.getParameter("sname")!=null && !request.getParameter("sname").isEmpty()) 
				orderVO.setSname(request.getParameter("sname"));
			if(request.getParameter("sphone")!=null && !request.getParameter("sphone").isEmpty()) 
				orderVO.setSphone(request.getParameter("sphone"));

			OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
			try {
				orderDAO.updateOrderAdmin(orderVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return url;
		}
	   
	   @RequestMapping("/adminOrderSave")
		public String adminOrderSave(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String url = "redirect:adminOrderList";

			String[] resultArr = request.getParameterValues("result");
			String[] codeArr = request.getParameterValues("code");
			
			
			
			for (int i = 0; i < resultArr.length; i++) {
				
				OrderVO orderVO = new OrderVO();
				orderVO.setOdseq(Integer.parseInt(codeArr[i]));
				orderVO.setResult(resultArr[i]);
				
				/*OrderDAO orderDAO = OrderDAO_JDBC.getInstance();*/
				OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
				try {
					orderDAO.updateOrderResult(orderVO);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return url;
		}
	   
	   @RequestMapping("/adminOrderSearch")
		public String adminOrderSearch(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String url = "admin/order/orderList";
			String key = request.getParameter("key");
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

}
