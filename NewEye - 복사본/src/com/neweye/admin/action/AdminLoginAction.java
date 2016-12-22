package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.action.Action;
import com.neweye.dao.WorkerDAO;
import com.neweye.dao.iBatis.WorkerDAO_iBatis;

public class AdminLoginAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "adminLoginForm.ne";
    String msg = "";
    String workerId = request.getParameter("workerId").trim();
    String workerPassword = request.getParameter("workerPassword").trim();

    WorkerDAO workerDAO = WorkerDAO_iBatis.getInstance();

    int result=-1;
	try {
		result = workerDAO.workerCheck(workerId, workerPassword);
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    if (result == 1) {// 로그인 성공
      HttpSession session = request.getSession();
      session.setAttribute("workerId", workerId);
      url = "adminProductList.ne";
    } else if (result == 0) {
      msg = "비밀번호를 확인하세요.";
    } else if (result == -1) {
      msg = "아이디를 확인하세요.";
    }
    request.setAttribute("message", msg);
    return url;
  }
}
