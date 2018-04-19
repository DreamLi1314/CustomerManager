package com.dreamli.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

	@Override
	public List<Customer> getAllCustomer() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
			return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Customer findCustById(String id) {
		String sql = "select * from customer where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
			return runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		String sql = "update customer set gender=?, birthday=?, cellphone=?, email=?, preference=?, type=?, description=? where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getDataSource());
			runner.update(sql, customer.getGender(), customer.getBirthday(), customer.getCellphone(),
					customer.getEmail(), customer.getPreference(), customer.getType(), customer.getDescription(),
					customer.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteCustomer(Connection connection, String delId) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner();
		runner.update(connection, sql, delId);
	}
}
