package com.dreamli.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dreamli.dao.CustomerDao;
import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;
import com.dreamli.util.DaoUtil;
import com.dreamli.web.model.PageInfo;
import com.dreamli.web.model.QueryCondition;

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

	@Override
	public List<Customer> getCustomersByCondition(QueryCondition condition) {
		return customerDao.getCustomersByCondition(condition);
	}

	@Override
	public void pagingQueryCusts(PageInfo page) {
		//1.校验数据合法性
		if(page.getCurrentPage() <= 0) {
			page.setCurrentPage(1);
		}
		if(page.getPageRows() <= 0) {
			page.setPageRows(10);
		}
			
		//2.调用 dao 查询当前页面所要显示的客户信息
		//2.1 查询当前页的客户集合
		List<Customer> customers = customerDao.getSubCustomersList((page.getCurrentPage() - 1) * page.getPageRows(), page.getPageRows());
		//2.2 查询总的记录数
		int count = customerDao.getCustomerCount();
		
		//3. 封装数据, 组织 page 
		page.setPageCusts(customers);
		page.setRowCount(count);
		page.setPrePage(page.getCurrentPage() <= 1 ? 1 : page.getCurrentPage() - 1);
		page.setPageCount(count / page.getPageRows() + (count % page.getPageRows() > 0 ? 1 : 0));
		page.setNextPage(page.getCurrentPage() >= page.getPageCount() ? page.getPageCount() : page.getCurrentPage() + 1);
		
		if(page.getPageCount() == 0) {
			page.setFirstPage(1);
			page.setLastPage(1);
		}
		else if(page.getPageCount() < 5) {
			page.setFirstPage(1);
			page.setLastPage(page.getPageCount());
		} else {
			if(page.getCurrentPage() <= 3) {
				page.setFirstPage(1);
				page.setLastPage(5);
			} else if(page.getPageCount() - page.getCurrentPage() <= 3) {
				page.setLastPage(page.getPageCount());
				page.setFirstPage(page.getPageCount() - 4);
			} else {
				page.setFirstPage(page.getCurrentPage() - 2);
				page.setLastPage(page.getCurrentPage() + 2);
			}
		}
	}
}
