package com.dreamli.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dreamli.domain.Customer;
import com.dreamli.web.model.QueryCondition;

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

	/**
	 * @Description: 获取所有的客户信息   
	 * @Warning:
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午9:35:42
	 * @Version: 1.0.0
	 * @return 所有客户组成的集合
	 */
	List<Customer> getAllCustomer();

	/**
	 * @Description: 根据 id 查找客户信息   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午10:15:56
	 * @Version: 1.0.0
	 * @param id
	 * @return 封装了id对应客户信息的 bean
	 */
	Customer findCustById(String id);

	/**
	 * @Description: 更新客户信息   
	 * @Warning: 通过 ID 查找相应记录
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午11:12:55
	 * @Version: 1.0.0
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * @param connection 
	 * @Description: 根据 ID 删除对应客户的记录   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月19日 下午11:37:08
	 * @Version: 1.0.0
	 * @param delId
	 * @throws SQLException 
	 */
	void deleteCustomer(Connection connection, String delId) throws SQLException;

	/**
	 * @Description: 根据指定的条件查询客户集   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月21日 下午3:21:54
	 * @Version: 1.0.0
	 * @param condition
	 * @return
	 */
	List<Customer> getCustomersByCondition(QueryCondition condition);

	/**
	 * @Description: 从 form 处开始查询, 查询 count 条记录   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月21日 下午5:11:04
	 * @Version: 1.0.0
	 * @param from 开始的行号
	 * @param count 查询的行数
	 * @return
	 */
	List<Customer> getSubCustomersList(int from, int count);

	/**
	 * @Description: 查询客户总数   
	 * @Warning: 
	 * @Author: dreamli
	 * @Date: 2018年4月21日 下午5:21:29
	 * @Version: 1.0.0
	 * @return
	 */
	int getCustomerCount();

}
