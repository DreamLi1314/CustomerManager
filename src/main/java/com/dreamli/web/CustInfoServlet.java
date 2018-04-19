package com.dreamli.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamli.domain.Customer;
import com.dreamli.factory.BasicFactory;
import com.dreamli.service.CustomerService;

@WebServlet("/servlet/CustInfoServlet")
public class CustInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		CustomerService customerService = BasicFactory.getFactory().getInstance(CustomerService.class);
		
		//1. 获取将要展示的客户 ID
		String id = request.getParameter("id");
		//2. 调用 service 的方法获取客户 bean, 并将其存入request 域中
		Customer customer = customerService.findCustById(id);
		if(customer == null) {
			throw new RuntimeException("指定 id 的客户不存在!");
		}
		request.setAttribute("cust", customer);
		//3. 请求转发到 updateCust.jsp
		request.getRequestDispatcher("/jsp/updateCust.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
