package kr.co.neweye.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.neweye.dto.ProductVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.neweye.dao.ProductDAO;
import co.kr.neweye.ibatis.ProductDAO_iBatis;



@Controller
@RequestMapping("/admin")
public class AdminProductController {

	
	
	@RequestMapping("/adminProductList")
	  public String adminProductList(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

		//String url = "admin/product/productList";
		String url = "admin/product/productList";
		
		
		
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
	
	
	
	@RequestMapping("/adminProductSearch")
	public String adminProductSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//String url = "product/productList";
		String url = "admin/product/productList";
		
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

		ProductDAO productDAO = ProductDAO_iBatis.getInstance();

		ArrayList<ProductVO> productList = null;
		String paging = null;
		try {
			productList = productDAO.listProduct(Integer.parseInt(tpage), key);
			paging = productDAO.pageNumber(Integer.parseInt(tpage), key);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("productList", productList);
		int n = productList.size();
		request.setAttribute("productListSize", n);
		request.setAttribute("paging", paging);
		
		return url;
	}

	
	
	@RequestMapping("/adminProductDetail")
	public String adminProductDetail(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/product/productDetail";

	    String pseq = request.getParameter("pseq").trim();

	    /*ProductDAO productDAO = ProductDAO_JDBC.getInstance();*/
	    ProductDAO productDAO = ProductDAO_iBatis.getInstance();
	    ProductVO productVO=null;
		try {
			productVO = productDAO.getProduct(pseq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    request.setAttribute("productVO", productVO);

	    // 상품 리스트(product_list.jsp) 페이지에서 쿼리 스트링으로 넘겨준 현재 페이지를 얻어온다.
	    String tpage = "1";
	    if (request.getParameter("tpage") != null) {
	      tpage = request.getParameter("tpage");
	    }
	    //String kindList[] = {};
	    request.setAttribute("tpage", tpage);
	    int index=Integer.parseInt(productVO.getKind().trim());
	    request.setAttribute("kind", productVO.getKind().trim());
	    
	    return url;
	  }
	
	
	
	  @RequestMapping("adminProductWriteForm")
	  public String adminProductWriteForm(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/product/productWrite";
	    String kindList[] = {"DSLR", "LENDS", "ACCESSORY"};    
	    request.setAttribute("kindList", kindList);
	    
	    return url;
	  }
	
	
	
//	@RequestMapping("/adminProductWrite")
//	  public String adminProductWrite(HttpServletRequest request, HttpServletResponse response)
//	      throws ServletException, IOException {
//	    String url = "redirect:adminProductList";
//	    
//	    HttpSession session = request.getSession();
//	    
//	    int sizeLimit = 5 * 1024 * 1024;
//	    String savePath = "productimg";
//	    ServletContext context = session.getServletContext();
//	    String uploadFilePath = context.getRealPath(savePath);
//	    
//	    MultipartRequest multi = new MultipartRequest(request,
//	        uploadFilePath,
//	        sizeLimit,
//	        "UTF-8",
//	        new DefaultFileRenamePolicy()
//	    );
//	    
//	    ProductVO productVO = new ProductVO();
//	    
//	    //productVO.setPseq(multi.getParameter("pseq")); //--------------------------
//	    productVO.setFirst_level(multi.getParameter("first_level")); //--------------------------
//	    productVO.setSecond_level(multi.getParameter("second_level")); //--------------------------
//	    productVO.setKind(multi.getParameter("kind")); //--------------------------
//	    productVO.setName(multi.getParameter("name")); //--------------------------
//	    if(multi.getParameter("indate") == null || multi.getParameter("indate").equals("")){ productVO.setIndate(new Timestamp(System.currentTimeMillis()));
//	    }else{ String indate=multi.getParameter("indate")+" 10:20:30.0"; productVO.setIndate(java.sql.Timestamp.valueOf(indate)); }    
//	    productVO.setRead_count(0);
//	    if(multi.getParameter("price")==null||multi.getParameter("price").equals("")) { productVO.setPrice(0);
//	    }else{ productVO.setPrice(Integer.parseInt(multi.getParameter("price"))); }
//	    if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
//	    }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
//	    if(multi.getParameter("quantity")==null||multi.getParameter("quantity").equals("")) { productVO.setQuantity(0);
//	    }else{ productVO.setQuantity(Integer.parseInt(multi.getParameter("quantity"))); }
//	    if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
//	    }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
//	    if(multi.getParameter("pixel")==null||multi.getParameter("pixel").equals("")) { productVO.setPixel(0);
//	    }else{ productVO.setPixel(Integer.parseInt(multi.getParameter("pixel"))); }
//	    if(multi.getParameter("speed")==null||multi.getParameter("speed").equals("")) { productVO.setSpeed(0);
//	    }else{ productVO.setSpeed(Integer.parseInt(multi.getParameter("speed"))); }
//	    if(multi.getParameter("seqpictures")==null||multi.getParameter("seqpictures").equals("")) { productVO.setSeqpictures(0);
//	    }else{ productVO.setSeqpictures(Integer.parseInt(multi.getParameter("seqpictures"))); }
//	    if(multi.getParameter("iso")==null||multi.getParameter("iso").equals("")) { productVO.setIso(0);
//	    }else{ productVO.setIso(Integer.parseInt(multi.getParameter("iso"))); }
//	    if(multi.getParameter("movframe")==null||multi.getParameter("movframe").equals("")) { productVO.setMovframe(0);
//	    }else{ productVO.setMovframe(Integer.parseInt(multi.getParameter("movframe"))); }
//	    if(multi.getParameter("filter")==null||multi.getParameter("filter").equals("")) { productVO.setFilter(0);
//	    }else{ productVO.setFilter(Integer.parseInt(multi.getParameter("filter"))); }
//	    
//	    if(multi.getParameter("ratio")==null||multi.getParameter("ratio").equals("")) { productVO.setRatio(0);
//	    }else{ productVO.setRatio(Float.parseFloat(multi.getParameter("ratio"))); }
//	    if(multi.getParameter("screen")==null||multi.getParameter("screen").equals("")) { productVO.setScreen(0);
//	    }else{ productVO.setScreen(Float.parseFloat(multi.getParameter("screen"))); }
//	    if(multi.getParameter("minfocus")==null||multi.getParameter("minfocus").equals("")) { productVO.setMinfocus(0);
//	    }else{ productVO.setMinfocus(Float.parseFloat(multi.getParameter("minfocus"))); }
//	    if(multi.getParameter("maxfocus")==null||multi.getParameter("maxfocus").equals("")) { productVO.setMaxfocus(0);
//	    }else{ productVO.setMaxfocus(Float.parseFloat(multi.getParameter("maxfocus"))); }
//	    if(multi.getParameter("minaperture")==null||multi.getParameter("minaperture").equals("")) { productVO.setMinaperture(0);
//	    }else{ productVO.setMinaperture(Float.parseFloat(multi.getParameter("minaperture"))); }
//	    if(multi.getParameter("maxaperture")==null||multi.getParameter("maxaperture").equals("")) { productVO.setMaxaperture(0);
//	    }else{ productVO.setMaxaperture(Float.parseFloat(multi.getParameter("maxaperture"))); }
//	    if(multi.getParameter("distance")==null||multi.getParameter("distance").equals("")) { productVO.setDistance(0);
//	    }else{ productVO.setDistance(Float.parseFloat(multi.getParameter("distance"))); }
//	    
//	    productVO.setUseyn(multi.getParameter("useyn"));
//	    productVO.setContent(multi.getParameter("content"));
//	    productVO.setSizee(multi.getParameter("sizee"));
//	    productVO.setFormat(multi.getParameter("format"));
//	    productVO.setFunctions(multi.getParameter("functions"));
//	    productVO.setZoomyn(multi.getParameter("zoomyn"));
//	    productVO.setTypes(multi.getParameter("types"));
//	    productVO.setImg_list(multi.getFilesystemName("img_list"));
//	    productVO.setImg_detail(multi.getFilesystemName("img_detail"));
//	    
//	    
//	    /*ProductDAO productDAO = ProductDAO_JDBC.getInstance();*/
//	    ProductDAO productDAO = ProductDAO_iBatis.getInstance();
//	    try {
//	      productDAO.insertProduct(productVO);
//	   } catch (SQLException e) {
//	      e.printStackTrace();
//	   }
//	    
//	    return url;
//	  }
	
	
	
	
	 @RequestMapping("/adminProductUpdateForm")
	  public String adminProductUpdateForm(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "admin/product/productUpdate";

	    String pseq = request.getParameter("pseq").trim();

	    /*ProductDAO productDAO = ProductDAO_JDBC.getInstance();*/
	    ProductDAO productDAO = ProductDAO_iBatis.getInstance();
	    ProductVO productVO=null;
		try {
			productVO = productDAO.getProduct(pseq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	    request.setAttribute("productVO", productVO);

	    // 상품 리스트(product_list.jsp) 페이지에서 쿼리 스트링으로 넘겨준 현재 페이지를 얻어온다.
	    String tpage = "1";
	    if (request.getParameter("tpage") != null) {
	      tpage = request.getParameter("tpage");
	    }
	    request.setAttribute("tpage", tpage);
	    
	    String kindList[] = { "DSLR", "LENDS", "ACCESSORY"};    
	    request.setAttribute("kindList", kindList);
	    
	    return url;
	  }
	
//	 @RequestMapping("/adminProductUpdate")
//	   public String adminProductUpdate(HttpServletRequest request, HttpServletResponse response)
//	         throws ServletException, IOException {
//	      String url = "redirect:adminProductList";
//
//	      HttpSession session = request.getSession();
//
//	      int sizeLimit = 5 * 1024 * 1024;
//	      String savePath = "productimg";
//	      ServletContext context = session.getServletContext();
//	      String uploadFilePath = context.getRealPath(savePath);
//
//	      MultipartRequest multi = new MultipartRequest(request,
//	            uploadFilePath,
//	            sizeLimit,
//	            "UTF-8",
//	            new DefaultFileRenamePolicy()
//	      );
//	      
//	      ProductVO productVO = new ProductVO();
//	      productVO.setPseq(Integer.parseInt(multi.getParameter("pseq"))); //--------------------------
//	      productVO.setFirst_level(multi.getParameter("first_level")); //--------------------------
//	      productVO.setSecond_level(multi.getParameter("second_level")); //--------------------------
//	      productVO.setKind(multi.getParameter("kind")); //--------------------------
//	      productVO.setName(multi.getParameter("name")); //--------------------------
//	      String indate=multi.getParameter("indate")+" 10:20:30.0";
//	      productVO.setIndate(java.sql.Timestamp.valueOf(indate)); //--------------------------
//	      
//	      productVO.setRead_count(0);
//	      if(multi.getParameter("price")==null||multi.getParameter("price").equals("")) { productVO.setPrice(0);
//	      }else{ productVO.setPrice(Integer.parseInt(multi.getParameter("price"))); }
//	      if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
//	      }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
//	      if(multi.getParameter("quantity")==null||multi.getParameter("quantity").equals("")) { productVO.setQuantity(0);
//	      }else{ productVO.setQuantity(Integer.parseInt(multi.getParameter("quantity"))); }
//	      if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
//	      }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
//	      if(multi.getParameter("pixel")==null||multi.getParameter("pixel").equals("")) { productVO.setPixel(0);
//	      }else{ productVO.setPixel(Integer.parseInt(multi.getParameter("pixel"))); }
//	      if(multi.getParameter("speed")==null||multi.getParameter("speed").equals("")) { productVO.setSpeed(0);
//	      }else{ productVO.setSpeed(Integer.parseInt(multi.getParameter("speed"))); }
//	      if(multi.getParameter("seqpictures")==null||multi.getParameter("seqpictures").equals("")) { productVO.setSeqpictures(0);
//	      }else{ productVO.setSeqpictures(Integer.parseInt(multi.getParameter("seqpictures"))); }
//	      if(multi.getParameter("iso")==null||multi.getParameter("iso").equals("")) { productVO.setIso(0);
//	      }else{ productVO.setIso(Integer.parseInt(multi.getParameter("iso"))); }
//	      if(multi.getParameter("movframe")==null||multi.getParameter("movframe").equals("")) { productVO.setMovframe(0);
//	      }else{ productVO.setMovframe(Integer.parseInt(multi.getParameter("movframe"))); }
//	      if(multi.getParameter("filter")==null||multi.getParameter("filter").equals("")) { productVO.setFilter(0);
//	      }else{ productVO.setFilter(Integer.parseInt(multi.getParameter("filter"))); }
//	      
//	      if(multi.getParameter("ratio")==null||multi.getParameter("ratio").equals("")) { productVO.setRatio(0);
//	      }else{ productVO.setRatio(Float.parseFloat(multi.getParameter("ratio"))); }
//	      if(multi.getParameter("screen")==null||multi.getParameter("screen").equals("")) { productVO.setScreen(0);
//	      }else{ productVO.setScreen(Float.parseFloat(multi.getParameter("screen"))); }
//	      if(multi.getParameter("minfocus")==null||multi.getParameter("minfocus").equals("")) { productVO.setMinfocus(0);
//	      }else{ productVO.setMinfocus(Float.parseFloat(multi.getParameter("minfocus"))); }
//	      if(multi.getParameter("maxfocus")==null||multi.getParameter("maxfocus").equals("")) { productVO.setMaxfocus(0);
//	      }else{ productVO.setMaxfocus(Float.parseFloat(multi.getParameter("maxfocus"))); }
//	      if(multi.getParameter("minaperture")==null||multi.getParameter("minaperture").equals("")) { productVO.setMinaperture(0);
//	      }else{ productVO.setMinaperture(Float.parseFloat(multi.getParameter("minaperture"))); }
//	      if(multi.getParameter("maxaperture")==null||multi.getParameter("maxaperture").equals("")) { productVO.setMaxaperture(0);
//	      }else{ productVO.setMaxaperture(Float.parseFloat(multi.getParameter("maxaperture"))); }
//	      if(multi.getParameter("distance")==null||multi.getParameter("distance").equals("")) { productVO.setDistance(0);
//	      }else{ productVO.setDistance(Float.parseFloat(multi.getParameter("distance"))); }
//	      
//	      productVO.setUseyn(multi.getParameter("useyn"));
//	      productVO.setContent(multi.getParameter("content"));
//	      productVO.setSizee(multi.getParameter("sizee"));
//	      productVO.setFormat(multi.getParameter("format"));
//	      productVO.setFunctions(multi.getParameter("functions"));
//	      productVO.setZoomyn(multi.getParameter("zoomyn"));
//	      productVO.setTypes(multi.getParameter("types"));
//	      productVO.setImg_list(multi.getFilesystemName("img_list"));
//	      productVO.setImg_detail(multi.getFilesystemName("img_detail"));
//	      
//	      ProductDAO productDAO = ProductDAO_iBatis.getInstance();
//	      try {
//	         productDAO.updateProduct(productVO);
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      }
//
//	      return url;
//	   }
	
	 
	 
	 @RequestMapping("/adminDelete")
		public String adminDelete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String url = "redirect:adminProductList";
			
			ProductVO productVO = new ProductVO();
			
			
			productVO.setPseq(Integer.parseInt(request.getParameter("pseq")));
			productVO.setKind("0");
			
			
			ProductDAO productDAO = ProductDAO_iBatis.getInstance();
			
			try {
				productDAO.deleteProduct(productVO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return url;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	
}
