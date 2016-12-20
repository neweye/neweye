package com.neweye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	// 1. 데이터베이스 설정
	private DataSource datasource;

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from member order by userid";

		// 2. connection 생성
		/*conn = datasource.getConnection();*/
		conn=datasource.getConnection();

		// 3. Statement 생성
		stmt = conn.createStatement();

		// 4. 쿼리 실행
		rs = stmt.executeQuery(sql);

		// 5. 쿼리 실행 결과 출력

		List<MemberVO> memberList = new ArrayList<MemberVO>();
		while (rs.next()) {
			
			MemberVO member = new MemberVO();

			member.setUserid(rs.getString("userid"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));

			memberList.add(member);
		}

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
		
		
		return memberList;
	}
	@Override
	public void insertMember(MemberVO member) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="insert into member(userid,password,name,email)"+
					" values(?,?,?,?)";
		
		conn=datasource.getConnection();
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member.getUserid());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		
		pstmt.executeUpdate();		
		
		if (pstmt!=null) pstmt.close();
		if (conn!=null) conn.close();
	}
	@Override
	public MemberVO getMember(String userid) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=datasource.getConnection();
		
		String sql="select * from member where userid=?";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, userid);
		
		rs=pstmt.executeQuery();
		
		MemberVO member=null;
		if(rs.next()){
			member=new MemberVO();
			member.setName(rs.getString("name"));
			member.setEmail(rs.getString("email"));
			member.setUserid(rs.getString("userid"));
			member.setPassword(rs.getString("password"));
		}
		
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
		
		return member;
	}
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=datasource.getConnection();
		
		String sql="update member set name=?,email=?,password=? where userid=? ";
		
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1,member.getName());
		pstmt.setString(2, member.getEmail());
		pstmt.setString(3, member.getPassword());
		pstmt.setString(4, member.getUserid());
		
		pstmt.executeUpdate();
				
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
	
	@Override
	public void deleteMember(String userid) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from member where userid=?";
		
		conn=datasource.getConnection();
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, userid);
		
		pstmt.executeUpdate();
		
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}

}










