package com.neweye.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	
	private String[] uri = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		String names = config.getInitParameter("uri");
		StringTokenizer st = new StringTokenizer(names, ", ");
		uri = new String[st.countTokens()];

		for (int i = 0; st.hasMoreTokens(); i++) {
			uri[i] = st.nextToken();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);

		HttpServletRequest req = (HttpServletRequest) request;

		boolean login = false;
		if(includeUri(req)){
			if (session != null) {
				if (session.getAttribute("loginUser") != null) {
					login = true;
				}
			}
			if (login) {
				chain.doFilter(request, response);
			} else {
				System.out.println("-----다른곳으로-----");
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
				dispatcher.forward(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
		
	}

	private boolean includeUri(HttpServletRequest request) {
		String requestUri = request.getRequestURI().toString().trim().toLowerCase();
		
		boolean result = false;
		
		for (int i = 0; i < uri.length; i++) {	
			if (requestUri.contains((uri[i]))) {
				return true;
			}
		}
		return result;
	}

	@Override
	public void destroy() {
	}
}
