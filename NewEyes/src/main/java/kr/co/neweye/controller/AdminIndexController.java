package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.WorkerDAO;
import co.kr.neweye.ibatis.WorkerDAO_iBatis;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

	@RequestMapping("/adminLoginForm")
	public String adminIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/main";
		return url;
	}

	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "redirect:adminLoginForm";
		String msg = "";
		String workerId = request.getParameter("workerId").trim();
		String workerPassword = request.getParameter("workerPassword").trim();

		WorkerDAO workerDAO = WorkerDAO_iBatis.getInstance();

		int result = -1;
		try {
			result = workerDAO.workerCheck(workerId, workerPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (result == 1) {// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("workerId", workerId);
			url = "redirect:adminOrderList"; // /////////////////로긴 후 넘어갈 곳 주소
		} else if (result == 0) {
			msg = "비밀번호를 확인하세요.";
		} else if (result == -1) {
			msg = "아이디를 확인하세요.";
		}
		request.setAttribute("message", msg);
		return url;
	}

	@RequestMapping("/index")
	public String index() {
		return "admin/index";
	}

	@RequestMapping("/adminLogout")
	public String adminLogout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "redirect:/index";

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			request.setAttribute("message", "");
		}
		
		return url;
	}
}
