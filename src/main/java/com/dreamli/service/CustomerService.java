package com.dreamli.service;

import com.dreamli.domain.Customer;

public interface CustomerService extends BasicService {

	/**
	 * @Description: 添加客户   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月18日 下午11:49:16
	 * @Version: 1.0.0
	 * @param customer
	 */
	void addCustomer(Customer customer);

}
