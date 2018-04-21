package com.dreamli.service;

import java.util.List;

import com.dreamli.domain.Customer;
import com.dreamli.web.model.PageInfo;
import com.dreamli.web.model.QueryCondition;

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

	/**
	 * @Description: 获取所有的客户信息 
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午7:21:38
	 * @Version: 1.0.0
	 * @return 所有客户所组成的集合
	 */
	List<Customer> getAllCustomer();

	/**
	 * @Description: 获取指定 ID 的客户信息   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午10:13:46
	 * @Version: 1.0.0
	 * @param id
	 * @return
	 */
	Customer findCustById(String id);

	/**
	 * @Description: 更新客户信息   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午11:10:47
	 * @Version: 1.0.0
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * @Description: 删除指定ID的客户信息   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午11:33:23
	 * @Version: 1.0.0
	 * @param delIds 待删除客户的ID
	 */
	void deleteCustomers(String[] delIds);

	/**
	 * @Description: 条件查询客户   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月21日 下午3:18:00
	 * @Version: 1.0.0
	 * @param condition
	 * @return 
	 */
	List<Customer> getCustomersByCondition(QueryCondition condition);

	/**
	 * @Description: 分页查询客户信息   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月21日 下午4:52:59
	 * @Version: 1.0.0
	 * @param page
	 */
	void pagingQueryCusts(PageInfo page);

}
