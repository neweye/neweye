package co.kr.neweye.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.neweye.dto.AddressVO;

public interface AddressDAO {
	public ArrayList<AddressVO> selectAddressByDong(String dong) throws SQLException;
}
