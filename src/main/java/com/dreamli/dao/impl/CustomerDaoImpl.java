package com.dreamli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dreamli.dao.CustomerDao;
import com.dreamli.domain.Customer;
import com.dreamli.util.DaoUtil;

/**
 * @Description: 具体的 dao 实现 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.dao.impl.CustomerDaoImpl.java
 * @Date: 2018年4月19日 上午12:00:36
 * @Version: 1.0.0
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer findCustByName(String name) {
		String sql = "select * from customer where name=?";
		QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<Customer>(Customer.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		String sql = "insert into customer values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
			runner.update(sql, null, customer.getName(), customer.getGender(), customer.getBirthday(),
					customer.getCellphone(), customer.getEmail(), customer.getPreference(), customer.getType(),
					customer.getDescription());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
