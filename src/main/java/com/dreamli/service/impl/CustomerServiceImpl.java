package com.dreamli.service.impl;

import com.dreamli.dao.CustomerDao;
import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;

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
	
	
	
	
	
	
}
