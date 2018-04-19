package com.dreamli.dao.impl;

import java.sql.Date;

import org.junit.Test;

import com.dreamli.dao.CustomerDao;
import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;

public class CustomerDaoImplTest {

	@Test
	public void testAddCustomer() {
		CustomerDao customerDao = BasicFactory.getFactory().getInstance(CustomerDao.class);
		for (int i = 0; i < 100; i++) {
			Customer customer = new Customer("test" + i, "男", new Date(30, 9, 9), "1881234567", "test@qq.com", "篮球", "没牌客户",
					"test" + i);
			customerDao.addCustomer(customer);
		}
		System.out.println("Executed...");
	}

}
