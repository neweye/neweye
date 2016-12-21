package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.iBatis.OrderDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.OrderDAO;

public class AdminOrderSaveAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String url = "adminOrderList.ne";
      
      String[] resultArr = request.getParameterValues("result");
      
      for(String oseq:resultArr){
        /*OrderDAO orderDAO = OrderDAO_JDBC.getInstance();*/
        OrderDAO orderDAO = OrderDAO_iBatis.getInstance();
        try {
			orderDAO.updateOrderResult(oseq);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
      }
      return url;
    }
}
