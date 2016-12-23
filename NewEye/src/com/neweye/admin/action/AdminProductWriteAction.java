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
    
    //productVO.setPseq(multi.getParameter("pseq"));
    productVO.setFirst_level(multi.getParameter("first_level"));
    productVO.setSecond_level(multi.getParameter("second_level"));
    productVO.setKind(multi.getParameter("kind"));
    productVO.setName(multi.getParameter("name"));
    productVO.setPrice(multi.getParameter("price"));
    productVO.setWeight(multi.getParameter("weight"));
    
    /////////////////////출시일///////////////////////////////
    multi.getParameter("indate");
    Timestamp tm = new Timestamp(sizeLimit);
    productVO.setIndate(tm+"");
    
    productVO.setRead_count(multi.getParameter("Read_count"));
    productVO.setQuantity(multi.getParameter("Quantity"));
    productVO.setUseyn(multi.getParameter("useyn"));
    productVO.setContent(multi.getParameter("content"));
    productVO.setImg_list(multi.getParameter("img_List"));
    productVO.setImg_detail(multi.getParameter("img_detail"));
    productVO.setSizee(multi.getParameter("sizee"));
    productVO.setWeight(multi.getParameter("weight"));
    productVO.setRatio(multi.getParameter("ratio"));
    productVO.setPixel(multi.getParameter("pixel"));
    productVO.setSpeed(multi.getParameter("speed"));
    productVO.setSeqpictures(multi.getParameter("seqpictures"));
    productVO.setScreen(multi.getParameter("screen"));
    productVO.setIso(multi.getParameter("iso"));
    productVO.setMovframe(multi.getParameter("movframe"));
    productVO.setFormat(multi.getParameter("format"));
    productVO.setFilter(multi.getParameter("filter"));
    productVO.setFunctions(multi.getParameter("functions"));
    productVO.setZoomyn(multi.getParameter("zoomyn"));
    productVO.setMinfocus(multi.getParameter("minfocus"));
    productVO.setMaxfocus(multi.getParameter("maxfocus"));
    productVO.setMinaperture(multi.getParameter("minaperture"));
    productVO.setMaxaperture(multi.getParameter("maxaperture"));
    productVO.setDistance(multi.getParameter("distance"));
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
