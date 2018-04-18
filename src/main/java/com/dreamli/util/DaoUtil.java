package com.dreamli.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtil {

	private final static DataSource DATASOURCE = new ComboPooledDataSource();
	
	private DaoUtil() {
	}
	
	
	public static DataSource getDataSource() {
		return DATASOURCE;
	}
	
}
