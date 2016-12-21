package com.neweye.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.action.Action;

public class AdminIndexAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = request.getContextPath()+"/admin/main.jsp";  
     
    return url;
  }
}
