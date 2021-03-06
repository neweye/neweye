package com.neweye.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neweye.dto.ProductVO;
import com.neweye.dto.SearchVO;

public interface ProductDAO {
   
   // 리스트 업어오기.
   public ArrayList<ProductVO> listSelProduct(SearchVO search) throws SQLException;
   
   // 상품번호로 상품정보 한개 가져오기
   public ProductVO getProduct(String pseq) throws SQLException;

   /*
    * 관리자페이지에서 사용되는 메서드
    */
   public int totalRecord(String product_name) throws SQLException;

   // 페이지 이동을 위한 메소드
   public String pageNumber(int tpage, String name) throws SQLException;
   public String pageNum(SearchVO search) throws SQLException;

   public ArrayList<ProductVO> listProduct(int tpage, String product_name) throws SQLException;
   ///////////////////////////////////
   public ArrayList<ProductVO> listDetailProduct(int tpage, String product_name) throws SQLException;
   
   public int insertProduct(ProductVO product) throws SQLException;
   
   public int updateProduct(ProductVO product) throws SQLException;
   
   public int deleteProduct(ProductVO product) throws SQLException;
   
   // 상품 조회수 증가/////////////////////////////////////////////////////
   public int increaseReadCount(ProductVO product) throws SQLException;

}