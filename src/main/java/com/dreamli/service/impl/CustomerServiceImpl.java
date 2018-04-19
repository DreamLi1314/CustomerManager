package com.dreamli.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dreamli.dao.CustomerDao;
import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;
import com.dreamli.util.DaoUtil;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = BasicFactory.getFactory().getInstance(CustomerDao.class);

	@Override
	public void addCustomer(Customer customer) {
		//1. 检查用户名是否已经存在
		Customer cust = customerDao.findCustByName(customer.getName());
		if(cust != null) {
			throw new RuntimeException("客户姓名已经存在!");
		}
		
		//2.调用 dao 的方法将客户加入数据库
		customerDao.addCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer findCustById(String id) {
		return customerDao.findCustById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomers(String[] delIds) {
		if(delIds == null || delIds.length == 0) {
			return;
		}
		
		Connection connection = DaoUtil.getConnection();
		try {
			connection.setAutoCommit(false);
			for (String delId : delIds) {
				customerDao.deleteCustomer(connection, delId);
			}
			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("删除客户出错!");
		}
	}
}
