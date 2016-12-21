package com.neweye.dao.iBatis;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.neweye.dao.MemberDAO;
import com.neweye.dto.MemberVO;
import com.nonage.dao.iBatis.MemberDAO_iBatis;
import com.nonage.db.sqlconfig.IBatisDBConnector;

public class MemberDAO_iBatis implements MemberDAO{

	
	private SqlMapClient client = IBatisDBConnector.getSqlMapInstance();
	private static MemberDAO_iBatis instance = new MemberDAO_iBatis();

	private MemberDAO_iBatis() {
	}

	public static MemberDAO_iBatis getInstance() {
		return instance;
	}
	
	
	
	
	
	
	@Override
	public int confirmID(String userid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MemberVO> listMember(String member_name)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
