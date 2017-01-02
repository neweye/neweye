package com.neweye.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neweye.dto.CartVO;
import com.neweye.dto.OrderVO;

public interface OrderDAO {


	// 사용자가 주문
	int insertOrder(OrderVO orderVO, ArrayList<CartVO> cartList, String id) throws SQLException;

	void insertOrderDetail(OrderVO orderVO, CartVO cartVO, int maxOseq) throws SQLException;
	
	// 사용자가 주문 내역 검색
	ArrayList<OrderVO> listOrderById(String id, String result, int oseq) throws SQLException;

	// 현재 진행 중인 주문 내역만 조회
	ArrayList<Integer> selectSeqOrderIng(String id) throws SQLException;
	
	//전체 주문 내역 조회
	ArrayList<Integer> selectSeqOrderTotal(String id) throws SQLException;
	
	
	/* *
	 * 관리자 모드에서 사용되는 메소드 * *
	 */
	ArrayList<OrderVO> listOrder(String member_name) throws SQLException;
	
	void updateOrderResult(OrderVO oseq) throws SQLException;

	ArrayList<OrderVO> listOrderByOseq(int oseq) throws SQLException;

	void updateOrder(OrderVO oseq) throws SQLException;

	void updateOrderAdmin(OrderVO oseq) throws SQLException;
}
