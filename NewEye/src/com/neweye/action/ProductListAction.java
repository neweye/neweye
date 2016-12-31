package com.neweye.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neweye.dao.ProductDAO;
import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.dto.ProductVO;
import com.neweye.dto.SearchVO;

public class ProductListAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = "product/product_list.jsp";
		
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
		
		return url;
	}

	protected SearchVO insertSearch() {
		SearchVO search = new SearchVO();

		search.setColumn("odseq");
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
		if (request.getParameter("column") != null)
		search.setColumn(request.getParameter("column"));
		if (request.getParameter("orderby") != null)
		search.setOrderby(request.getParameter("orderby"));
		if (request.getParameter("tpage") != null)
		search.setTpage(request.getParameter("tpage"));
		
		if (request.getParameter("kind") != null)
		search.setKind(request.getParameter("kind"));
		if (request.getParameter("category") != null)
		search.setCategory(request.getParameter("category"));
		if (request.getParameter("name") != null)
			search.setName(request.getParameter("name"));
		if (request.getParameter("useyn") != null)
		search.setUseyn(request.getParameter("useyn"));
		if (request.getParameter("ratio") != null)
		search.setRatio(request.getParameter("ratio"));
		if (request.getParameter("format") != null)
		search.setFormat(request.getParameter("format"));
		if (request.getParameter("zoomyn") != null)
		search.setZoomyn(request.getParameter("zoomyn"));
		if (request.getParameter("functions") != null)
		search.setFunctions(request.getParameter("functions"));
		if (request.getParameter("types") != null)
		search.setTypes(request.getParameter("types"));
		
		if (request.getParameter("min_price") != null)
		search.setMin_price(Integer.parseInt(request.getParameter("min_price")));
		if (request.getParameter("min_weight") != null)
		search.setMin_weight(Integer.parseInt(request.getParameter("min_weight")));
		if (request.getParameter("min_pixel") != null)
		search.setMin_pixel(Integer.parseInt(request.getParameter("min_pixel")));
		if (request.getParameter("min_iso") != null)
		search.setMin_iso(Integer.parseInt(request.getParameter("min_iso")));
		if (request.getParameter("min_speed") != null)
		search.setMin_speed(Integer.parseInt(request.getParameter("min_speed")));
		if (request.getParameter("min_movframe") != null)
		search.setMin_movframe(Integer.parseInt(request.getParameter("min_movframe")));
		if (request.getParameter("min_seqpictures") != null)
		search.setMin_seqpictures(Integer.parseInt(request.getParameter("min_seqpictures")));
		if (request.getParameter("min_filter") != null)
		search.setMin_filter(Integer.parseInt(request.getParameter("min_filter")));
		if (request.getParameter("min_screen") != null)
		search.setMin_screen(Float.parseFloat(request.getParameter("min_screen")));
		if (request.getParameter("min_minfocus") != null)
		search.setMin_minfocus(Float.parseFloat(request.getParameter("min_minfocus")));
		if (request.getParameter("min_maxfocus") != null)
		search.setMin_maxfocus(Float.parseFloat(request.getParameter("min_maxfocus")));
		if (request.getParameter("min_minaperture") != null)
		search.setMin_minaperture(Float.parseFloat(request.getParameter("min_minaperture")));
		if (request.getParameter("min_maxaperture") != null)
		search.setMin_maxaperture(Float.parseFloat(request.getParameter("min_maxaperture")));
		if (request.getParameter("min_distance") != null)
		search.setMin_distance(Float.parseFloat(request.getParameter("min_distance")));
		if (request.getParameter("max_price") != null)
		search.setMax_price(Integer.parseInt(request.getParameter("max_price")));
		if (request.getParameter("max_weight") != null)
		search.setMax_weight(Integer.parseInt(request.getParameter("max_weight")));
		if (request.getParameter("max_pixel") != null)
		search.setMax_pixel(Integer.parseInt(request.getParameter("max_pixel")));
		if (request.getParameter("max_iso") != null)
		search.setMax_iso(Integer.parseInt(request.getParameter("max_iso")));
		if (request.getParameter("max_speed") != null)
		search.setMax_speed(Integer.parseInt(request.getParameter("max_speed")));
		if (request.getParameter("max_movframe") != null)
		search.setMax_movframe(Integer.parseInt(request.getParameter("max_movframe")));
		if (request.getParameter("max_seqpictures") != null)
		search.setMax_seqpictures(Integer.parseInt(request.getParameter("max_seqpictures")));
		if (request.getParameter("max_filter") != null)
		search.setMax_filter(Integer.parseInt(request.getParameter("max_filter")));
		if (request.getParameter("max_screen") != null)
		search.setMax_screen(Float.parseFloat(request.getParameter("max_screen")));
		if (request.getParameter("max_minfocus") != null)
		search.setMax_minfocus(Float.parseFloat(request.getParameter("max_minfocus")));
		if (request.getParameter("max_maxfocus") != null)
		search.setMax_maxfocus(Float.parseFloat(request.getParameter("max_maxfocus")));
		if (request.getParameter("max_minaperture") != null)
		search.setMax_minaperture(Float.parseFloat(request.getParameter("max_minaperture")));
		if (request.getParameter("max_maxaperture") != null)
		search.setMax_maxaperture(Float.parseFloat(request.getParameter("max_maxaperture")));
		if (request.getParameter("max_distance") != null)
		search.setMax_distance(Float.parseFloat(request.getParameter("max_distance")));
		
		return search;
	}
}
