package co.kr.neweye.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.neweye.db.sqlconfig.IBatisDBConnector;
import kr.co.neweye.dto.AddressVO;
import co.kr.neweye.dao.AddressDAO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class AddressDAO_iBatis implements AddressDAO {
	private SqlMapClient client = IBatisDBConnector.getSqlMapInstance();
	private static AddressDAO_iBatis instance = new AddressDAO_iBatis();

	private AddressDAO_iBatis() {
	}

	public static AddressDAO_iBatis getInstance() {
		return instance;
	}
	
	@Override
	public ArrayList<AddressVO> selectAddressByDong(String dong) throws SQLException{
		ArrayList<AddressVO> addressList=(ArrayList<AddressVO>)client.queryForList("selectAddressByDong",dong);
		return addressList;

	}

}
