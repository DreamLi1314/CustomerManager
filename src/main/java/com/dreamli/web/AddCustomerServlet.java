package com.dreamli.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;
import com.dreamli.util.DaoUtil;
import com.mchange.v2.codegen.bean.BeangenUtils;

/**
 * @Description: 添加用户
 * @Warning:
 * @Author: dreamli
 * @Package: CustomerManager - com.dreamli.web.AddCustomerServlet.java
 * @Date: 2018年4月18日 上午12:08:27
 * @Version: 1.0.0
 */
@WebServlet("/servlet/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8"); 
		
		try {
			//1. 封装数据、校验数据
			Customer customer = new Customer();
			BeanUtils.populate(customer, request.getParameterMap());
			//1.1 对于兴趣爱好需要单独处理一下
			String[] preferences = request.getParameterValues("preference");
			String preference = Arrays.stream(preferences).collect(Collectors.joining(","));
			customer.setPreference(preference);
			//1.2 数据合法性校验
			//TODO 校验

			//2. 调用 Service 的方法将数据插入到数据库中----判断用户名是否存在
			CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);
			customerService.addCustomer(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		//3. 重定向回主页
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
