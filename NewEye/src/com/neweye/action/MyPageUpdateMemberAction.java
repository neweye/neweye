package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.MemberDAO;
import com.neweye.dao.iBatis.MemberDAO_iBatis;
import com.neweye.dto.MemberVO;

public class MyPageUpdateMemberAction implements Action {
   @Override
   public String execute(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String url = "/mypage/myPageForm.jsp";
      String message = "fail";
      MemberVO member = new MemberVO();
      member.setId(request.getParameter("id").trim());
      member.setPassword(request.getParameter("password"));
      member.setEmail(request.getParameter("email"));
      member.setAddress(request.getParameter("address"));
      member.setName(request.getParameter("name"));
      member.setPhone(request.getParameter("phone"));
      member.setZipNum(request.getParameter("zipNum"));
      
      //String id = request.getParameter("id").trim();
            
      MemberDAO memberDAO=MemberDAO_iBatis.getInstance();
      try {
         memberDAO.updateMember(member);
         message="succes";
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      request.setAttribute("message", message);   

      return url;
   }
}