package kr.co.neweye.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Action;

import kr.co.neweye.dto.ProductVO;
import kr.co.neweye.dto.SearchVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.neweye.dao.ProductDAO;
import co.kr.neweye.ibatis.ProductDAO_iBatis;

@Controller
public class IndexController{

	@RequestMapping(value = "/")
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "index";

		 /*데이터베이스에서 상품 정보를 얻어오는 비지니스로직 */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		
		ProductController list = new ProductController();
		
		//신상품
		SearchVO searchNew = list.insertSearch();
		searchNew.setOrderby("desc");
		
		//베스트
		SearchVO searchBest = list.insertSearch();
		searchBest.setColumn("read_count");
		
		ArrayList<ProductVO> newProductList=null;
		ArrayList<ProductVO> bestProductList =null;
		try {
			newProductList = productDAO.listSelProduct(searchNew);
			bestProductList = productDAO.listSelProduct(searchBest);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		return url;
	}
	@RequestMapping("/index")
	public String toIndex(){
		String url="redirect:/";
		return url;
	}

}
