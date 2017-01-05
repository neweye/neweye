package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.neweye.dto.ProductVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.ProductDAO;
import co.kr.neweye.ibatis.ProductDAO_iBatis;



@Controller
public class AdminProductController {

	
	
	@RequestMapping("/adminProductList")
	  public String adminProductList(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    //String url = "product/productList";
		String url = "redirect:productList";
		
	    String key=request.getParameter("key");
	    String tpage=request.getParameter("tpage");
	    if(key==null){
	     key="";
	    }    
	    if(tpage== null){
	      tpage="1"; //현재 페이지 (default 1)                        
	    }else if(tpage.equals("")){
	       tpage="1";  
	    }
	    request.setAttribute("key", key);
	    request.setAttribute("tpage",tpage);
	    
	    /*ProductDAO productDAO=ProductDAO_JDBC.getInstance();*/
	    ProductDAO productDAO=ProductDAO_iBatis.getInstance();   
	    
	    ArrayList<ProductVO> productList=null;
	    String paging=null;
		try {
			productList=productDAO.listProduct(Integer.parseInt(tpage), key);
			paging = productDAO.pageNumber(Integer.parseInt(tpage), key);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    request.setAttribute("productList",productList);
	    int n=productList.size();   
	    request.setAttribute("productListSize",n); 
	    request.setAttribute("paging", paging);   
	    
	    return url;
	  }
	
}
