package com.neweye.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.neweye.dto.MemberVO;

public interface MemberService {

	List<MemberVO> getMemberList() throws SQLException;
	
	MemberVO getMember(String userid) throws SQLException;
	
	void insertMember(MemberVO member) throws SQLException;
	void updateMember(MemberVO member) throws SQLException;
	void deleteMember(String userid) throws SQLException;
	
	int loginMember(String userid,String password) throws SQLException;
	
	boolean logoutMember(HttpSession session);
	
	
}
