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
import org.springframework.web.multipart.MultipartRequest;

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
   
   
   
   @RequestMapping("/adminProductWrite")
     public String adminProductWrite(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
       String url = "redirect:adminProductList";
       
       HttpSession session = request.getSession();
       
       int sizeLimit = 5 * 1024 * 1024;
       String savePath = "productimg";
       ServletContext context = session.getServletContext();
       String uploadFilePath = context.getRealPath(savePath);
              
       ProductVO productVO = new ProductVO();
       
       //productVO.setPseq(request.getParameter("pseq")); //--------------------------
       productVO.setFirst_level(request.getParameter("first_level")); //--------------------------
       productVO.setSecond_level(request.getParameter("second_level")); //--------------------------
       productVO.setKind(request.getParameter("kind")); //--------------------------
       productVO.setName(request.getParameter("name")); //--------------------------
       if(request.getParameter("indate") == null || request.getParameter("indate").equals("")){ productVO.setIndate(new Timestamp(System.currentTimeMillis()));
       }else{ String indate=request.getParameter("indate")+" 10:20:30.0"; productVO.setIndate(java.sql.Timestamp.valueOf(indate)); }    
       productVO.setRead_count(0);
       if(request.getParameter("price")==null||request.getParameter("price").equals("")) { productVO.setPrice(0);
       }else{ productVO.setPrice(Integer.parseInt(request.getParameter("price"))); }
       if(request.getParameter("weight")==null||request.getParameter("weight").equals("")) { productVO.setWeight(0);
       }else{ productVO.setWeight(Integer.parseInt(request.getParameter("weight"))); }
       if(request.getParameter("quantity")==null||request.getParameter("quantity").equals("")) { productVO.setQuantity(0);
       }else{ productVO.setQuantity(Integer.parseInt(request.getParameter("quantity"))); }
       if(request.getParameter("weight")==null||request.getParameter("weight").equals("")) { productVO.setWeight(0);
       }else{ productVO.setWeight(Integer.parseInt(request.getParameter("weight"))); }
       if(request.getParameter("pixel")==null||request.getParameter("pixel").equals("")) { productVO.setPixel(0);
       }else{ productVO.setPixel(Integer.parseInt(request.getParameter("pixel"))); }
       if(request.getParameter("speed")==null||request.getParameter("speed").equals("")) { productVO.setSpeed(0);
       }else{ productVO.setSpeed(Integer.parseInt(request.getParameter("speed"))); }
       if(request.getParameter("seqpictures")==null||request.getParameter("seqpictures").equals("")) { productVO.setSeqpictures(0);
       }else{ productVO.setSeqpictures(Integer.parseInt(request.getParameter("seqpictures"))); }
       if(request.getParameter("iso")==null||request.getParameter("iso").equals("")) { productVO.setIso(0);
       }else{ productVO.setIso(Integer.parseInt(request.getParameter("iso"))); }
       if(request.getParameter("movframe")==null||request.getParameter("movframe").equals("")) { productVO.setMovframe(0);
       }else{ productVO.setMovframe(Integer.parseInt(request.getParameter("movframe"))); }
       if(request.getParameter("filter")==null||request.getParameter("filter").equals("")) { productVO.setFilter(0);
       }else{ productVO.setFilter(Integer.parseInt(request.getParameter("filter"))); }
       
       if(request.getParameter("ratio")==null||request.getParameter("ratio").equals("")) { productVO.setRatio(0);
       }else{ productVO.setRatio(Float.parseFloat(request.getParameter("ratio"))); }
       if(request.getParameter("screen")==null||request.getParameter("screen").equals("")) { productVO.setScreen(0);
       }else{ productVO.setScreen(Float.parseFloat(request.getParameter("screen"))); }
       if(request.getParameter("minfocus")==null||request.getParameter("minfocus").equals("")) { productVO.setMinfocus(0);
       }else{ productVO.setMinfocus(Float.parseFloat(request.getParameter("minfocus"))); }
       if(request.getParameter("maxfocus")==null||request.getParameter("maxfocus").equals("")) { productVO.setMaxfocus(0);
       }else{ productVO.setMaxfocus(Float.parseFloat(request.getParameter("maxfocus"))); }
       if(request.getParameter("minaperture")==null||request.getParameter("minaperture").equals("")) { productVO.setMinaperture(0);
       }else{ productVO.setMinaperture(Float.parseFloat(request.getParameter("minaperture"))); }
       if(request.getParameter("maxaperture")==null||request.getParameter("maxaperture").equals("")) { productVO.setMaxaperture(0);
       }else{ productVO.setMaxaperture(Float.parseFloat(request.getParameter("maxaperture"))); }
       if(request.getParameter("distance")==null||request.getParameter("distance").equals("")) { productVO.setDistance(0);
       }else{ productVO.setDistance(Float.parseFloat(request.getParameter("distance"))); }
       
       if(request.getParameter("useyn")==null||request.getParameter("useyn").isEmpty()){productVO.setUseyn(" ");
       }else{productVO.setUseyn(request.getParameter("useyn"));}
       if(request.getParameter("content")==null||request.getParameter("content").isEmpty()){productVO.setContent(" ");
       }else{productVO.setContent(request.getParameter("content"));}
       if(request.getParameter("sizee")==null||request.getParameter("sizee").isEmpty()){productVO.setSizee(" ");
       }else{productVO.setSizee(request.getParameter("sizee"));}
       if(request.getParameter("format")==null||request.getParameter("format").isEmpty()){productVO.setFormat(" ");
       }else{productVO.setFormat(request.getParameter("format"));}
       if(request.getParameter("functions")==null||request.getParameter("functions").isEmpty()){productVO.setFunctions(" ");
       }else{productVO.setFunctions(request.getParameter("functions"));}
       if(request.getParameter("zoomyn")==null||request.getParameter("zoomyn").isEmpty()){productVO.setZoomyn(" ");
       }else{productVO.setZoomyn(request.getParameter("zoomyn"));}
       if(request.getParameter("types")==null||request.getParameter("types").isEmpty()){productVO.setTypes(" ");
       }else{productVO.setTypes(request.getParameter("types"));}
       
       
       productVO.setImg_list(request.getParameter("img_list"));
       productVO.setImg_detail(request.getParameter("img_detail"));
       
       /*ProductDAO productDAO = ProductDAO_JDBC.getInstance();*/
       ProductDAO productDAO = ProductDAO_iBatis.getInstance();
       try {
         productDAO.insertProduct(productVO);
      } catch (SQLException e) {
         e.printStackTrace();
      }
       
       return url;
     }
   
   
   
   
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
   
    @RequestMapping("/adminProductUpdate")
      public String adminProductUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String url = "redirect:adminProductList";

         HttpSession session = request.getSession();

         int sizeLimit = 5 * 1024 * 1024;
         String savePath = "productimg";
         ServletContext context = session.getServletContext();
         String uploadFilePath = context.getRealPath(savePath);
         
         
         
         ProductVO productVO = new ProductVO();
         productVO.setPseq(Integer.parseInt(request.getParameter("pseq"))); //--------------------------
         productVO.setFirst_level(request.getParameter("first_level")); //--------------------------
         productVO.setSecond_level(request.getParameter("second_level")); //--------------------------
         productVO.setKind(request.getParameter("kind")); //--------------------------
         productVO.setName(request.getParameter("name")); //--------------------------
         String indate=request.getParameter("indate")+" 10:20:30.0";
         productVO.setIndate(java.sql.Timestamp.valueOf(indate)); //--------------------------
         
         productVO.setRead_count(0);
         if(request.getParameter("price")==null||request.getParameter("price").equals("")) { productVO.setPrice(0);
         }else{ productVO.setPrice(Integer.parseInt(request.getParameter("price"))); }
         if(request.getParameter("weight")==null||request.getParameter("weight").equals("")) { productVO.setWeight(0);
         }else{ productVO.setWeight(Integer.parseInt(request.getParameter("weight"))); }
         if(request.getParameter("quantity")==null||request.getParameter("quantity").equals("")) { productVO.setQuantity(0);
         }else{ productVO.setQuantity(Integer.parseInt(request.getParameter("quantity"))); }
         if(request.getParameter("weight")==null||request.getParameter("weight").equals("")) { productVO.setWeight(0);
         }else{ productVO.setWeight(Integer.parseInt(request.getParameter("weight"))); }
         if(request.getParameter("pixel")==null||request.getParameter("pixel").equals("")) { productVO.setPixel(0);
         }else{ productVO.setPixel(Integer.parseInt(request.getParameter("pixel"))); }
         if(request.getParameter("speed")==null||request.getParameter("speed").equals("")) { productVO.setSpeed(0);
         }else{ productVO.setSpeed(Integer.parseInt(request.getParameter("speed"))); }
         if(request.getParameter("seqpictures")==null||request.getParameter("seqpictures").equals("")) { productVO.setSeqpictures(0);
         }else{ productVO.setSeqpictures(Integer.parseInt(request.getParameter("seqpictures"))); }
         if(request.getParameter("iso")==null||request.getParameter("iso").equals("")) { productVO.setIso(0);
         }else{ productVO.setIso(Integer.parseInt(request.getParameter("iso"))); }
         if(request.getParameter("movframe")==null||request.getParameter("movframe").equals("")) { productVO.setMovframe(0);
         }else{ productVO.setMovframe(Integer.parseInt(request.getParameter("movframe"))); }
         if(request.getParameter("filter")==null||request.getParameter("filter").equals("")) { productVO.setFilter(0);
         }else{ productVO.setFilter(Integer.parseInt(request.getParameter("filter"))); }
         
         if(request.getParameter("ratio")==null||request.getParameter("ratio").equals("")) { productVO.setRatio(0);
         }else{ productVO.setRatio(Float.parseFloat(request.getParameter("ratio"))); }
         if(request.getParameter("screen")==null||request.getParameter("screen").equals("")) { productVO.setScreen(0);
         }else{ productVO.setScreen(Float.parseFloat(request.getParameter("screen"))); }
         if(request.getParameter("minfocus")==null||request.getParameter("minfocus").equals("")) { productVO.setMinfocus(0);
         }else{ productVO.setMinfocus(Float.parseFloat(request.getParameter("minfocus"))); }
         if(request.getParameter("maxfocus")==null||request.getParameter("maxfocus").equals("")) { productVO.setMaxfocus(0);
         }else{ productVO.setMaxfocus(Float.parseFloat(request.getParameter("maxfocus"))); }
         if(request.getParameter("minaperture")==null||request.getParameter("minaperture").equals("")) { productVO.setMinaperture(0);
         }else{ productVO.setMinaperture(Float.parseFloat(request.getParameter("minaperture"))); }
         if(request.getParameter("maxaperture")==null||request.getParameter("maxaperture").equals("")) { productVO.setMaxaperture(0);
         }else{ productVO.setMaxaperture(Float.parseFloat(request.getParameter("maxaperture"))); }
         if(request.getParameter("distance")==null||request.getParameter("distance").equals("")) { productVO.setDistance(0);
         }else{ productVO.setDistance(Float.parseFloat(request.getParameter("distance"))); }
         
         productVO.setUseyn(request.getParameter("useyn"));
         productVO.setContent(request.getParameter("content"));
         productVO.setSizee(request.getParameter("sizee"));
         productVO.setFormat(request.getParameter("format"));
         productVO.setFunctions(request.getParameter("functions"));
         productVO.setZoomyn(request.getParameter("zoomyn"));
         productVO.setTypes(request.getParameter("types"));
         if(request.getParameter("img_list")==null||request.getParameter("img_list").equals("")){
            productVO.setImg_list(request.getParameter("img_list_hidden"));
         }else{
            productVO.setImg_list(request.getParameter("img_list"));
         }
         if(request.getParameter("img_detail")==null||request.getParameter("img_detail").equals("")){
            productVO.setImg_list(request.getParameter("img_detail_hidden"));
         }else{
            productVO.setImg_detail(request.getParameter("img_detail"));
         }
         ProductDAO productDAO = ProductDAO_iBatis.getInstance();
         try {
            productDAO.updateProduct(productVO);
         } catch (SQLException e) {
            e.printStackTrace();
         }

         return url;
      }
   
    
    
    @RequestMapping("/adminDelete")
      public String adminDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         String url = "redirect:adminProductList";
      
         ProductVO productVO = new ProductVO();
         
         productVO.setPseq(Integer.parseInt(request.getParameter("pseq")));
         productVO.setKind("0");
         productVO.setUseyn("N");
         
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