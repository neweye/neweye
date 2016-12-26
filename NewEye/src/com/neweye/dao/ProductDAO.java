package com.neweye.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neweye.dto.ProductVO;
import com.neweye.dto.SearchVO;

public interface ProductDAO {
   
   // 리스트 업어오기.
   public ArrayList<ProductVO> listSelProduct(int tpage, SearchVO search) throws SQLException;
   
   // 신상품 리스트 얻어오기.
   public ArrayList<ProductVO> listNewProduct(int tpage) throws SQLException;

   // 베스트 상품 리스트 얻어오기
   public ArrayList<ProductVO> listBestProduct(int tpage) throws SQLException;

   // 상품번호로 상품정보 한개 가져오기
   public ProductVO getProduct(String pseq) throws SQLException;

   // 상품종류별 상품 리스트 얻어오기
   public ArrayList<ProductVO> listKindProduct(int tpage, String kind)
         throws SQLException;
   
   // 상품세부종류별 리스트 얻어오기
   public ArrayList<ProductVO> listCategoryProduct(int tpage, String Category) throws SQLException;
   
   /*
    * 관리자페이지에서 사용되는 메서드
    */
   public int totalRecord(String product_name) throws SQLException;

   // 페이지 이동을 위한 메소드
   public String pageNumber(int tpage, String name) throws SQLException;
   
   public String pageNumber2(int tpage, String name, String type) throws SQLException;

   public ArrayList<ProductVO> listProduct(int tpage, String product_name) throws SQLException;
   
   ///////////////////////////////////
   public ArrayList<ProductVO> listDetailProduct(int tpage, String product_name) throws SQLException;
   
   public int insertProduct(ProductVO product) throws SQLException;
   
   public int updateProduct(ProductVO product) throws SQLException;
   
   // 상품 조회수 증가/////////////////////////////////////////////////////
   public int increaseReadCount(ProductVO product) throws SQLException;

   public int countlistCategoryProduct(String first_level) throws SQLException;

   public int countlistKindProduct(String kind) throws SQLException;

}