package com.neweye.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import com.neweye.dto.AddressVO;

public interface AddressDAO {
	public ArrayList<AddressVO> selectAddressByDong(String dong) throws SQLException;
}
