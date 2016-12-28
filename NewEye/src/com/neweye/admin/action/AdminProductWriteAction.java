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
    if(multi.getParameter("price")==null||multi.getParameter("price").equals("")) { productVO.setPrice(0);
    }else{ productVO.setPrice(Integer.parseInt(multi.getParameter("price"))); }
    if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
    }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
    if(multi.getParameter("quantity")==null||multi.getParameter("quantity").equals("")) { productVO.setQuantity(0);
    }else{ productVO.setQuantity(Integer.parseInt(multi.getParameter("quantity"))); }
    if(multi.getParameter("weight")==null||multi.getParameter("weight").equals("")) { productVO.setWeight(0);
    }else{ productVO.setWeight(Integer.parseInt(multi.getParameter("weight"))); }
    if(multi.getParameter("pixel")==null||multi.getParameter("pixel").equals("")) { productVO.setPixel(0);
    }else{ productVO.setPixel(Integer.parseInt(multi.getParameter("pixel"))); }
    if(multi.getParameter("speed")==null||multi.getParameter("speed").equals("")) { productVO.setSpeed(0);
    }else{ productVO.setSpeed(Integer.parseInt(multi.getParameter("speed"))); }
    if(multi.getParameter("seqpictures")==null||multi.getParameter("seqpictures").equals("")) { productVO.setSeqpictures(0);
    }else{ productVO.setSeqpictures(Integer.parseInt(multi.getParameter("seqpictures"))); }
    if(multi.getParameter("iso")==null||multi.getParameter("iso").equals("")) { productVO.setIso(0);
    }else{ productVO.setIso(Integer.parseInt(multi.getParameter("iso"))); }
    if(multi.getParameter("movframe")==null||multi.getParameter("movframe").equals("")) { productVO.setMovframe(0);
    }else{ productVO.setMovframe(Integer.parseInt(multi.getParameter("movframe"))); }
    if(multi.getParameter("filter")==null||multi.getParameter("filter").equals("")) { productVO.setFilter(0);
    }else{ productVO.setFilter(Integer.parseInt(multi.getParameter("filter"))); }
    
    if(multi.getParameter("ratio")==null||multi.getParameter("ratio").equals("")) { productVO.setRatio(0);
    }else{ productVO.setRatio(Float.parseFloat(multi.getParameter("ratio"))); }
    if(multi.getParameter("screen")==null||multi.getParameter("screen").equals("")) { productVO.setScreen(0);
    }else{ productVO.setScreen(Float.parseFloat(multi.getParameter("screen"))); }
    if(multi.getParameter("minfocus")==null||multi.getParameter("minfocus").equals("")) { productVO.setMinfocus(0);
    }else{ productVO.setMinfocus(Float.parseFloat(multi.getParameter("minfocus"))); }
    if(multi.getParameter("maxfocus")==null||multi.getParameter("maxfocus").equals("")) { productVO.setMaxfocus(0);
    }else{ productVO.setMaxfocus(Float.parseFloat(multi.getParameter("maxfocus"))); }
    if(multi.getParameter("minaperture")==null||multi.getParameter("minaperture").equals("")) { productVO.setMinaperture(0);
    }else{ productVO.setMinaperture(Float.parseFloat(multi.getParameter("minaperture"))); }
    if(multi.getParameter("maxaperture")==null||multi.getParameter("maxaperture").equals("")) { productVO.setMaxaperture(0);
    }else{ productVO.setMaxaperture(Float.parseFloat(multi.getParameter("maxaperture"))); }
    if(multi.getParameter("distance")==null||multi.getParameter("distance").equals("")) { productVO.setDistance(0);
    }else{ productVO.setDistance(Float.parseFloat(multi.getParameter("distance"))); }
    
    productVO.setUseyn(multi.getParameter("useyn"));
    productVO.setContent(multi.getParameter("content"));
    productVO.setSizee(multi.getParameter("sizee"));
    productVO.setFormat(multi.getParameter("format"));
    productVO.setFunctions(multi.getParameter("functions"));
    productVO.setZoomyn(multi.getParameter("zoomyn"));
    productVO.setTypes(multi.getParameter("types"));
    productVO.setImg_list(multi.getParameter("img_List"));
    productVO.setImg_detail(multi.getParameter("img_detail"));
    
    
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