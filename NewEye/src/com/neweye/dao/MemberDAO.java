package com.neweye.dao;

import java.sql.SQLException;
import java.util.List;

import com.neweye.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> getMemberList() throws SQLException;

	MemberVO getMember(String userid) throws SQLException;
	
	void insertMember(MemberVO member) throws SQLException;
	
	void updateMember(MemberVO member) throws SQLException;
	
	void deleteMember(String userid) throws SQLException;	
	
}
