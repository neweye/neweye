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
		
		if (request.getParameter("category") != null) {
			category(request, response);
		} else if (request.getParameter("kind") != null) {
			kind(request, response);
		} else {
			all(request, response);
		}
		return url;
	}

	private SearchVO insertSearch() {
		SearchVO search = new SearchVO();

		search.setColumn("ODSEQ");
		search.setOrderby("DESC");
		search.setTpage("");

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
		search.setMax_price(99999999);
		search.setMax_weight(99999999);
		search.setMax_pixel(99999999);
		search.setMax_iso(99999999);
		search.setMax_speed(99999999);
		search.setMax_screen(99999999);
		search.setMax_movframe(99999999);
		search.setMax_seqpictures(99999999);
		search.setMax_filter(99999999);
		search.setMax_minfocus(99999999);
		search.setMax_maxfocus(99999999);
		search.setMax_minaperture(99999999);
		search.setMax_maxaperture(99999999);
		search.setMax_distance(99999999);

		return search;
	}

	private SearchVO updateSearch(SearchVO search, HttpServletRequest request) {
		if (request.getParameter("column") != null)
		search.setColumn(request.getParameter("column"));
		search.setOrderby(request.getParameter("orderby"));
		search.setTpage(request.getParameter("tpage"));

		search.setKind(request.getParameter("kind"));
		search.setCategory(request.getParameter("category"));
		if (request.getParameter("name") != null)
			search.setName(request.getParameter("name"));
		search.setUseyn(request.getParameter("useyn"));
		search.setRatio(request.getParameter("ratio"));
		search.setFormat(request.getParameter("format"));
		search.setZoomyn(request.getParameter("zoomyn"));
		search.setFunctions(request.getParameter("functions"));
		search.setTypes(request.getParameter("types"));

		search.setMin_price(Integer.parseInt(request.getParameter("min_price")));
		search.setMin_weight(Integer.parseInt(request.getParameter("min_weight")));
		search.setMin_pixel(Integer.parseInt(request.getParameter("min_pixel")));
		search.setMin_iso(Integer.parseInt(request.getParameter("min_iso")));
		search.setMin_speed(Integer.parseInt(request.getParameter("min_speed")));
		search.setMin_movframe(Integer.parseInt(request.getParameter("min_movframe")));
		search.setMin_seqpictures(Integer.parseInt(request.getParameter("min_seqpictures")));
		search.setMin_filter(Integer.parseInt(request.getParameter("min_filter")));
		search.setMin_screen(Float.parseFloat(request.getParameter("min_screen")));
		search.setMin_minfocus(Float.parseFloat(request.getParameter("min_minfocus")));
		search.setMin_maxfocus(Float.parseFloat(request.getParameter("min_maxfocus")));
		search.setMin_minaperture(Float.parseFloat(request.getParameter("min_minaperture")));
		search.setMin_maxaperture(Float.parseFloat(request.getParameter("min_maxaperture")));
		search.setMin_distance(Float.parseFloat(request.getParameter("min_distance")));

		search.setMax_price(Integer.parseInt(request.getParameter("max_price")));
		search.setMax_weight(Integer.parseInt(request.getParameter("max_weight")));
		search.setMax_pixel(Integer.parseInt(request.getParameter("max_pixel")));
		search.setMax_iso(Integer.parseInt(request.getParameter("max_iso")));
		search.setMax_speed(Integer.parseInt(request.getParameter("max_speed")));
		search.setMax_movframe(Integer.parseInt(request.getParameter("max_movframe")));
		search.setMax_seqpictures(Integer.parseInt(request.getParameter("max_seqpictures")));
		search.setMax_filter(Integer.parseInt(request.getParameter("max_filter")));
		search.setMax_screen(Float.parseFloat(request.getParameter("max_screen")));
		search.setMax_minfocus(Float.parseFloat(request.getParameter("max_minfocus")));
		search.setMax_maxfocus(Float.parseFloat(request.getParameter("max_maxfocus")));
		search.setMax_minaperture(Float.parseFloat(request.getParameter("max_minaperture")));
		search.setMax_maxaperture(Float.parseFloat(request.getParameter("max_maxaperture")));
		search.setMax_distance(Float.parseFloat(request.getParameter("max_distance")));

		return search;
	}

	private void all(HttpServletRequest request, HttpServletResponse response) {

		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);

		SearchVO searchVO = new SearchVO();
		searchVO.setOrderby("desc");
		searchVO.setColumn("indate");

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();

		ArrayList<ProductVO> productList = null;
		String paging = null;

		try {
			productList = productDAO.listSelProduct(Integer.parseInt(tpage),
					searchVO);
			paging = productDAO
					.pageNumber2(Integer.parseInt(tpage), key, "all");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productList);
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
	}

	private void kind(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind").trim();

		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		ArrayList<ProductVO> productKindList = null;
		String paging = null;
		try {
			productKindList = productDAO.listKindProduct(
					Integer.parseInt(tpage), kind);
			paging = productDAO.pageNumber2(Integer.parseInt(tpage), kind,
					"kind");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productKindList);
		int n = productKindList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
	}

	private void category(HttpServletRequest request,
			HttpServletResponse response) {
		String category = request.getParameter("category").trim().toUpperCase();

		String key = request.getParameter("key");
		String tpage = request.getParameter("tpage");
		if (key == null) {
			key = "";
		}
		if (tpage == null) {
			tpage = "1"; // 현재 페이지 (default 1)
		} else if (tpage.equals("")) {
			tpage = "1";
		}
		request.setAttribute("key", key);
		request.setAttribute("tpage", tpage);

		/* ProductDAO productDAO = ProductDAO_JDBC.getInstance(); */
		ProductDAO productDAO = ProductDAO_iBatis.getInstance();
		ArrayList<ProductVO> productKindList = null;
		String paging = null;
		try {
			productKindList = productDAO.listCategoryProduct(
					Integer.parseInt(tpage), category);
			paging = productDAO.pageNumber2(Integer.parseInt(tpage), category,
					"category");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("productKindList", productKindList);
		int n = productKindList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
	}
}
