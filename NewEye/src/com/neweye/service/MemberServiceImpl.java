package com.neweye.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.neweye.dao.MemberDAO;
import com.neweye.dto.MemberVO;

public class MemberServiceImpl implements MemberService {

	private static MemberServiceImpl instance=new MemberServiceImpl();
	private MemberServiceImpl(){}
	public static MemberServiceImpl getInstance(){
		return instance;
	}
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO=memberDAO;
	}
	
	@Override
	public List<MemberVO> getMemberList() throws SQLException{
		
		List<MemberVO> memberList=memberDAO.getMemberList();
		
		return memberList;
	}
	
	@Override
	public void insertMember(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);		
	}
	@Override
	public MemberVO getMember(String userid) throws SQLException {
		MemberVO member=memberDAO.getMember(userid);
		return member;
	}
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
		
	}
	@Override
	public void deleteMember(String userid) throws SQLException {
		memberDAO.deleteMember(userid);
		
	}
	@Override
	public int loginMember(String userid, String password) throws SQLException {
		MemberVO member=memberDAO.getMember(userid);
		int result=-1; // 아이디 없음 : 0, 패스워드 불일치 : -1, 로그인 성공 1;
		
		if(member!=null){
			if(password.equals(member.getPassword())){
				result=1;
			}else{
				result=-1;
			}
		}else{
			result=0; //아이디 불일치.
		}
		
		return result;
	}
	@Override
	public boolean logoutMember(HttpSession session) {
		MemberVO member=(MemberVO)session.getAttribute("loginUser");
		boolean result=false;
		if(member!=null){			
			session.invalidate();
			result=true;
		}else{
			result=false;
		}
		return result;
	}

}








