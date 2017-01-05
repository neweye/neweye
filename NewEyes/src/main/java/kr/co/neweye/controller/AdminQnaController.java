package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.neweye.dto.QnaVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.QnaDAO;
import co.kr.neweye.ibatis.QnaDAO_iBatis;




@Controller
@RequestMapping("/admin")
public class AdminQnaController {
	
	@RequestMapping("/adminQnaList")
	  public String adminQnaList(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/qna/qnaList";
	    
	    /*QnaDAO qnaDAO = QnaDAO_JDBC.getInstance();*/
	    QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
	    ArrayList<QnaVO> qnaList=null;
		try {
			qnaList = qnaDAO.listAllQna();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    request.setAttribute("qnaList", qnaList);

	    return url;
	  }
	
	@RequestMapping("/adminQnaDetail")
	  public String adminQnaDetail(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  
		//request.setCharacterEncoding("utf-8");
		  
	    String url = "admin/qna/qnaDetail";

	    String qseq = request.getParameter("qseq").trim();

	    /*QnaDAO qnaDAO = QnaDAO_JDBC.getInstance();*/
	    QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
	    QnaVO qnaVO=null;
	   try {
	      qnaVO = qnaDAO.getQna(Integer.parseInt(qseq));
	   } catch (NumberFormatException e) {
	      e.printStackTrace();
	   } catch (SQLException e) {
	      e.printStackTrace();
	   }

	    request.setAttribute("qnaVO", qnaVO);
	        
	    return url;
	  }
	
	@RequestMapping("/adminQnaRepsave")
	public String adminQnaResave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url = "redirect:adminQnaList";
//		String url = "adminQnaList";
		
		System.out.println("1111");
		String qseq = request.getParameter("qseq").trim();
		System.out.println("22222");
		String reply = request.getParameter("reply"); //여기서 에러
		System.out.println("33333");
		System.out.println("테스트:"+request.getParameter(reply));

		QnaVO qnaVO = new QnaVO();
		qnaVO.setQseq(Integer.parseInt(qseq));
		qnaVO.setReply(reply);

		/* QnaDAO qnaDAO = QnaDAO_JDBC.getInstance(); */
		QnaDAO qnaDAO = QnaDAO_iBatis.getInstance();
		try {
			qnaDAO.updateQna(qnaVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}

}
