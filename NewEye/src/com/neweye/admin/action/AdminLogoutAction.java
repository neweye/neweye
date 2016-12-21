package com.neweye.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.action.Action;

public class AdminLogoutAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url="adminLoginForm.ne";
    
    HttpSession session=request.getSession(false);
    if(session!=null){
      session.invalidate();
      request.setAttribute("message", "");
    }    
    
    return url;
  }
}
