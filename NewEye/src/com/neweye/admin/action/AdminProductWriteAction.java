package com.neweye.admin.action;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neweye.dao.iBatis.ProductDAO_iBatis;
import com.neweye.action.Action;
import com.neweye.dao.ProductDAO;
import com.neweye.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductWriteAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "adminProductList.ne";
    
    HttpSession session = request.getSession();
    
    int sizeLimit = 5 * 1024 * 1024;
    String savePath = "productimg";
    ServletContext context = session.getServletContext();
    String uploadFilePath = context.getRealPath(savePath);
    
    MultipartRequest multi = new MultipartRequest(request,
        uploadFilePath,
        sizeLimit,
        "UTF-8",
        new DefaultFileRenamePolicy()
    );
    
    ProductVO productVO = new ProductVO();
    
    //productVO.setPseq(multi.getParameter("pseq")); //--------------------------
    productVO.setFirst_level(multi.getParameter("first_level")); //--------------------------
    productVO.setSecond_level(multi.getParameter("second_level")); //--------------------------
    productVO.setKind(multi.getParameter("kind")); //--------------------------
    productVO.setName(multi.getParameter("name")); //--------------------------
    String indate="2009-03-20 10:20:30.0";
    productVO.setIndate(java.sql.Timestamp.valueOf(indate)); //--------------------------
    
    productVO.setRead_count(0);
    productVO.setPrice(Integer.parseInt(multi.getParameter("price")));
    productVO.setWeight(Integer.parseInt(multi.getParameter("weight")));
    productVO.setQuantity(Integer.parseInt(multi.getParameter("quantity")));
    productVO.setWeight(Integer.parseInt(multi.getParameter("weight")));
    productVO.setPixel(Integer.parseInt(multi.getParameter("pixel")));
    productVO.setSpeed(Integer.parseInt(multi.getParameter("speed")));
    productVO.setSeqpictures(Integer.parseInt(multi.getParameter("seqpictures")));
    productVO.setIso(Integer.parseInt(multi.getParameter("iso")));
    productVO.setMovframe(Integer.parseInt(multi.getParameter("movframe")));
    productVO.setFilter(Integer.parseInt(multi.getParameter("filter")));
    
    productVO.setRatio(Float.parseFloat(multi.getParameter("ratio")));
    productVO.setScreen(Float.parseFloat(multi.getParameter("screen")));
    productVO.setMinfocus(Float.parseFloat(multi.getParameter("minfocus")));
    productVO.setMaxfocus(Float.parseFloat(multi.getParameter("maxfocus")));
    productVO.setMinaperture(Float.parseFloat(multi.getParameter("minaperture")));
    productVO.setMaxaperture(Float.parseFloat(multi.getParameter("maxaperture")));
    productVO.setDistance(Float.parseFloat(multi.getParameter("distance")));
    
    productVO.setUseyn(multi.getParameter("useyn"));
    productVO.setContent(multi.getParameter("content"));
    productVO.setImg_list(multi.getParameter("img_List"));
    productVO.setImg_detail(multi.getParameter("img_detail"));
    productVO.setSizee(multi.getParameter("sizee"));
    productVO.setFormat(multi.getParameter("format"));
    productVO.setFunctions(multi.getParameter("functions"));
    productVO.setZoomyn(multi.getParameter("zoomyn"));
    productVO.setTypes(multi.getParameter("types"));
    
    
    /*ProductDAO productDAO = ProductDAO_JDBC.getInstance();*/
    ProductDAO productDAO = ProductDAO_iBatis.getInstance();
    try {
      productDAO.insertProduct(productVO);
   } catch (SQLException e) {
      e.printStackTrace();
   }
    
    return url;
  }
}