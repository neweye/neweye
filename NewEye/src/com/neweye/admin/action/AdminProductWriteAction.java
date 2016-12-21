package com.neweye.admin.action;

import java.io.IOException;

import java.sql.SQLException;

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
    String url = "adminProductList.do";
    
    HttpSession session = request.getSession();
    
    int sizeLimit = 5 * 1024 * 1024;
    String savePath = "product_images";
    ServletContext context = session.getServletContext();
    String uploadFilePath = context.getRealPath(savePath);
    
    MultipartRequest multi = new MultipartRequest(request, // 1. 요청 객체
        uploadFilePath, // 2. 업로드될 파일이 저장될 파일 경로명
        sizeLimit, // 3. 업로드될 파일의 최대 크기(5Mb)
        "UTF-8", // 4. 인코딩 타입 지정
        new DefaultFileRenamePolicy() // 5. 덮어쓰기를 방지 위한 부분
    ); // 이 시점을 기해 파일은 이미 저장이 되었다
    
    ProductVO productVO = new ProductVO();
    productVO.setKind(multi.getParameter("kind"));
    productVO.setName(multi.getParameter("name"));
    productVO.setPrice1(Integer.parseInt(multi.getParameter("price1")));
    productVO.setPrice2(Integer.parseInt(multi.getParameter("price2")));
    productVO.setPrice3(Integer.parseInt(multi.getParameter("price2"))
        - Integer.parseInt(multi.getParameter("price1")));
    productVO.setContent(multi.getParameter("content"));
    productVO.setImage(multi.getFilesystemName("image"));

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
