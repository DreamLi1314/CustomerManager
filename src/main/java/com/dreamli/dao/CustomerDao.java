package com.dreamli.dao;

import com.dreamli.domain.Customer;

public interface CustomerDao {

	/**
	 * @Description: 根据客户姓名查询客户   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月18日 下午11:51:15
	 * @Version: 1.0.0
	 * @param name
	 * @return
	 */
	Customer findCustByName(String name);

	/**
	 * @Description: 添加客户   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月18日 下午11:52:34
	 * @Version: 1.0.0
	 * @param customer
	 */
	void addCustomer(Customer customer);

}
