package com.dreamli.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;
import com.dreamli.web.model.QueryCondition;

/**
 * @Description: 条件查询客户集合 
 * @Warning: 
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.web.CustConditionList.java
 * @Date: 2018年4月21日 下午3:12:46
 * @Version: 1.0.0
 */
@WebServlet("/servlet/CustConditionList")
public class CustConditionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);
		
		try {
			//1. 将查询条件封装到 bean
			QueryCondition condition = new QueryCondition();
			BeanUtils.populate(condition, request.getParameterMap());
			
			//2. 调用 service 方法得到查询结果, 并将其存到 request 域中
			List<Customer> customers = customerService.getCustomersByCondition(condition);
			
			request.setAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		//3. 请求转发到客户列表页面
		request.getRequestDispatcher("/jsp/custList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
