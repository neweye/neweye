package co.kr.neweye.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.neweye.dto.MemberVO;

public interface MemberDAO {
   public int confirmID(String userid) throws SQLException;
   public MemberVO getMember(String id) throws SQLException;
   public int insertMember(MemberVO memberVO) throws SQLException;
   public ArrayList<MemberVO> listMember(String member_name) throws SQLException;
   public MemberVO searchId(String name,String phone) throws SQLException;
   public void updateMember(MemberVO memberVO) throws SQLException;
   public void deleteuseMember(MemberVO memberVO) throws SQLException;
   public int deleteMember(String userid) throws SQLException;
   
   
}