package com.dreamli.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;

@WebServlet("/servlet/CustList")
public class CustListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);

		// 1. 获取所有的客户
		List<Customer> customers = customerService.getAllCustomer();
		// 2. 将客户集合放到 request 域中
		request.setAttribute("customers", customers);
		// 3. 请求转发到 custList.jsp
		request.getRequestDispatcher("/jsp/custList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
