package com.dreamli.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtil {

	private final static DataSource DATASOURCE = new ComboPooledDataSource();
	
	private DaoUtil() {
	}
	
	
	public static DataSource getDataSource() {
		return DATASOURCE;
	}
	
	/**
	 * @Description: 获取一个连接   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月18日 下午11:54:52
	 * @Version: 1.0.0
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DATASOURCE.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
