package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.ProductVO;
import kr.co.neweye.dto.SearchVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.ProductDAO;
import co.kr.neweye.ibatis.ProductDAO_iBatis;

@Controller
public class ProductController {
	
	
	
	// ProductList
	@RequestMapping("/product")
	public String productList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "product/product_list";
		
		SearchVO searchVO = insertSearch();
		searchVO = updateSearch(searchVO, request);
		
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		
		ArrayList<ProductVO> productList = null;
		String paging = null;

		try {
			productList = productDAO.listSelProduct(searchVO);
			paging = productDAO.pageNum(searchVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productList", productList);
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
		request.setAttribute("order", searchVO.getColumn());
		
		return url;
	}

	protected SearchVO insertSearch() {
		SearchVO search = new SearchVO();

		search.setColumn("pseq");
		search.setOrderby("desc");
		search.setTpage("1");

		search.setKind("");
		search.setCategory("");
		search.setName("");
		search.setUseyn("");
		search.setRatio("");
		search.setFormat("");
		search.setZoomyn("");
		search.setFunctions("");
		search.setTypes("");

		search.setMin_price(0);
		search.setMin_weight(0);
		search.setMin_pixel(0);
		search.setMin_iso(0);
		search.setMin_speed(0);
		search.setMin_screen(0);
		search.setMin_movframe(0);
		search.setMin_seqpictures(0);
		search.setMin_filter(0);
		search.setMin_minfocus(0);
		search.setMin_maxfocus(0);
		search.setMin_minaperture(0);
		search.setMin_maxaperture(0);
		search.setMin_distance(0);
		search.setMax_price(999999999);
		search.setMax_weight(999999999);
		search.setMax_pixel(999999999);
		search.setMax_iso(999999999);
		search.setMax_speed(999999999);
		search.setMax_screen(999999999);
		search.setMax_movframe(999999999);
		search.setMax_seqpictures(999999999);
		search.setMax_filter(999999999);
		search.setMax_minfocus(999999999);
		search.setMax_maxfocus(999999999);
		search.setMax_minaperture(999999999);
		search.setMax_maxaperture(999999999);
		search.setMax_distance(999999999);

		return search;
	}
	private SearchVO updateSearch(SearchVO search, HttpServletRequest request) {
		if (request.getParameter("column") != null && !request.getParameter("column").isEmpty())
		search.setColumn(request.getParameter("column"));
		if (request.getParameter("orderby") != null && !request.getParameter("orderby").isEmpty())
		search.setOrderby(request.getParameter("orderby"));
		if (request.getParameter("tpage") != null && !request.getParameter("tpage").isEmpty())
		search.setTpage(request.getParameter("tpage"));
		
		if (request.getParameter("kind") != null && !request.getParameter("kind").isEmpty())
		search.setKind(request.getParameter("kind"));
		if (request.getParameter("category") != null && !request.getParameter("category").isEmpty())
		search.setCategory(request.getParameter("category"));
		if (request.getParameter("name") != null && !request.getParameter("name").isEmpty())
			search.setName(request.getParameter("name"));
		if (request.getParameter("useyn") != null && !request.getParameter("useyn").isEmpty())
		search.setUseyn(request.getParameter("useyn"));
		if (request.getParameter("ratio") != null && !request.getParameter("ratio").isEmpty())
		search.setRatio(request.getParameter("ratio"));
		if (request.getParameter("format") != null && !request.getParameter("format").isEmpty())
		search.setFormat(request.getParameter("format"));
		if (request.getParameter("zoomyn") != null && !request.getParameter("zoomyn").isEmpty())
		search.setZoomyn(request.getParameter("zoomyn"));
		if (request.getParameter("functions") != null && !request.getParameter("functions").isEmpty())
		search.setFunctions(request.getParameter("functions"));
		if (request.getParameter("types") != null && !request.getParameter("types").isEmpty())
		search.setTypes(request.getParameter("types"));
		
		if (request.getParameter("min_price") != null && !request.getParameter("min_price").isEmpty())
		search.setMin_price(Integer.parseInt(request.getParameter("min_price")));
		if (request.getParameter("min_weight") != null && !request.getParameter("min_weight").isEmpty())
		search.setMin_weight(Integer.parseInt(request.getParameter("min_weight")));
		if (request.getParameter("min_pixel") != null && !request.getParameter("min_pixel").isEmpty())
		search.setMin_pixel(Integer.parseInt(request.getParameter("min_pixel")));
		if (request.getParameter("min_iso") != null && !request.getParameter("min_iso").isEmpty())
		search.setMin_iso(Integer.parseInt(request.getParameter("min_iso")));
		if (request.getParameter("min_speed") != null && !request.getParameter("min_speed").isEmpty())
		search.setMin_speed(Integer.parseInt(request.getParameter("min_speed")));
		if (request.getParameter("min_movframe") != null && !request.getParameter("min_movframe").isEmpty())
		search.setMin_movframe(Integer.parseInt(request.getParameter("min_movframe")));
		if (request.getParameter("min_seqpictures") != null && !request.getParameter("min_seqpictures").isEmpty())
		search.setMin_seqpictures(Integer.parseInt(request.getParameter("min_seqpictures")));
		if (request.getParameter("min_filter") != null && !request.getParameter("min_filter").isEmpty())
		search.setMin_filter(Integer.parseInt(request.getParameter("min_filter")));
		if (request.getParameter("min_screen") != null && !request.getParameter("min_screen").isEmpty())
		search.setMin_screen(Float.parseFloat(request.getParameter("min_screen")));
		if (request.getParameter("min_minfocus") != null && !request.getParameter("min_minfocus").isEmpty())
		search.setMin_minfocus(Float.parseFloat(request.getParameter("min_minfocus")));
		if (request.getParameter("min_maxfocus") != null && !request.getParameter("min_maxfocus").isEmpty())
		search.setMin_maxfocus(Float.parseFloat(request.getParameter("min_maxfocus")));
		if (request.getParameter("min_minaperture") != null && !request.getParameter("min_minaperture").isEmpty())
		search.setMin_minaperture(Float.parseFloat(request.getParameter("min_minaperture")));
		if (request.getParameter("min_maxaperture") != null && !request.getParameter("min_maxaperture").isEmpty())
		search.setMin_maxaperture(Float.parseFloat(request.getParameter("min_maxaperture")));
		if (request.getParameter("min_distance") != null && !request.getParameter("min_distance").isEmpty())
		search.setMin_distance(Float.parseFloat(request.getParameter("min_distance")));
		if (request.getParameter("max_price") != null && !request.getParameter("max_price").isEmpty())
		search.setMax_price(Integer.parseInt(request.getParameter("max_price")));
		if (request.getParameter("max_weight") != null && !request.getParameter("max_weight").isEmpty())
		search.setMax_weight(Integer.parseInt(request.getParameter("max_weight")));
		if (request.getParameter("max_pixel") != null && !request.getParameter("max_pixel").isEmpty())
		search.setMax_pixel(Integer.parseInt(request.getParameter("max_pixel")));
		if (request.getParameter("max_iso") != null && !request.getParameter("max_iso").isEmpty())
		search.setMax_iso(Integer.parseInt(request.getParameter("max_iso")));
		if (request.getParameter("max_speed") != null && !request.getParameter("max_speed").isEmpty())
		search.setMax_speed(Integer.parseInt(request.getParameter("max_speed")));
		if (request.getParameter("max_movframe") != null && !request.getParameter("max_movframe").isEmpty())
		search.setMax_movframe(Integer.parseInt(request.getParameter("max_movframe")));
		if (request.getParameter("max_seqpictures") != null && !request.getParameter("max_seqpictures").isEmpty())
		search.setMax_seqpictures(Integer.parseInt(request.getParameter("max_seqpictures")));
		if (request.getParameter("max_filter") != null && !request.getParameter("max_filter").isEmpty())
		search.setMax_filter(Integer.parseInt(request.getParameter("max_filter")));
		if (request.getParameter("max_screen") != null && !request.getParameter("max_screen").isEmpty())
		search.setMax_screen(Float.parseFloat(request.getParameter("max_screen")));
		if (request.getParameter("max_minfocus") != null && !request.getParameter("max_minfocus").isEmpty())
		search.setMax_minfocus(Float.parseFloat(request.getParameter("max_minfocus")));
		if (request.getParameter("max_maxfocus") != null && !request.getParameter("max_maxfocus").isEmpty())
		search.setMax_maxfocus(Float.parseFloat(request.getParameter("max_maxfocus")));
		if (request.getParameter("max_minaperture") != null && !request.getParameter("max_minaperture").isEmpty())
		search.setMax_minaperture(Float.parseFloat(request.getParameter("max_minaperture")));
		if (request.getParameter("max_maxaperture") != null && !request.getParameter("max_maxaperture").isEmpty())
		search.setMax_maxaperture(Float.parseFloat(request.getParameter("max_maxaperture")));
		if (request.getParameter("max_distance") != null && !request.getParameter("max_distance").isEmpty())
		search.setMax_distance(Float.parseFloat(request.getParameter("max_distance")));
		
		return search;
	}
	
	
	// productDetail
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="product/product_detail";
		
		String pseq=request.getParameter("pseq").trim();
		
		ProductDAO productDAO=ProductDAO_iBatis.getInstance();
		ProductVO productVO=null;
		HttpSession session = request.getSession();
		try {
			//productDAO.increaseReadCount(pseq);//////////////
			productVO= productDAO.getProduct(pseq);
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		request.setAttribute("productVO", productVO);
		
		return url;
	}
	
	//productDetailSearch
	@RequestMapping("/ProductDetailSearch")
	public String productDetailSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "product/product_list";

		String name = request.getParameter("name");
		String tpage = request.getParameter("tpage");
		if (name == null) {
			name = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("name", name);
		request.setAttribute("tpage", tpage);

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();

		ArrayList<ProductVO> productList = null;
		String paging = null;
		try {
			productList = productDAO.listProduct(Integer.parseInt(tpage), name);
			paging = productDAO.pageNumber(Integer.parseInt(tpage), name);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(ProductVO vo : productList){
			System.out.println(vo.getName());
		}
		
		request.setAttribute("productKindList", productList);
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
		
		return url;
	}

	
	
	
}
