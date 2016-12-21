package com.neweye.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	public static void goURI(String uri,HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		if (uri.contains("redirect:")){
			uri=uri.substring(9);
			response.sendRedirect(uri);
		}else{
			request.getRequestDispatcher(uri).forward(request, response);
			
		}
	}
}
