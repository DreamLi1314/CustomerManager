package com.dreamli.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;

@WebServlet("/servlet/UpdateCustServlet")
public class UpdateCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);
		
		try {
			//1. 封装数据， 校验数据
			Customer customer = new Customer();
			BeanUtils.populate(customer, request.getParameterMap());
			//1.1 需要单独处理 preference
			String[] preferences = request.getParameterValues("preference");
			String preference = Arrays.stream(preferences).collect(Collectors.joining(","));
			customer.setPreference(preference);
			
			//1.2 数据合法性校验
			//TODO 校验
			
			//2. 调用Service 的方法更新数据
			customerService.updateCustomer(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3. 重定向到客户列表页面
		response.sendRedirect(request.getContextPath() + "/servlet/CustList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
