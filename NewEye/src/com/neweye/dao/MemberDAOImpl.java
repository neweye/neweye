package com.neweye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.Board;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.neweye.dto.MemberVO;
import com.neweye.jdbc.DataSource;
import com.neweye.jdbc.connection.ConnectionProvider;
import com.neweye.jdbc.loader.DBCPInit;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl instance=new MemberDAOImpl();
	private MemberDAOImpl(){}
	public static MemberDAOImpl getInstance(){
		return instance;
	}
	
	
	private SqlMapClient client;
	
	public void setClient(SqlMapClient client){
		this.client=client;
	}

	

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList=(List<MemberVO>)client.queryForList("selectAllMember",null);
		return memberList;
	}
	

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		int result = client.update("insertMember",member);
	}
	
	
	@Override
	public MemberVO getMember(String userid) throws SQLException {
		
	}
	
	
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		
	}
	
	
	@Override
	public void deleteMember(String userid) throws SQLException {
		
	}

}










